package whu.iss.insurancesys.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import whu.iss.insurancesys.dao.EmployeeUnitRankDao;
import whu.iss.insurancesys.dao.HumanCapital.EmployeeRankChangeDao;
import whu.iss.insurancesys.entity.EmployeeUnitRank;
import whu.iss.insurancesys.entity.HumanCapital.EmployeeRankChangeInfo;
import whu.iss.insurancesys.service.EmployeeRankChangeService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeRankChangeServiceImpl implements EmployeeRankChangeService {

    @Resource
    private EmployeeRankChangeDao rankChangeDao;

    @Resource
    private EmployeeUnitRankDao unitRankDao;

    @Override
    @Transactional
    public boolean addRankChange( EmployeeRankChangeInfo rankChangeInfo) {
        EmployeeUnitRank unitRank = EmployeeRankChangeInfo.getUnitRankInfo(rankChangeInfo);
        return rankChangeDao.addRankChange(rankChangeInfo) == 1 && unitRankDao.update(unitRank) == 1;

    }

    @Override
    public List<Map<String, String>> getRankChangeByNum(String staffNo) {
        List<Map<String,String>> res = rankChangeDao.getRankChangeByNum(staffNo);
        return res;
    }
}
