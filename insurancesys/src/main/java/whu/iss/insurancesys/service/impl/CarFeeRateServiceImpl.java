package whu.iss.insurancesys.service.impl;

/*
 * @Author SeanShe
 * @Date 3/21/2019 15:14
 * Notes:
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.FeeRateDaos.CarInsuranceTypeDao;
import whu.iss.insurancesys.dao.FeeRateDaos.ParamDao;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.FeeRateEntities.CarInsuranceTypePlus;
import whu.iss.insurancesys.service.CarFeeRateService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//费率模块 3
@Service
public class CarFeeRateServiceImpl implements CarFeeRateService {

    @Autowired
    ParamDao paramDao;

    @Autowired
    CarInsuranceTypeDao carInsuranceTypeDao;

    public ResultInfo getCompanyNames() {

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(true);
        resultInfo.setData(paramDao.getAllCompanyName());
        return resultInfo;

    }

    public ResultInfo getBranchNames() {

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(true);
        resultInfo.setData(paramDao.getAllBranchName());
        return resultInfo;

    }

    private List<CarInsuranceTypePlus> queryCarInsuranceTypes(List<String> companyNames){

        return carInsuranceTypeDao.getByName(companyNames);

    }

    public ResultInfo queryCarFeeRates(List<String> companyNames, List<String> branchNames){

        ResultInfo resultInfo = new ResultInfo();
        ArrayList<CarInsuranceTypePlus> types = (ArrayList<CarInsuranceTypePlus>) queryCarInsuranceTypes(companyNames);
        resultInfo.setResult(true);
        resultInfo.setData(types.stream().filter(t -> branchNames.contains(t.getBranchName())).collect(Collectors.toList()));
        return resultInfo;

    }

}
