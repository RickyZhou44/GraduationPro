package whu.iss.insurancesys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.iss.insurancesys.service.ExcelService;
import whu.iss.insurancesys.util.ExcelUtil;

import javax.servlet.http.HttpServletResponse;

/**
 * @author RickZhou
 *         Created by RickZhou on 2019/3/12 0012.
 */
@Service
public class ExcelServiceImpl implements ExcelService {

    @Override
    public boolean exportExcel(HttpServletResponse response, String fileName, Integer pageNum, Integer pageSize) {
        System.out.println("开始导出excel");
        if(fileName.equals("")){
            System.out.println("名字不能为空");
        }

        return false;
    }

    @Override
    public boolean importExcel(String name) {
        return false;
    }
}
