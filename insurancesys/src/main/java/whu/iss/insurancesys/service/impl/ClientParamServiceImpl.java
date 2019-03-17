package whu.iss.insurancesys.service.impl;

/*
 * @Author SeanShe
 * @Date 3/6/2019 13:59
 * Notes:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.ClientParamDaos.ClientTypeParamDao;
import whu.iss.insurancesys.dao.ClientParamDaos.NationTypeDao;
import whu.iss.insurancesys.entity.ClientParamEntities.ClientTypeParam;
import whu.iss.insurancesys.entity.ClientParamEntities.NationType;
import whu.iss.insurancesys.service.ClientParamService;

import java.util.List;

@Service
public class ClientParamServiceImpl implements ClientParamService {

    @Autowired
    ClientTypeParamDao clientTypeParamDao;
    @Autowired
    NationTypeDao nationTypeDao;

    @Override
    public List<NationType> getAllNationType() {

        return nationTypeDao.getAll();

    }

    @Override
    public List<ClientTypeParam> getAllClientTypeParam() {

        return clientTypeParamDao.getAll();

    }

}
