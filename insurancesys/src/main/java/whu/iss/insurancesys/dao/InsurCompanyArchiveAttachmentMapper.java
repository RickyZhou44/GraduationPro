package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.InsurCompanyArchiveAttachment;

public interface InsurCompanyArchiveAttachmentMapper {
    int insert(InsurCompanyArchiveAttachment record);

    int insertSelective(InsurCompanyArchiveAttachment record);
}