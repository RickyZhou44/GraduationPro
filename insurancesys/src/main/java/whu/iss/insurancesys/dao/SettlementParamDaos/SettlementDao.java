package whu.iss.insurancesys.dao.SettlementParamDaos;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import whu.iss.insurancesys.entity.SettlementParamEntities.*;

import java.util.Date;
import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/23
 */
@Repository
public interface SettlementDao {
    public List<ExternalSettleEntity>getExternalData();
    public List<InsuranceTypeEntity>getInsuranceData();
    public Insured getInsured(String policy);
    public ClientInfo getClient(String certfId);
    public List<AssociatePolicy>getAssoPolicy(String certfId);
    public List<RelationShip>getRelationShip(String certfId);
    public void removeRlation(@Param("aid") String aid,@Param("bid") String bid);
    public List<ClientByName>getClientsByName(@Param("name")String name);
    public ClientByName getClientsById(@Param("id")String id);
    public void insertRelation(@Param("aid")String aid,@Param("bid")String bid,@Param("relation")String relation);
    public void insertCertfRe(@Param("content")String content, @Param("recordType")String type, @Param("startDate")Date start,@Param("endDate")Date end,@Param("other")String other,@Param("attachment")String attachment,@Param("id")String id);
}
