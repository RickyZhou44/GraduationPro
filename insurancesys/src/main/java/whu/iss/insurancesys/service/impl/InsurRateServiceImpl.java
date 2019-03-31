package whu.iss.insurancesys.service.impl;

/*
 * @Author SeanShe
 * @Date 3/18/2019 12:31
 * Notes:
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.FeeRateDaos.*;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.ExcelData;
import whu.iss.insurancesys.entity.FeeRateEntities.DeleteInfo;
import whu.iss.insurancesys.entity.FeeRateEntities.InsurTypeInfoPlus;
import whu.iss.insurancesys.entity.FeeRateEntities.InsuranceTypeInfo;
import whu.iss.insurancesys.entity.FeeRateEntities.SettleAccountParam;
import whu.iss.insurancesys.service.InsurRateService;
import whu.iss.insurancesys.util.ExcelUtil;

import java.lang.reflect.Field;
import java.util.*;

@Service
public class InsurRateServiceImpl implements InsurRateService {

    @Autowired
    InsuranceTypeInfoDao insuranceTypeInfoDao;

    @Autowired
    SettleAccountParamDao settleAccountParamDao;

    @Autowired
    ParamDao paramDao;

    //费率模块 5
    public ResultInfo queryInusrTypeInfoPlus(String company, String insuranceCname, String insuranceSname, String code,
                                         String mainOrVice, String paramType, Date startFrom,
                                         Date startTo, Date endFrom, Date endTo){

        List<InsuranceTypeInfo> infoResult = new ArrayList<>(insuranceTypeInfoDao.getByParam(company, insuranceCname,
                insuranceSname, code, mainOrVice, paramType, startFrom, startTo, endFrom, endTo));
        List<InsurTypeInfoPlus> result = new ArrayList<>();
        infoResult.forEach(item -> {
            if(item.getCommonYear().length() != 0) {
                ArrayList<SettleAccountParam> s =
                        (ArrayList<SettleAccountParam>) settleAccountParamDao.getByInsurId(item.getInsurId());
                Map<String, InsurTypeInfoPlus> map = new HashMap<>();
                s.forEach(i -> {
                    InsurTypeInfoPlus infoPlus = map.get(i.getFeeRateParam());
                    if (infoPlus == null) {
                        infoPlus = new InsurTypeInfoPlus(item, i.getFeeRateParam());
                        map.put(i.getFeeRateParam(), infoPlus);
                    }
                    infoPlus.addRate(i.getRate());
                });
                result.addAll(map.values());
            }
        });
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(true);
        resultInfo.setData(result);
        return resultInfo;

    }

    public ResultInfo modifyClick(int[] ids, Date from, Date to, double[] rates){

        ResultInfo resultInfo = new ResultInfo();
        int res = 0;
        int i = 0;
        for (; i< ids.length; i++){

            if(modifyClick(ids[i], from, to, rates)){

                res++;

            }

        }
        if(res > i){

            resultInfo.setResult(true);

        }else {

            resultInfo.setResult(false);

        }
        return resultInfo;

    }

    private Boolean modifyClick(int id, Date from, Date to, double[] rates){

        int res = 0;
        int i = 0;
        if(rates.length == 0){

            res += settleAccountParamDao.updateDateById(id, from, to);

        }else {

            for (; i < rates.length; i++) {

                res += settleAccountParamDao.updateDateAndRateById(id, from, to, rates[i], i+1);

            }

        }
        return res > i;

    }

    public ResultInfo deleteClick(List<DeleteInfo> deleteInfos){

        ResultInfo resultInfo = new ResultInfo();
        int res = 0;
        int i = 0;
        DeleteInfo d;
        for (; i< deleteInfos.size(); i++){

            d = deleteInfos.get(i);
            if(deleteClick(d.getInsurId(), new Date(d.getPayDateStart()), new Date(d.getPayDateEnd()))){

                res++;

            }

        }
        if(res > i){

            resultInfo.setResult(true);

        }else {

            resultInfo.setResult(false);

        }
        return resultInfo;

    }

    private Boolean deleteClick(int id, Date from, Date to){

        int res = 0;
        res += settleAccountParamDao.deleteByDateAndId(id, from, to);
        return res > 0;

    }

    //费率模块 1
    public ResultInfo queryInusrTypeInfo(String[] companies, String insuranceCname, String code,
                                         String mainOrVice, String paramType, Date startFrom,
                                         Date startTo, Date endFrom, Date endTo){

        ResultInfo resultInfo = new ResultInfo();
        List<InsuranceTypeInfo> result = new ArrayList<>();
        if(companies == null){

            result.addAll(insuranceTypeInfoDao.getByParam(null, insuranceCname, null,
                    code, mainOrVice, paramType,
                    startFrom, startTo, endFrom, endTo));

        }else {

            for(String company : companies){

                result.addAll(queryInusrTypeInfo(company, insuranceCname,
                        code, mainOrVice, paramType,
                        startFrom, startTo, endFrom, endTo));

            }

        }
        resultInfo.setResult(true);
        resultInfo.setData(result);
        return resultInfo;

    }

    private List<InsuranceTypeInfo> queryInusrTypeInfo(String company, String insuranceCname, String code,
                                       String mainOrVice, String paramType, Date startFrom,
                                       Date startTo, Date endFrom, Date endTo){

        return insuranceTypeInfoDao.getByParam(company, insuranceCname, null, code, mainOrVice, paramType,
                startFrom, startTo, endFrom, endTo);

    }

    public ResultInfo deleteInsuranceTypeInfo(int id){

        int res = insuranceTypeInfoDao.deleteByinsurId(id);
        ResultInfo resultInfo = new ResultInfo();
        if(res > 0){

            resultInfo.setResult(true);

        }else {

            resultInfo.setResult(false);

        }
        return resultInfo;


    }

    public ResultInfo addInsuranceTypeInfo(InsuranceTypeInfo info){

        int res = insuranceTypeInfoDao.insertSelective(info);
        ResultInfo resultInfo = new ResultInfo();
        if(res > 0){

            resultInfo.setResult(true);

        }else {

            resultInfo.setResult(false);

        }
        return resultInfo;


    }

    public ResultInfo modifyInsuranceTypeInfo(InsuranceTypeInfo info){

        int res = insuranceTypeInfoDao.update(info.getInsurId(), info.getMainOrVice(), info.getInsuranceType(),
                info.getInsuranceCname(), info.getInsuranceSname(), info.getParamType(), info.getCommonYear(),
                info.getStartSaleTime(), info.getStopSaleTime(), info.getRemark());
        ResultInfo resultInfo = new ResultInfo();
        if(res > 0){

            resultInfo.setResult(true);

        }else {

            resultInfo.setResult(false);

        }
        return resultInfo;


    }

    public ResultInfo deleteCommonYear(int id, String year){

        InsuranceTypeInfo info = insuranceTypeInfoDao.getById(id);
        String[] years = info.getCommonYear().split(" ");
        ArrayList<String> deleteYears = new ArrayList<>(Arrays.asList(year.split(" ")));
        int i = 0;
        StringBuilder s = new StringBuilder();
        for(; i < years.length; i++){
            if(deleteYears.contains(years[i])){
                continue;
            }
            if(i == years.length - 1){
                s.append(years[i]);
            }else {
                s.append(years[i]).append(" ");
            }
        }
        return modifyCommonYear(id, s.toString().trim());
        //此处只删除了commonyear

    }

    public ResultInfo modifyCommonYear(int id, String commonYear){

        int res = insuranceTypeInfoDao.update(id, null, null,
                null, null, null, commonYear,
                null, null, null);
        ResultInfo resultInfo = new ResultInfo();
        if(res > 0){

            resultInfo.setResult(true);

        }else {

            resultInfo.setResult(false);

        }
        return resultInfo;


    }

    public ResultInfo addFeeRate(SettleAccountParam settleAccountParam, double[] rates){

        int res = 0;
        int i = 0;
        for (; i < rates.length; i++) {

            settleAccountParam.setYear(i+1);
            settleAccountParam.setRate(rates[i]);
            res += settleAccountParamDao.insertSelective(settleAccountParam);

        }
        ResultInfo resultInfo = new ResultInfo();
        if(res > i){

            resultInfo.setResult(true);

        }else {

            resultInfo.setResult(false);

        }
        return resultInfo;

    }

    public ResultInfo modifyFeeRate(SettleAccountParam settleAccountParam, double[] rates){

        int res = 0;
        int i = 0;
        for (; i < rates.length; i++) {

            settleAccountParam.setYear(i+1);
            settleAccountParam.setRate(rates[i]);
            res += settleAccountParamDao.update(settleAccountParam);

        }
        ResultInfo resultInfo = new ResultInfo();
        if(res > i){

            resultInfo.setResult(true);

        }else {

            resultInfo.setResult(false);

        }
        return resultInfo;

    }

    public ResultInfo queryFeeRates(int id){

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(true);
        resultInfo.setData(settleAccountParamDao.getByInsurId(id));
        return resultInfo;

    }

    public ResultInfo getParamTypeParams(){

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(true);
        resultInfo.setData(paramDao.getAllParamTypeParam());
        return resultInfo;

    }

    public ResultInfo getFeeRateParams(){

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(true);
        resultInfo.setData(paramDao.getAllFeeRateParam());
        return resultInfo;

    }

    public ResultInfo getCompanyName(){

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(true);
        resultInfo.setData(paramDao.getAllCompanyName());
        return resultInfo;

    }

    public void exportInsurInfo(String filename, List<InsuranceTypeInfo> infos, String[] request){

        ExcelData data = new ExcelData();
        data.setFilename(filename);
        List<String> head = new ArrayList<>();
        List<String[]> details = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        for(String s: request){

            head.add(INSURINFOHEAD.get(s));

        }
        infos.forEach(item -> {

            for(String s: request){

                temp.add(getFieldValueByFieldName(s, item));

            }
            details.add((String[]) temp.toArray());
            temp.clear();

        });

        data.setHead((String[]) head.toArray());
        data.setData(details);
        ExcelUtil.exportExcel(data);

    }

    private String getFieldValueByFieldName(String fieldName, Object object) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return  (String)field.get(object);
        } catch (Exception e) {

            return null;
        }
    }

    private static final Map<String, String> INSURINFOHEAD = new HashMap<String, String>(){{
        put("insurId", "序号");
        put("company", "保险公司");
        put("insuranceCname", "险种名称");
        put("insuranceSname", "险种简称");
        put("code", "险种代码");
        put("mainOrVice", "主副约");
        put("paramType", "参数区别");
        put("insuranceType", "险种类别");
        put("startSaleTime", "启售日");
        put("stopSaleTime", "停售日");
        put("remark", "备注");
        put("commonYear", "常用年期");
    }};


}
