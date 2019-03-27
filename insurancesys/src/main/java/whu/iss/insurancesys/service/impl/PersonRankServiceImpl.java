package whu.iss.insurancesys.service.impl;

import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.HumanCapital.PersonRankDao;
import whu.iss.insurancesys.service.PersonRankService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class PersonRankServiceImpl implements PersonRankService {

    @Resource
    private PersonRankDao personRankDao;

    @Override
    public List<Map<String, String>> getPersonRankList(String staffNo, String staffName, String branch, String dept, String tel, String rank) {
        List<Map<String,String>> mapList = personRankDao.getCustomerList(staffNo,staffName,branch,dept,rank,tel);
        return mapList;
    }

    @Override
    public boolean deletePersonRankByNum(int num) {
        int res = personRankDao.deletePersonRankByNum(num);
        return res == 2 ;
    }

    @Override
    public Map<String, String> getPersonRankByNum(int num) {
        Map<String,String> res = personRankDao.getPersonRankByNum(num);
        return res;
    }
}
