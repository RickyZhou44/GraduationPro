package whu.iss.insurancesys.service;

/*
 * @Author SeanShe
 * @Date 3/18/2019 12:31
 * Notes:
 * */

import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.FeeRateEntities.DeleteInfo;
import whu.iss.insurancesys.entity.FeeRateEntities.InsuranceTypeInfo;
import whu.iss.insurancesys.entity.FeeRateEntities.SettleAccountParam;

import java.util.Date;
import java.util.List;

public interface InsurRateService {

    ResultInfo queryInusrTypeInfoPlus(String company, String insuranceCname, String insuranceSname, String code,
                                      String mainOrVice, String paramType, Date startFrom,
                                      Date startTo, Date endFrom, Date endTo);

    ResultInfo deleteCommonYear(int id, String year);

    ResultInfo modifyCommonYear(int id, String commonYear);

    ResultInfo modifyClick(int[] ids, Date from, Date to, double[] rate);

    ResultInfo deleteClick(List<DeleteInfo> deleteInfos);

    ResultInfo queryInusrTypeInfo(String[] companies, String insuranceCname, String code,
                                String mainOrVice, String paramType, Date startFrom,
                                Date startTo, Date endFrom, Date endTo);

    ResultInfo deleteInsuranceTypeInfo(int id);

    ResultInfo addInsuranceTypeInfo(InsuranceTypeInfo info);

    ResultInfo modifyInsuranceTypeInfo(InsuranceTypeInfo info);

    ResultInfo addFeeRate(SettleAccountParam settleAccountParam, double[] rates);

    ResultInfo modifyFeeRate(SettleAccountParam settleAccountParam, double[] rates);

    ResultInfo queryFeeRates(int id);

    ResultInfo getParamTypeParams();

    ResultInfo getFeeRateParams();

    ResultInfo getCompanyName();

    void exportInsurInfo(String filename, List<InsuranceTypeInfo> infos, String[] request);

}
