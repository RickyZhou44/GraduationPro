package whu.iss.insurancesys.service.impl;

import org.springframework.stereotype.Service;
import whu.iss.insurancesys.service.ExcelService;
import whu.iss.insurancesys.util.ExcelUtil;



/**
 * @author RickZhou
 *         Created by RickZhou on 2019/3/12 0012.
 */
@Service
public class ExcelServiceImpl implements ExcelService {

//    该方法调用ExcelUtil来实现excel文件的导入到指定位置
    @Override
    public boolean exportExcel(String fileName, Integer pageNum, Integer pageSize) {
        System.out.println("开始导出excel");
        if(fileName.equals("")){
            System.out.println("名字不能为空");
            return false;
        }
        else if(!fileName.endsWith(".xlsx")){
            System.out.println();
            return false;
        }
        else {
            ExcelUtil.exportExcel();
            return true;
        }


    }

    @Override
    public boolean importExcel(String name) {
        System.out.println("开始导入excel");
        if(name.equals("")){
            System.out.println("名字不能为空");
            return false;
        }
        else if(!name.endsWith(".xlsx")){
            System.out.println();
            return false;
        }
        else {
            ExcelUtil.importExcel(name);
            return true;
        }
    }
}
