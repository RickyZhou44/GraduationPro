package whu.iss.insurancesys.service;

import whu.iss.insurancesys.entity.HumanCapital.EmployeeRankChangeInfo;

import java.util.List;
import java.util.Map;

public interface EmployeeRankChangeService {
    public boolean addRankChange(EmployeeRankChangeInfo rankChangeInfo);

    public List<Map<String,String>> getRankChangeByNum(String staffNo);
}
