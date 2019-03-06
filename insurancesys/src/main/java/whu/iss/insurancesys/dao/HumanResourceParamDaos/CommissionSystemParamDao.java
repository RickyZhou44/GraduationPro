package whu.iss.insurancesys.dao.HumanResourceParamDaos;

/*
 * @Author SeanShe
 * @Date 3/6/2019 16:35
 * Notes:
 */

import org.apache.ibatis.annotations.Mapper;
import whu.iss.insurancesys.entity.HumanResourceParamEntities.CommissionSystemParam;

import java.util.List;

@Mapper
public interface CommissionSystemParamDao {

    public void update();

    public List<CommissionSystemParam> getAll();

}
