package whu.iss.insurancesys.dao;

import whu.iss.insurancesys.entity.DocumentTypeParam;

public interface DocumentTypeParamMapper {
    int insert(DocumentTypeParam record);

    int insertSelective(DocumentTypeParam record);
}