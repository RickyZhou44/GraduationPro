package whu.iss.insurancesys.dao.FeeRateDaos;

/*
 * @Author SeanShe
 * @Date 3/25/2019 18:09
 * Notes:
 * */

import org.apache.ibatis.annotations.Param;
import whu.iss.insurancesys.entity.FeeRateEntities.FeeRateParam;
import whu.iss.insurancesys.entity.FeeRateEntities.ParamTypeParam;

import java.util.List;

public interface ParamDao {

    List<String> getAllBranchName();

    List<String> getBranchName(@Param("companyName")String companyName);

    int insertFeeRateParamSelective(FeeRateParam record);

    List<FeeRateParam> getAllFeeRateParam();

    List<String> getAllCompanyName();

    int insertParamTypeParamSelective(ParamTypeParam record);

    List<ParamTypeParam> getAllParamTypeParam();

}
