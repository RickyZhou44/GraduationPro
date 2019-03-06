package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.ClaimTraceRecord;

public interface ClaimTraceRecordMapper {
    int insert(ClaimTraceRecord record);

    int insertSelective(ClaimTraceRecord record);
}