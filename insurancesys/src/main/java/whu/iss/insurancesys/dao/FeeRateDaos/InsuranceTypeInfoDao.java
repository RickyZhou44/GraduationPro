package whu.iss.insurancesys.dao.FeeRateDaos;

import org.apache.ibatis.annotations.Param;
import whu.iss.insurancesys.entity.FeeRateEntities.InsuranceTypeInfo;

import java.util.Date;
import java.util.List;

public interface InsuranceTypeInfoDao {

    int insert(InsuranceTypeInfo record);

    int insertSelective(InsuranceTypeInfo record);

    List<InsuranceTypeInfo> getByParam(@Param("company")String company,
                                       @Param("insuranceCname")String insuranceCname,
                                       @Param("insuranceSname")String insuranceSname,
                                       @Param("code")String code,
                                       @Param("mainOrVice")String mainOrVice,
                                       @Param("paramType")String paramType,
                                       @Param("startFrom")Date startFrom,
                                       @Param("startTo")Date startTo,
                                       @Param("endFrom")Date endFrom,
                                       @Param("endTo")Date endTo);

    InsuranceTypeInfo getById(@Param("id")int id);

    int update(@Param("insurId")int insurId,
                @Param("mainOrVice")String mainOrVice,
                @Param("insuranceType")String insuranceType,
                @Param("insuranceCname")String insuranceCname,
                @Param("insuranceSname")String insuranceSname,
                @Param("paramType")String paramType,
                @Param("commonYear")String commonYear,
                @Param("startDate")Date start,
                @Param("endDate")Date end,
                @Param("remark")String remark);

    int deleteByinsurId(@Param("insurId")int insurId);

}