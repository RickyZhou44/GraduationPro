package whu.iss.insurancesys.service;

/*
 * @Author SeanShe
 * @Date 3/25/2019 12:51
 * Notes:
 * */

import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.FeeRateEntities.CheckInsurRule;

import java.util.Date;
import java.util.List;

public interface CheckInsurRuleService {

    ResultInfo queryCheckInsurRule(List<String> companyNames, List<String> branchNames,
                                   Date from, Date to, String name);

    ResultInfo deleteCheckInsurRule(int id);

    ResultInfo addCheckInsurRule(CheckInsurRule checkInsurRule);

    ResultInfo getCompanyNames();

    ResultInfo queryAllBranchName(List<String> companyNames);

}
