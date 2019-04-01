package whu.iss.insurancesys.dao.SettlementParamDaos;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import whu.iss.insurancesys.entity.InternalSettlementEntities.CommissionParam;
import whu.iss.insurancesys.entity.LoginRegisterEntities.VerifiCode;
import whu.iss.insurancesys.entity.SettlementParamEntities.*;

import java.util.Date;
import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/23
 */
//修改了一下名字
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
    public List<AttachmentInfo>attachInfo(@Param("id")String id);
    public List<CarInsurancePolicyParam>getCarinsurancepolicys();
    public List<CarContactParam>carContactParam();
    public List<CarContactorInfo>contactorInfo();
    public List<CarInsuranceTypeParam>carInsuranceTypes();
    public List<ClientParam>clients();
    public void insertVertification(@Param("email")String email,@Param("date")Date date,@Param("code")String code);
    public List<VerifiCode> getverifi(@Param("email")String email);
    public void insertCommissionRecord(@Param("branch")String branch,@Param("dateStart")Date dateStart,@Param("dateEnd")Date dateEnd);
    public List<CommissionParam>getCommissionRecords();
}
