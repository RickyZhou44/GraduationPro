package whu.iss.insurancesys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import whu.iss.insurancesys.entity.ExcelData;
import whu.iss.insurancesys.util.ExcelUtil;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author RickZhou
 *         Created by RickZhou on 2019/3/11 0011.
 */
@RestController
public class ExcelController {
    @RequestMapping("/hi")
    public String helloHtml(HashMap<String, Object> map, HttpServletResponse response) {
        map.put("hello", "欢迎进入HTML页面");
        ExcelData data=new ExcelData();
        data.setFilename("testExcel.xlsx");
        String[]head={"1","2","3"};
        data.setHead(head);
        String[]content={"a","b","c"};
        List<String[]> addd=new ArrayList<>();
        addd.add(content);
        data.setData(addd);
        //ExcelUtil.exportExcel(response,data);
        return "index";
    }
}
