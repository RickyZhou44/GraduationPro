package whu.iss.insurancesys.entity.InternalSettlementEntities;

import java.util.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/31
 */
public class PolicyDetail {
    private String companyName;
    private String policyNo;
    private Date validDate;//受理日期
    private double jiaoqiangPremium;//交强保费
    private double extendJiaoqiang;//支项交强
    private double businessPremium;//商业保费
    private double extendBusiness;//支项商业

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public double getJiaoqiangPremium() {
        return jiaoqiangPremium;
    }

    public void setJiaoqiangPremium(double jiaoqiangPremium) {
        this.jiaoqiangPremium = jiaoqiangPremium;
    }

    public double getExtendJiaoqiang() {
        return extendJiaoqiang;
    }

    public void setExtendJiaoqiang(double extendJiaoqiang) {
        this.extendJiaoqiang = extendJiaoqiang;
    }

    public double getBusinessPremium() {
        return businessPremium;
    }

    public void setBusinessPremium(double businessPremium) {
        this.businessPremium = businessPremium;
    }

    public double getExtendBusiness() {
        return extendBusiness;
    }

    public void setExtendBusiness(double extendBusiness) {
        this.extendBusiness = extendBusiness;
    }
}
