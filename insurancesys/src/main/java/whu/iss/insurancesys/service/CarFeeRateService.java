package whu.iss.insurancesys.service;

/*
 * @Author SeanShe
 * @Date 3/21/2019 15:14
 * Notes:
 * */

import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.FeeRateEntities.CarInsuranceTypePlus;

import java.util.List;

public interface CarFeeRateService {

    ResultInfo getCompanyNames();

    ResultInfo getBranchNames();

    ResultInfo queryCarFeeRates(List<String> companyNames, List<String> branchNames);

}
