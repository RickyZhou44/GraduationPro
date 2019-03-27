package whu.iss.insurancesys.controller;

/*
 * @Author SeanShe
 * @Date 3/18/2019 13:18
 * Notes:
 * */

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import whu.iss.insurancesys.dto.InsurTypeInfoForQuery;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.FeeRateEntities.*;
import whu.iss.insurancesys.service.CarFeeRateService;
import whu.iss.insurancesys.service.CheckInsurRuleService;
import whu.iss.insurancesys.service.InsurRateService;
import whu.iss.insurancesys.service.SettleFeeParamService;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/feeRate")
public class FeeRateController {

    //模块 1 5 代理险种费用率
    @Autowired
    InsurRateService insurRateService;

    //模块 2 核保规则管理
    @Autowired
    CheckInsurRuleService checkInsurRuleService;

    //模块 3 车险费率
    @Autowired
    CarFeeRateService carFeeRateService;

    //模块 4 费率参数
    @Autowired
    SettleFeeParamService settleFeeParamService;

    //代理险种费用率
    @GetMapping("/insurRate/getCompanyNames")
    public Object getCompanyNames1(){

        return insurRateService.getCompanyName();

    }

    @PostMapping("/insurRate/queryInsurInfo")
    public Object queryInsurRate(@RequestBody InsurTypeInfoForQuery param){

        return insurRateService.queryInusrTypeInfo(param.getCompanies(), param.getInsuranceCname(),
                param.getCode(), param.getMainOrVice(), param.getParamType(), param.getStartFrom(),
                param.getStartTo(), param.getEndFrom(), param.getEndTo());

    }

    @PostMapping("/insurRate/deleteInsurInfo")
    public Object deleteInsurInfo(@RequestBody Map<String, Object> map){

        int id = (int) map.get("insurId");
        return insurRateService.deleteInsuranceTypeInfo(id);

    }

    @PostMapping("/insurRate/addInsurInfo")
    public Object addInsurInfo(@RequestBody InsuranceTypeInfo info){

        return insurRateService.addInsuranceTypeInfo(info);

    }

    @PostMapping("/insurRate/updateInsurInfo")
    public Object updateInsurInfo(@RequestBody InsuranceTypeInfo info){

        return insurRateService.modifyInsuranceTypeInfo(info);

    }

    @PostMapping("/insurRate/updateInsurInfoCommonYearOnly")
    public Object updateInsurInfoCommonYearOnly(@RequestBody Map<String, Object> map){

        int id = (int) map.get("insurId");
        String commonYear = (String) map.get("commonYear");
        return insurRateService.modifyCommonYear(id, commonYear);

    }

    @PostMapping("/insurRate/queryInsurInfoFeeRate")
    public Object queryInsurInfoFeeRate(@RequestBody Map<String, Object> map){

        int id = (int) map.get("insurId");
        return insurRateService.queryFeeRates(id);

    }

    @PostMapping("/insurRate/deleteInsurInfoFeeRate")
    public Object deleteInsurInfoFeeRate(@RequestBody Map<String, Object> map){

        int id = (int) map.get("insurId");
        String year = (String) map.get("year");
        return insurRateService.deleteCommonYear(id, year);

    }

    @PostMapping("/insurRate/addInsurInfoFeeRate")
    public Object addInsurInfoFeeRate(@RequestBody Map<String, Object> map){

        int id = (int) map.get("insurId");
        Date from = new Date((String) map.get("validateDateStart"));
        Date to = new Date((String) map.get("validateDateEnd"));
        String inOrOut = (String) map.get("inOrOut");
        String feeRateParam = (String) map.get("FeeRateParam");
        String rateString = (String)map.get("rates");
        double[] rates = strToDoubleArray(rateString);
        SettleAccountParam settleAccountParam = new SettleAccountParam();
        settleAccountParam.setInsurId(id);
        settleAccountParam.setValidateDateStart(from);
        settleAccountParam.setValidateDateEnd(to);
        settleAccountParam.setInOrOut(inOrOut);
        settleAccountParam.setFeeRateParam(feeRateParam);
        return insurRateService.addFeeRate(settleAccountParam, rates);

    }

    @PostMapping("/insurRate/updateInsurInfoFeeRate")
    public Object updateInsurInfoFeeRate(@RequestBody Map<String, Object> map){

        int id = (int) map.get("insurId");
        Date from = new Date((String) map.get("validateDateStart"));
        Date to = new Date((String) map.get("validateDateEnd"));
        String inOrOut = (String) map.get("inOrOut");
        String feeRateParam = (String) map.get("FeeRateParam");
        String rateString = (String)map.get("rates");
        double[] rates = strToDoubleArray(rateString);
        SettleAccountParam settleAccountParam = new SettleAccountParam();
        settleAccountParam.setInsurId(id);
        settleAccountParam.setValidateDateStart(from);
        settleAccountParam.setValidateDateEnd(to);
        settleAccountParam.setInOrOut(inOrOut);
        settleAccountParam.setFeeRateParam(feeRateParam);
        return insurRateService.modifyFeeRate(settleAccountParam, rates);

    }

    private static double[] strToDoubleArray(String str){

        if(str == null){

            return new double[0];

        }
        String[] strs = str.split(" ");
        double[] doubles = new double[strs.length];
        for (int i = 0; i < strs.length; i++) {

            doubles[i] = Double.parseDouble(strs[i]);

        }
        return doubles;

    }

    @PostMapping("/insurRate/queryInsurRate")
    public Object queryInsurRate(@RequestBody Map<String, Object> map){

        int id = (int) map.get("insurId");
        return insurRateService.queryFeeRates(id);

    }

    @PostMapping("/insurRate/queryInsurInfoPlus")
    public Object queryInsurInfoPlus(@RequestBody Map<String, Object> map){

        String company = (String) map.get("company");
        String insuranceCname = (String) map.get("insuranceCname");
        String insuranceSname = (String) map.get("insuranceSname");
        String code = (String) map.get("code");
        String mainOrVice = (String) map.get("mainOrVice");
        String paramType = (String) map.get("paramType");
        String startFrom = (String) map.get("startFrom");

        if(startFrom == null){

            return insurRateService.queryInusrTypeInfoPlus(company, insuranceCname, insuranceSname, code, mainOrVice,
                    paramType, null, null, null, null);

        }else {

            String startTo = (String) map.get("startTo");
            String endFrom  = (String) map.get("endFrom");
            String endTo = (String) map.get("endTo");
            return insurRateService.queryInusrTypeInfoPlus(company, insuranceCname, insuranceSname, code, mainOrVice,
                    paramType, new Date(startFrom), new Date(startTo), new Date(endFrom), new Date(endTo));

        }

    }

    @PostMapping("/insurRate/modifyClick")
    public Object modifyClick(@RequestBody Map<String, Object> map){

        String id = (String) map.get("ids");
        int[] ids = strToIntegerArray(id);
        String from = (String) map.get("validateDateStart");
        String to = (String) map.get("validateDateEnd");
        String rateString = (String)map.get("rates");
        double[] rates = strToDoubleArray(rateString);
        return insurRateService.modifyClick(ids, from==null?null:new Date(from), to==null?null:new Date(to), rates);

    }

    private static int[] strToIntegerArray(String str){

        if(str == null){

            return new int[0];

        }
        String[] strs = str.split(" ");
        int[] ints = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {

            ints[i] = Integer.parseInt(strs[i]);

        }
        return ints;

    }

    @PostMapping("/insurRate/deleteClick")
    public Object deleteClick(@RequestBody List<DeleteInfo> deleteInfos){

        return insurRateService.deleteClick(deleteInfos);

    }

    @GetMapping("/insurRate/exportInsurInfo")
    public void exportInsurInfo(@RequestParam("heads")String[]heads,@RequestParam("path") String path, HttpSession session){

        List<InsuranceTypeInfo> insuranceTypeInfos = (ArrayList<InsuranceTypeInfo>) session.getAttribute("insurInfoData");
        insurRateService.exportInsurInfo(path, insuranceTypeInfos, heads);

    }

    //核保规则管理
    @GetMapping("/checkInsurRule/getCompanyNames")
    public Object getCompanyNames2(){

        return checkInsurRuleService.getCompanyNames();

    }

    @PostMapping("/checkInsurRule/queryAllBranchName")
    public Object queryAllBranchName(@RequestParam("companyNames") List<String> companyNames){

        return checkInsurRuleService.queryAllBranchName(companyNames);

    }

    @PostMapping("/checkInsurRule/queryInsurRule")
    public Object queryInsurRule(@RequestParam("companyNames") List<String> companyNames,
                                 @RequestParam("branchNames") List<String> branchNames,
                                 @RequestParam("dateFrom") String from, @RequestParam("DateTo") String to,
                                 @RequestParam("title") String name){

        if(from != null && to != null){

            return checkInsurRuleService.queryCheckInsurRule(companyNames, branchNames, new Date(from), new Date(to), name);

        }else {

            return checkInsurRuleService.queryCheckInsurRule(companyNames, branchNames, null, null, name);

        }

    }

    @PostMapping("/checkInsurRule/addInsurRule")
    public Object queryAllBranchName(@RequestBody CheckInsurRule rule){

        return checkInsurRuleService.addCheckInsurRule(rule);

    }

    @PostMapping("/checkInsurRule/deleteInsurRule")
    public Object deleteInsurRule(@RequestBody Map<String, Object> map){

        int id = (int) map.get("id");
        return checkInsurRuleService.deleteCheckInsurRule(id);

    }

    //车险费率
    @GetMapping("/carFeeRate/getCompanyNames")
    public Object getCompanyNames3(){

        return carFeeRateService.getCompanyNames();

    }

    @GetMapping("/carFeeRate/getBranchNames")
    public Object getBranchNames(){

        return carFeeRateService.getBranchNames();

    }

    @PostMapping("/carFeeRate/queryCarFeeRate")
    public Object queryCarFeeRate(@RequestParam("companyNames") List<String> companyNames,
                                  @RequestParam("branchNames") List<String> branchNames){

        return carFeeRateService.queryCarFeeRates(companyNames, branchNames);

    }

    //费率参数
    @GetMapping("/settleFeeParam/getParamTypeParam")
    public Object getParamTypeParam(){

        return settleFeeParamService.getParamTypeParam();

    }

    @GetMapping("/settleFeeParam/getFeeRateParam")
    public Object getFeeRateParam(){

        return settleFeeParamService.getFeeRateParam();

    }

}
