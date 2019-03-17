package whu.iss.insurancesys.dao.HumanResourceParamDaos;

/*
 * @Author SeanShe
 * @Date 3/6/2019 16:21
 * Notes:
 */

import org.apache.ibatis.annotations.Mapper;
import whu.iss.insurancesys.entity.HumanResourceParamEntities.OperateParam;

import java.util.List;

@Mapper
public interface OperateParamDao {

    public void update();

    public List<OperateParam> getAll();

}
