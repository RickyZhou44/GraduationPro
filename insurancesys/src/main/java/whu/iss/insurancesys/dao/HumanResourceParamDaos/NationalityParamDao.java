package whu.iss.insurancesys.dao.HumanResourceParamDaos;

/*
 * @Author SeanShe
 * @Date 3/6/2019 16:03
 * Notes:
 */

import org.apache.ibatis.annotations.Mapper;
import whu.iss.insurancesys.entity.HumanResourceParamEntities.NationalityParam;

import java.util.List;

@Mapper
public interface NationalityParamDao {

    public void update();

    public List<NationalityParam> getAll();

}
