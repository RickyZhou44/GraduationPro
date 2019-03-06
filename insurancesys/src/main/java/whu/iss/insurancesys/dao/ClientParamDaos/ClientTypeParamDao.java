package whu.iss.insurancesys.dao.ClientParamDaos;

/*
 * @Author SeanShe
 * @Date 3/6/2019 13:45
 * Notes:
 */

import org.apache.ibatis.annotations.Mapper;
import whu.iss.insurancesys.entity.ClientParamEntities.ClientTypeParam;

import java.util.List;

@Mapper
public interface ClientTypeParamDao {

    public List<ClientTypeParam> getAll();

}
