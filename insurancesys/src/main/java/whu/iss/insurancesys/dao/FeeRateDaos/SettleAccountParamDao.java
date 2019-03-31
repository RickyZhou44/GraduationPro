package whu.iss.insurancesys.dao.FeeRateDaos;

import org.apache.ibatis.annotations.Param;
import whu.iss.insurancesys.entity.FeeRateEntities.SettleAccountParam;

import java.util.Date;
import java.util.List;

public interface SettleAccountParamDao {

    int insert(SettleAccountParam record);

    int insertSelective(SettleAccountParam record);

    List<SettleAccountParam> getByInsurId(@Param("insurId")int insurId);

    int updateDateAndRateById(@Param("insurId")int insurId, @Param("from")Date from,
                               @Param("to")Date to, @Param("rate")double rates, @Param("year")int year);

    int updateDateById(@Param("insurId")int insurId, @Param("from")Date from,
                              @Param("to")Date to);

    int update(SettleAccountParam settleAccountParam);

    int deleteByDateAndId(@Param("insurId")int insurId, @Param("from")Date from, @Param("to")Date to);

}