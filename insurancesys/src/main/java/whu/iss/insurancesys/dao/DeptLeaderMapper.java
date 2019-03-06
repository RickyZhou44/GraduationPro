package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.DeptLeader;

public interface DeptLeaderMapper {
    int insert(DeptLeader record);

    int insertSelective(DeptLeader record);
}