package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.CarInsuranceAttachmentInfo;

public interface CarInsuranceAttachmentInfoMapper {
    int insert(CarInsuranceAttachmentInfo record);

    int insertSelective(CarInsuranceAttachmentInfo record);
}