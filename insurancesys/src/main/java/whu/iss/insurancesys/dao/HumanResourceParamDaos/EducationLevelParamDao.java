package whu.iss.insurancesys.dao.HumanResourceParamDaos;

/*
 * @Author SeanShe
 * @Date 3/6/2019 16:41
 * Notes:
 */

import org.apache.ibatis.annotations.Mapper;
import whu.iss.insurancesys.entity.HumanResourceParamEntities.EducationLevelParam;

import java.util.List;

@Mapper
public interface EducationLevelParamDao {

    public void update();

    public List<EducationLevelParam> getAll();

}
