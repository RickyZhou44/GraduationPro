package whu.iss.insurancesys.dao.HumanResourceParamDaos;

/*
 * @Author SeanShe
 * @Date 3/6/2019 16:14
 * Notes:
 */

import org.apache.ibatis.annotations.Mapper;
import whu.iss.insurancesys.entity.HumanResourceParamEntities.UploadParam;

import java.util.List;

@Mapper
public interface UploadParamDao {

    public void update();

    public List<UploadParam> getAll();

}
