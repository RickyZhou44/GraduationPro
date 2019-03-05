package whu.iss.insurancesys.dao.PolicyParamDaos;

/*
 * @Author SeanShe
 * @Date 3/5/2019 11:52
 * Notes:
 */

import org.apache.ibatis.annotations.Mapper;
import whu.iss.insurancesys.entity.PolicyParamEntities.PayWayParam;

import java.util.List;

@Mapper
public interface PayWayParamDao {

    public void insert(PayWayParam payWayParam);

    public void delete(PayWayParam payWayParam);

    public void update(PayWayParam payWayParam);

    public List<PayWayParam> findAll();

}
