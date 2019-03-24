package whu.iss.insurancesys.entity.SettlementParamEntities;

import java.util.Date;
import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/23
 */
//用于对外部结算数据详细传输的封装
public class SettlementEditDate {
    private String clientId;//客户id
    private String clientName;//客户名字
    private Date jijiDate;//计基年月
    private String checkStatus;//核发状态
    private Date validateDate;//发生月
    private String checkCommission;//核佣
    private String accountStates;//账目状态
    private Date balanceDate;//平衡月
    private String insuranceName;//保险公司名字
    private String policyNo;//保单号码
    private String attachNo;//相关单据
    private String payType;//交费型别
    private Date checkDate;//受理日期
    //年度缴次
    private int year;
    private int times;
    private String payf;//交费方式
    private Date payDate;//交费日期
    private Date huizhiDate;//回执日期
    private double totalPremium;//总保费
    private double firstyearP;//首年
    private double sale;//销售
    private double ffyc;//首佣fyc
    private double intStdPremium;//内部标准保费
    private double stdPremium;//标准保费
    private double secondYear;//续年
    private double sevice;//服务
    private double secondFyc;//续佣fyc
    private double cfyc;//财佣fyc
    private String agentType;//承揽型别
    private String contractorName;//承揽人
    private String contractorNum;//承揽人编号
    private List<InsuranceParam> insuranceParams;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getJijiDate() {
        return jijiDate;
    }

    public void setJijiDate(Date jijiDate) {
        this.jijiDate = jijiDate;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Date getValidateDate() {
        return validateDate;
    }

    public void setValidateDate(Date validateDate) {
        this.validateDate = validateDate;
    }

    public String getCheckCommission() {
        return checkCommission;
    }

    public void setCheckCommission(String checkCommission) {
        this.checkCommission = checkCommission;
    }

    public String getAccountStates() {
        return accountStates;
    }

    public void setAccountStates(String accountStates) {
        this.accountStates = accountStates;
    }

    public Date getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getAttachNo() {
        return attachNo;
    }

    public void setAttachNo(String attachNo) {
        this.attachNo = attachNo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getPayf() {
        return payf;
    }

    public void setPayf(String payf) {
        this.payf = payf;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getHuizhiDate() {
        return huizhiDate;
    }

    public void setHuizhiDate(Date huizhiDate) {
        this.huizhiDate = huizhiDate;
    }

    public double getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(double totalPremium) {
        this.totalPremium = totalPremium;
    }

    public double getFirstyearP() {
        return firstyearP;
    }

    public void setFirstyearP(double firstyearP) {
        this.firstyearP = firstyearP;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public double getFfyc() {
        return ffyc;
    }

    public void setFfyc(double ffyc) {
        this.ffyc = ffyc;
    }

    public double getIntStdPremium() {
        return intStdPremium;
    }

    public void setIntStdPremium(double intStdPremium) {
        this.intStdPremium = intStdPremium;
    }

    public double getStdPremium() {
        return stdPremium;
    }

    public void setStdPremium(double stdPremium) {
        this.stdPremium = stdPremium;
    }

    public double getSecondYear() {
        return secondYear;
    }

    public void setSecondYear(double secondYear) {
        this.secondYear = secondYear;
    }

    public double getSevice() {
        return sevice;
    }

    public void setSevice(double sevice) {
        this.sevice = sevice;
    }

    public double getSecondFyc() {
        return secondFyc;
    }

    public void setSecondFyc(double secondFyc) {
        this.secondFyc = secondFyc;
    }

    public double getCfyc() {
        return cfyc;
    }

    public void setCfyc(double cfyc) {
        this.cfyc = cfyc;
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public String getContractorNum() {
        return contractorNum;
    }

    public void setContractorNum(String contractorNum) {
        this.contractorNum = contractorNum;
    }

    public List<InsuranceParam> getInsuranceParams() {
        return insuranceParams;
    }

    public void setInsuranceParams(List<InsuranceParam> insuranceParams) {
        this.insuranceParams = insuranceParams;
    }
}
