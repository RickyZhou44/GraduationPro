package whu.iss.insurancesys.service;

import whu.iss.insurancesys.dto.ResultInfo;

import java.util.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/17
 */
public interface ContinueRateService {
    public ResultInfo getResult(Date current, int param, int type);
}
