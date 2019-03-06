package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.CertificateTypeParam;

public interface CertificateTypeParamMapper {
    int insert(CertificateTypeParam record);

    int insertSelective(CertificateTypeParam record);
}