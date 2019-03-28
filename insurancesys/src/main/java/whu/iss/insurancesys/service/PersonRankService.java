package whu.iss.insurancesys.service;

import whu.iss.insurancesys.entity.HumanCapital.EmployeeInfo;

import java.util.List;
import java.util.Map;

public interface PersonRankService {

    public List<Map<String,String>> getPersonRankList(String staffNo, String staffName, String branch, String dept, String tel, String rank);

    public boolean deletePersonRankByNum(int num);

    public boolean addPersonRank(EmployeeInfo employeeInfo);

    public Map<String,String> getPersonRankByNum(int num);

    public boolean updatePersonRankOne(EmployeeInfo employeeInfo);
}
