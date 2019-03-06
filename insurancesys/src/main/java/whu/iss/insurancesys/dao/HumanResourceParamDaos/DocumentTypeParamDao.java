package whu.iss.insurancesys.dao.HumanResourceParamDaos;

/*
 * @Author SeanShe
 * @Date 3/6/2019 16:44
 * Notes:
 */

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DocumentTypeParamDao {

    public void update();

    public List<DocumentTypeParamDao> getAll();

}
