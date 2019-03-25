package whu.iss.insurancesys.service.impl;

import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.PersonalPerformanceWaringDao;
import whu.iss.insurancesys.entity.PersonalPerformanceWaringObjectResult;
import whu.iss.insurancesys.entity.PersonalPerformanceWarningQueryResult;
import whu.iss.insurancesys.service.PersonalPerformanceWarningService;

import javax.annotation.Resource;
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
    public PersonalPerformanceWarningQueryResult query(long number, String baseMonth, String project, String category, String period) {
        PersonalPerformanceWarningQueryResult result = personalPerformanceWaringDao.findOne(number);
        return null;
    }
}
