package whu.iss.insurancesys.service.impl;

/*
 * @Author SeanShe
 * @Date 3/25/2019 12:52
 * Notes:
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.FeeRateDaos.CheckInsurRuleDao;
import whu.iss.insurancesys.dao.FeeRateDaos.ParamDao;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.FeeRateEntities.CheckInsurRule;
import whu.iss.insurancesys.service.CheckInsurRuleService;

import java.util.*;

//费率模块 2
@Service
public class CheckInsurRuleServiceImpl implements CheckInsurRuleService {

    @Autowired
    CheckInsurRuleDao checkInsurRuleDao;

    @Autowired
    ParamDao paramDao;

    public ResultInfo queryCheckInsurRule(List<String> companyNames, List<String> branchNames,
                                        Date from, Date to, String name){

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(true);
        resultInfo.setData(checkInsurRuleDao.getByParam(companyNames, branchNames, from, to, name));
        return resultInfo;

    }

    public ResultInfo deleteCheckInsurRule(int id){

        int res = checkInsurRuleDao.deleteById(id);
        ResultInfo resultInfo = new ResultInfo();
        if(res > 0){
            resultInfo.setResult(true);
        }else {
            resultInfo.setResult(false);
        }
        return resultInfo;

    }

    public ResultInfo addCheckInsurRule(CheckInsurRule checkInsurRule){

        int res = checkInsurRuleDao.insertSelective(checkInsurRule);
        ResultInfo resultInfo = new ResultInfo();
        if(res > 0){
            resultInfo.setResult(true);
        }else {
            resultInfo.setResult(false);
        }
        return resultInfo;


    }

    public ResultInfo getCompanyNames(){

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(true);
        resultInfo.setData(paramDao.getAllCompanyName());
        return resultInfo;

    }

    public ResultInfo queryAllBranchName(List<String> companyNames){

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(true);
        Set<String> result = new HashSet<>();
        companyNames.forEach(item -> {
            result.addAll(queryBranchNames(item));
        });
        resultInfo.setData(new ArrayList<>(result));
        return resultInfo;

    }

    private List<String> queryBranchNames(String companyName){

        return paramDao.getBranchName(companyName);

    }

}
