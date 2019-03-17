package whu.iss.insurancesys.controller;

/*
 * @Author SeanShe
 * @Date 3/6/2019 13:04
 * Notes:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import whu.iss.insurancesys.entity.SettlementParamEntities.FeeRateParam;
import whu.iss.insurancesys.entity.SettlementParamEntities.ParamTypeParam;
import whu.iss.insurancesys.service.SettlementParamService;

import java.util.List;

@RestController
@RequestMapping("/settlementParam")
public class SettlementParamController {

    @Autowired
    private SettlementParamService settlementParamService;

    @GetMapping("/getFeeRateParam")
    public List<FeeRateParam> getFeeRateParam(){

        return settlementParamService.getAllFeeRateParam();

    }

    @GetMapping("/getParamTypeParam")
    public List<ParamTypeParam> getParamTypeParam(){

        return settlementParamService.getAllParamTypeParam();

    }

}
