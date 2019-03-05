package whu.iss.insurancesys.dao.PolicyParamDaos;

/*
 * @Author SeanShe
 * @Date 3/5/2019 11:52
 * Notes:
 */

import org.apache.ibatis.annotations.Mapper;
import whu.iss.insurancesys.entity.PolicyParamEntities.PayTypeParam;

import java.util.List;

@Mapper
public interface PayTypeParamDao {

    public void insert(PayTypeParam payTypeParam);

    public void delete(PayTypeParam payTypeParam);

    public void update(PayTypeParam payTypeParam);

    public List<PayTypeParam> findAll();

}
