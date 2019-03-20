package whu.iss.insurancesys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import whu.iss.insurancesys.dto.ResultInfo;

/**
 * @author RickZhou
 *         Created by RickZhou on 2019/3/13 0013.
 */
//此类用于处理业务数据重新组织
@RestController
public class DataReorganizeController {
    @RequestMapping("/dataRecorganize")
    public Object dataRecorg(){
        ResultInfo resultInfo=new ResultInfo();

        return resultInfo;
    }
}
