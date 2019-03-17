package whu.iss.insurancesys.dao.ClientParamDaos;

/*
 * @Author SeanShe
 * @Date 3/6/2019 13:46
 * Notes:
 */

import org.apache.ibatis.annotations.Mapper;
import whu.iss.insurancesys.entity.ClientParamEntities.NationType;

import java.util.List;

@Mapper
public interface NationTypeDao {

    public List<NationType> getAll();

}
