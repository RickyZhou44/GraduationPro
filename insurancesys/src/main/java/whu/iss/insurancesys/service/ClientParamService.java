package whu.iss.insurancesys.service;

/*
 * @Author SeanShe
 * @Date 3/6/2019 13:58
 * Notes:
 */

import whu.iss.insurancesys.entity.ClientParamEntities.ClientTypeParam;
import whu.iss.insurancesys.entity.ClientParamEntities.NationType;

import java.util.List;

public interface ClientParamService {

    public List<NationType> getAllNationType();

    public List<ClientTypeParam> getAllClientTypeParam();

}
