package whu.iss.insurancesys.entity.SettlementParamEntities;

import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/24
 */
//用于从后端传输到前端的客户编辑数据封装
public class ClientEditData {
    //基本信息模块
    private InsuredBasicInfo insuredBasicInfo;
    //单位信息模块
    private UnitInfo unitInfo;
    //关联保单模块
    private List<AssociatePolicy> associatePolicy;
    //亲朋好友模块
    private List<RelationShip>relationShips;
    //附件相关信息
    private List<AttachmentInfo>attachmentInfos;

    public List<AttachmentInfo> getAttachmentInfos() {
        return attachmentInfos;
    }

    public void setAttachmentInfos(List<AttachmentInfo> attachmentInfos) {
        this.attachmentInfos = attachmentInfos;
    }

    public InsuredBasicInfo getInsuredBasicInfo() {
        return insuredBasicInfo;
    }

    public void setInsuredBasicInfo(InsuredBasicInfo insuredBasicInfo) {
        this.insuredBasicInfo = insuredBasicInfo;
    }

    public UnitInfo getUnitInfo() {
        return unitInfo;
    }

    public void setUnitInfo(UnitInfo unitInfo) {
        this.unitInfo = unitInfo;
    }

    public List<AssociatePolicy> getAssociatePolicy() {
        return associatePolicy;
    }

    public void setAssociatePolicy(List<AssociatePolicy> associatePolicy) {
        this.associatePolicy = associatePolicy;
    }

    public List<RelationShip> getRelationShips() {
        return relationShips;
    }

    public void setRelationShips(List<RelationShip> relationShips) {
        this.relationShips = relationShips;
    }
}
