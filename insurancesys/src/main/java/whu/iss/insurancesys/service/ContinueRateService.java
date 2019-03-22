package whu.iss.insurancesys.service;

import java.util.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/17
 */
public interface ContinueRateService {
    public Object getResult(Date current,int param,int type);
}
