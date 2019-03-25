package whu.iss.insurancesys.service.impl;

import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.PersonalPerformanceWaringDao;
import whu.iss.insurancesys.entity.PersonalPerformanceWarningEntities.*;
import whu.iss.insurancesys.service.PersonalPerformanceWarningService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PersonalPerformanceWarningServiceImpl implements PersonalPerformanceWarningService {

    @Resource
    private PersonalPerformanceWaringDao personalPerformanceWaringDao;

    @Override
    public List<PersonalPerformanceWaringObjectResult> getPeopleInfo(String name, long number, String idCard, String[] branchs) {
        return personalPerformanceWaringDao.findPersonInfo(name, number, idCard, branchs);
    }

    @Override
    public PersonalPerformanceWarningQueryResult query(long number, String insuranceKind, Date baseMonth, String project, String category, String period) {
        PersonalPerformanceWarningQueryResult result = personalPerformanceWaringDao.findOne(number);
        if (insuranceKind == "寿险") {
            List<LifeInsuranceFyc> lifeInsuranceFycs = personalPerformanceWaringDao.getLifeInsuranceFycBasicData(number, category, period, baseMonth);
            for (LifeInsuranceFyc item : lifeInsuranceFycs) {
                String s1 = item.getPeriod().substring(0, 2);
                String s2 = item.getPeriod().substring(2, 4);
                double rate = (Integer.parseInt(s2)) / Integer.parseInt(s1);
                double value = rate * item.getPremium();
                if (result.getLifeInsuranceCheckDetails() == null)
                    result.setLifeInsuranceCheckDetails(new ArrayList<LifeInsuranceCheckDetail>());
                LifeInsuranceCheckDetail lifeInsuranceCheckDetail = new LifeInsuranceCheckDetail(project, category, period, value);
                result.getLifeInsuranceCheckDetails().add(lifeInsuranceCheckDetail);
            }
        } else if (insuranceKind == "车险") {
            List<CarInsuranceFyc> carInsuranceFycs = personalPerformanceWaringDao.getCarInsuranceFycBasicData(number, category, period, baseMonth);
            for (CarInsuranceFyc item : carInsuranceFycs) {
                double value = item.getPremium() * (item.getCommissionRateIn() + item.getCommissionRateOut());
                if (result.getCarInsuranceCheckDetails() == null)
                    result.setCarInsuranceCheckDetails(new ArrayList<CarInsuranceCheckDetail>());
                CarInsuranceCheckDetail carInsuranceCheckDetail = new CarInsuranceCheckDetail(project, category, period, value);
                result.getCarInsuranceCheckDetails().add(carInsuranceCheckDetail);
            }
        }
        return result;
    }

}
