package whu.iss.insurancesys.service.impl;

import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.PersonalPerformanceWaringObjectResultDao;
import whu.iss.insurancesys.entity.PersonalPerformanceWaringObjectResult;
import whu.iss.insurancesys.service.PersonalPerformanceWarningService;

import javax.annotation.Resource;

@Service
public class PersonalPerformanceWarningServiceImpl implements PersonalPerformanceWarningService {

    @Resource
    private PersonalPerformanceWaringObjectResultDao personalPerformanceWaringObjectResultDao;

    @Override
    public PersonalPerformanceWaringObjectResult getPeopleInfo(String name, String number, String idCard, String[] branchs) {
        return personalPerformanceWaringObjectResultDao.findAll(name, number, idCard, branchs);
    }
}
