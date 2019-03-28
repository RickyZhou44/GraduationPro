package whu.iss.insurancesys.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import whu.iss.insurancesys.dao.EmployeeBasicInformationDao;
import whu.iss.insurancesys.dao.EmployeeUnitRankDao;
import whu.iss.insurancesys.dao.HumanCapital.PersonRankDao;
import whu.iss.insurancesys.entity.EmployeeBasicInformation;
import whu.iss.insurancesys.entity.EmployeeUnitRank;
import whu.iss.insurancesys.entity.HumanCapital.EmployeeInfo;
import whu.iss.insurancesys.service.PersonRankService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class PersonRankServiceImpl implements PersonRankService {

    @Resource
    private PersonRankDao personRankDao;
//
    @Resource
    private EmployeeBasicInformationDao basicInfoDao;

    @Resource
    private EmployeeUnitRankDao unitRankDao;

    @Override
    public List<Map<String, String>> getPersonRankList(String staffNo, String staffName, String branch, String dept, String tel, String rank) {
        return personRankDao.getCustomerList(staffNo,staffName,branch,dept,rank,tel);
    }

    @Override
    public boolean deletePersonRankByNum(int num) {
        return personRankDao.deletePersonRankByNum(num) == 2;
    }

    @Override
    @Transactional
    public boolean addPersonRank(EmployeeInfo employeeInfo) {
        EmployeeBasicInformation basicInfo = EmployeeInfo.getBasicInfo(employeeInfo);
        EmployeeUnitRank unitInfo = EmployeeInfo.getUnitInfo(employeeInfo);
        return basicInfoDao.insert(basicInfo)==1 &&unitRankDao.insert(unitInfo) ==1;
    }

    @Override
    public Map<String, String> getPersonRankByNum(int num) {
        return personRankDao.getPersonRankByNum(num);
    }

    @Override
    @Transactional
    public boolean updatePersonRankOne(EmployeeInfo employeeInfo) {
        EmployeeBasicInformation  basicInfo = EmployeeInfo.getBasicInfo(employeeInfo);
        EmployeeUnitRank unitInfo = EmployeeInfo.getUnitInfo(employeeInfo);
        return basicInfoDao.update(basicInfo)==1 && unitRankDao.update(unitInfo)==1;
    }
}
