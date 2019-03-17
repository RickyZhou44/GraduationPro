package whu.iss.insurancesys.dao.HumanResourceParamDaos;

/*
 * @Author SeanShe
 * @Date 3/6/2019 16:28
 * Notes:
 */

import org.apache.ibatis.annotations.Mapper;
import whu.iss.insurancesys.entity.HumanResourceParamEntities.RankChangeParam;

import java.util.List;

@Mapper
public interface RankChangeParamDao {

    public void update();

    public List<RankChangeParam> getAll();

}
