package whu.iss.insurancesys.service;

import whu.iss.insurancesys.entity.SettlementParamEntities.*;

import java.util.Date;
import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/22
 */
public interface ExternalSettlementService {
    public ExternalSettleData getExternalSData(Date date,String checkIf);
    public SettlementEditDate getSettlementEditData(ExternSettlementParam externSettlementParam);
    public ClientEditData getClientInfo(String certdId);
    //移除相关relationship
    public boolean  removeRelationById(String aid,String bid);
    public List<ClientByName>getByName(String name);
    public ClientByName getById(String id);
    public void addRelation(String aid,String bid,String relation);
    public void addCertfContent(String content,String type,Date start,Date end,String other,String attachment,String id);
    public List<CarInsuranceParam> getCarInsuranceParam();
    public void updateCheckType(String policyNo);
}
