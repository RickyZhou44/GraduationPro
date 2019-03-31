package whu.iss.insurancesys.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import whu.iss.insurancesys.entity.ExcelData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.apache.poi.ss.usermodel.CellType.*;



/**
 * @author RickZhou
 *         Created by RickZhou on 2019/3/12 0012.
 */
public class ExcelUtil {
//方法名exportExcel
//功能导出excel
//同时也是这个类的入口
    public static void exportExcel(ExcelData data){
        //这里的filename是之前赋值的要存放的路径
        System.out.println("导出解析开始，fileName:"+data.getFilename());
        try {
            //实例化HSSFWorkbook
            HSSFWorkbook workbook = new HSSFWorkbook();
            //创建一个Excel表单，参数为sheet的名字
            HSSFSheet sheet = workbook.createSheet("sheet");
            //设置表头
            setTitle(workbook, sheet, data.getHead());
            //设置单元格并赋值
            setData(sheet, data.getData());
            //设置浏览器下载
            setBrowser(workbook, data.getFilename());
            System.out.println("导出解析成功!");
        } catch (Exception e) {
           System.out.println("导出解析失败!");
            e.printStackTrace();
        }
    }
    /**
     * 方法名：setTitle
     * 功能：设置表头
     */
    private static void setTitle(HSSFWorkbook workbook, HSSFSheet sheet, String[] str) {
        try {
            HSSFRow row = sheet.createRow(0);
            //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
            for (int i = 0; i <= str.length; i++) {
                sheet.setColumnWidth(i, 15 * 256);
            }
            //设置为居中加粗,格式化时间格式
            HSSFCellStyle style = workbook.createCellStyle();
            HSSFFont font = workbook.createFont();
            font.setBold(true);
            style.setFont(font);
            style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
            //创建表头名称
            HSSFCell cell;
            for (int j = 0; j < str.length; j++) {
                cell = row.createCell(j);
                cell.setCellValue(str[j]);
                cell.setCellStyle(style);
            }
        } catch (Exception e) {
            System.out.println("导出时设置表头失败！");
            e.printStackTrace();
        }
    }

//方法名：setData
//功能：将数据插入sheet中
    private static void setData(HSSFSheet sheet, List<String[]> data) {
        try{
            int rowNum = 1;
            for (int i = 0; i < data.size(); i++) {
                HSSFRow row = sheet.createRow(rowNum);
                for (int j = 0; j < data.get(i).length; j++) {
                    row.createCell(j).setCellValue(data.get(i)[j]);
                }
                rowNum++;
            }
           System.out.println("表格赋值成功！");
        }catch (Exception e){
            System.out.println("表格赋值失败！");
            e.printStackTrace();
        }
    }
    /**
     * 方法名：setBrowser
     * 功能：使用浏览器下载
     */
    private static void setBrowser( HSSFWorkbook workbook, String fileName) {
        try {
            //清空response
            //response.reset();
            //设置response的Header
            //response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            OutputStream os = new FileOutputStream(fileName);
           // response.setContentType("application/vnd.ms-excel;charset=gb2312");
            //将excel写入到输出流中
            workbook.write(os);
            os.flush();
            os.close();
            System.out.println("设置浏览器下载成功！");
        } catch (Exception e) {
            System.out.println("设置浏览器下载失败！");
            e.printStackTrace();
        }


    }

//    import excel文件
    public static List<Object[]> importExcel(String fileName) {
        System.out.println("导入解析开始，fileName:"+fileName);
        try {
            List<Object[]> list = new ArrayList<>();
            InputStream inputStream = new FileInputStream(fileName);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            //获取sheet的行数
            int rows = sheet.getPhysicalNumberOfRows();
            for (int i = 0; i < rows; i++) {
                //过滤表头行
                if (i == 0) {
                    continue;
                }
                //获取当前行的数据
                Row row = sheet.getRow(i);
                Object[] objects = new Object[row.getPhysicalNumberOfCells()];
                int index = 0;
                for (Cell cell : row) {
                    if (cell.getCellType().equals(NUMERIC)) {
                        objects[index] = (int) cell.getNumericCellValue();
                    }
                    if (cell.getCellType().equals(STRING)) {
                        objects[index] = cell.getStringCellValue();
                    }
                    if (cell.getCellType().equals(BOOLEAN)) {
                        objects[index] = cell.getBooleanCellValue();
                    }
                    if (cell.getCellType().equals(ERROR)) {
                        objects[index] = cell.getErrorCellValue();
                    }
                    index++;
                }
                list.add(objects);
            }
            System.out.println("导入文件解析成功！");
            return list;
        }catch (Exception e){
            System.out.println("导入文件解析失败！");
            e.printStackTrace();
        }
        return null;
    }

}
