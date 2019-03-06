package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.BranchInfo;

public interface BranchInfoMapper {
    int insert(BranchInfo record);

    int insertSelective(BranchInfo record);
}