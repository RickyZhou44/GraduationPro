package whu.iss.insurancesys.entity.SettlementParamEntities;

import java.util.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/26
 */
//用于存储车险核用相关数据
public class CarInsuranceParam {
    private String companyName;//保险公司名字
    private String policyNo;//保单号码
    private Date billDate;//出单日期
    private Date validDate;//起保日期
    private String contractorName;//承揽人
    private String holderName;//投保人
    private String beholderName;//被保人
    private String branch;//分支机构
    private String check;//核佣
    private String jiyong;//计佣
    private double expenditureBusinessRate;//商业支项率
    private double reciveBusinessRate;//商业收项率
    private double expenditureJiaoqiangRate;//交强支项率
    private double reciveJiaoQiangsRate;//商业收项率
    private double jiaoqiangPremium=0;//交强保费
    private double businessPremium=0;//商业保费
    private double totalPremium=0;//总保费



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

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getBeholderName() {
        return beholderName;
    }

    public void setBeholderName(String beholderName) {
        this.beholderName = beholderName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getJiyong() {
        return jiyong;
    }

    public void setJiyong(String jiyong) {
        this.jiyong = jiyong;
    }

    public double getExpenditureBusinessRate() {
        return expenditureBusinessRate;
    }

    public void setExpenditureBusinessRate(double expenditureBusinessRate) {
        this.expenditureBusinessRate = expenditureBusinessRate;
    }

    public double getReciveBusinessRate() {
        return reciveBusinessRate;
    }

    public void setReciveBusinessRate(double reciveBusinessRate) {
        this.reciveBusinessRate = reciveBusinessRate;
    }

    public double getExpenditureJiaoqiangRate() {
        return expenditureJiaoqiangRate;
    }

    public void setExpenditureJiaoqiangRate(double expenditureJiaoqiangRate) {
        this.expenditureJiaoqiangRate = expenditureJiaoqiangRate;
    }

    public double getReciveJiaoQiangsRate() {
        return reciveJiaoQiangsRate;
    }

    public void setReciveJiaoQiangsRate(double reciveJiaoQiangsRate) {
        this.reciveJiaoQiangsRate = reciveJiaoQiangsRate;
    }

    public double getJiaoqiangPremium() {
        return jiaoqiangPremium;
    }

    public void setJiaoqiangPremium(double jiaoqiangPremium) {
        this.jiaoqiangPremium = jiaoqiangPremium;
    }

    public double getBusinessPremium() {
        return businessPremium;
    }

    public void setBusinessPremium(double businessPremium) {
        this.businessPremium = businessPremium;
    }

    public double getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(double totalPremium) {
        this.totalPremium = totalPremium;
    }
}
