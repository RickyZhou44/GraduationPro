package whu.iss.insurancesys.controller;

import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import whu.iss.insurancesys.entity.customer.CustomerBaseInfo;
import whu.iss.insurancesys.service.impl.CustomerServiceImpl;
import whu.iss.insurancesys.service.impl.PersonRankServiceImpl;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/export")
public class ExportController {

    @Resource
    private PersonRankServiceImpl personRankService;

    @Resource
    private CustomerServiceImpl customerService;

    private static Map<String,String> customerFields = new HashMap<>();

    private static Map<String,String> personRankFields = new HashMap<>();

    static {
        customerFields.put("clientName", "客户姓名");
        customerFields.put("idCard", "身份证号");
        customerFields.put("sex", "性别");
        customerFields.put("address", "客户联系地址");
        customerFields.put("email", "客户联系邮箱");
        customerFields.put("tel", "客户联系电话");
        customerFields.put("birthday", "出生日期");
        customerFields.put("clientType", "客户类型");
    }

    static {
        personRankFields.put("staffNo", "员工编号");
        personRankFields.put("staffName", "员工姓名");
        personRankFields.put("staffSex", "性别");
        personRankFields.put("branch", "分支机构");
        personRankFields.put("dept", "部门");
        personRankFields.put("rank", "职级");
        personRankFields.put("joinDate", "入司日期");
        personRankFields.put("validDate", "职级生效日期");
        personRankFields.put("birthday", "出生年月");
        personRankFields.put("tel", "联系电话");
    }

    @GetMapping("/personRank")
    public void exportPersonRank(HttpServletResponse response, @RequestParam("fields")String []fields,
                                 @Max(50)@RequestParam("staffNo") String staffNo,
                                 @Max(50)@RequestParam("staffName") String staffName,
                                 @Max(50)@RequestParam("branch") String branch,
                                 @Max(50)@RequestParam("dept") String dept,
                                 @Max(11)@RequestParam("tel") String tel,
                                 @Max (50)@RequestParam("rank") String rank,
                                 @NotNull @RequestParam(value = "fileType") String fileType) throws IOException{
        List<Map<String,String>> data = personRankService.getPersonRankList(staffNo,staffName,branch,dept,tel,rank);
        if(fileType.equals("txt")){
            exportTxt(response,data,fields,personRankFields);
            return;
        }
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        setHeaders(sheet, fields, personRankFields);
        setData(data, fields, sheet);
        writeFile(response, workbook, fileType);
    }

    @GetMapping("/customer")
    public void exportCustomer(HttpServletResponse response, @RequestParam("fields")String []fields,
                           @Max(value = 20, message = "clientName's length should less then 20") @RequestParam(value = "clientName") String clientName,
                           @Max (value = 50) @RequestParam(value = "idCard") String idCard,
                           @Max (value = 100) @RequestParam(value = "address") String address,
                           @Max (value = 20)@RequestParam(value = "tel") String tel,
                           @Email @Max(value = 50) @RequestParam(value = "email") String email,
                           @RequestParam(value = "clientType")String[] clientType,
                           @RequestParam(value = "sex")String[] sex,
                           @NotNull @RequestParam(value = "fileType") String fileType) throws IOException {
        List<Map<String,String>> data = customerService.getCustomerList(clientName, idCard, address, tel, email,
                CustomerBaseInfo.clientType2clientTypeEnum(clientType), CustomerBaseInfo.sex2sexEnum(sex));
        if(fileType.equals("txt")){
            exportTxt(response,data,fields,customerFields);
            return;
        }
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        setHeaders(sheet, fields, customerFields);
        setData(data, fields, sheet);
        writeFile(response, workbook, fileType);
    }

    private static void setHeaders(HSSFSheet sheet, String [] fields, Map<String,String> fieldsName){
        HSSFRow row = sheet.createRow(0);
        int index = 0;
        for(String s: fields){
            HSSFCell cell = row.createCell(index++);
            HSSFRichTextString textString = new HSSFRichTextString(fieldsName.get(s));
            cell.setCellValue(textString);
        }
    }

    private static void exportTxt(HttpServletResponse response, List<Map<String,String>> data, String [] fields,
                                  Map<String,String> fieldsName){
        String fileName = "export-data.txt";
        StringBuffer content = new StringBuffer();
        for(String s: fields){
            content.append(fieldsName.get(s));
            content.append("\t");
        }
        content.append("\n");
        Iterator<Map<String,String>> iterator = data.iterator();
        while (iterator.hasNext()){
            Map<String,String> item = iterator.next();
            for(String s: fields){
                content.append(item.get(s));
                content.append("\t");
            }
            content.append("\n");
        }
        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        ServletOutputStream outputStream = null;
        BufferedOutputStream buffer = null;
        try {
            outputStream = response.getOutputStream();
            buffer = new BufferedOutputStream(outputStream);
            buffer.write(content.toString().getBytes("UTF-8"));
            buffer.flush();
            buffer.close();
            outputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void setData(List<Map<String,String>> data, String [] fields, HSSFSheet sheet){
        int index = 0;
        Iterator<Map<String, String>> iterator = data.iterator();
        while (iterator.hasNext()){
            Map<String,String> item = iterator.next();
            HSSFRow row = sheet.createRow(++index);
            int offset = 0;
            for(String s: fields){
                HSSFCell cell = row.createCell(offset++);
                HSSFRichTextString textString = new HSSFRichTextString(String.valueOf(item.get(s)));
                cell.setCellValue(textString);
            }
        }
    }

    private static void writeFile(HttpServletResponse response, HSSFWorkbook workbook, String fileType) throws IOException{
        response.setContentType("application/octet-stream;charset=UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=export-data."+fileType);//默认Excel名称
        response.setCharacterEncoding("UTF-8");
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
}
