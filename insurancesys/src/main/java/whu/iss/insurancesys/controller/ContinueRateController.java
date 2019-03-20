package whu.iss.insurancesys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import whu.iss.insurancesys.dto.ResultInfo;

/**
 * @author RickZhou
 *         Created by RickZhou on 2019/3/17 0017.
 */
@RestController
public class ContinueRateController {
    @RequestMapping("continueRate1")
    public Object continueRate1(){
        ResultInfo resultInfo=new ResultInfo();
        return resultInfo;
    }
}
