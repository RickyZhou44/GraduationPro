package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.UploadParam;

public interface UploadParamMapper {
    int insert(UploadParam record);

    int insertSelective(UploadParam record);
}