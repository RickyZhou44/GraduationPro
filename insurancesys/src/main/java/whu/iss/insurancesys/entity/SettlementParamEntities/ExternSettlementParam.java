package whu.iss.insurancesys.entity.SettlementParamEntities;

import java.util.Date;
import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/19
 */
public class ExternSettlementParam {
    private Date validateDate;//生效日期
    private Date paidDate;//支付日期
    private Date preMonth;//应收月
    private String yearPayTime;//年度交次
    private String insurCom;//保险公司名字
    private String num;//相关单据号码
    private String policy_no;
    private String check;//核佣状态
    //用于保存每个订单下的主约和附约的详细情况
    private List<InsuranceParam>insuranceParams;//每个保险公司下面的主约和附约明细
    private String policyState;//保单状态
    private String constractState;//承揽状态
    private String contractor;//承揽人
    private String idNum;//承揽人编号
    private String totalPremium;//总保费
    private String stdPremium;//标保
    private double fPre;//首年
    private double secondYear;//续年
    private double sale;//销售
    private double service;//服务
    private double sfyc;//首佣fyc
    private double xfyc;//续佣fyc
    private double interStdPre;//内部标保
    private double caiYCFY;//财佣CFY
    private double mainPremium;//主约保费
    private double attachPremium;//附约保费
    private Date occurMonth;//发生月
    private String accountState;//账目状态
    private Date balanceMonth;//平衡月

    public Date getValidateDate() {
        return validateDate;
    }

    public void setValidateDate(Date validateDate) {
        this.validateDate = validateDate;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public Date getPreMonth() {
        return preMonth;
    }

    public void setPreMonth(Date preMonth) {
        this.preMonth = preMonth;
    }

    public String getYearPayTime() {
        return yearPayTime;
    }

    public void setYearPayTime(String yearPayTime) {
        this.yearPayTime = yearPayTime;
    }

    public String getInsurCom() {
        return insurCom;
    }

    public void setInsurCom(String insurCom) {
        this.insurCom = insurCom;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPolicy_no() {
        return policy_no;
    }

    public void setPolicy_no(String policy_no) {
        this.policy_no = policy_no;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public List<InsuranceParam> getInsuranceParams() {
        return insuranceParams;
    }

    public void setInsuranceParams(List<InsuranceParam> insuranceParams) {
        this.insuranceParams = insuranceParams;
    }

    public String getPolicyState() {
        return policyState;
    }

    public void setPolicyState(String policyState) {
        this.policyState = policyState;
    }

    public String getConstractState() {
        return constractState;
    }

    public void setConstractState(String constractState) {
        this.constractState = constractState;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(String totalPremium) {
        this.totalPremium = totalPremium;
    }

    public String getStdPremium() {
        return stdPremium;
    }

    public void setStdPremium(String stdPremium) {
        this.stdPremium = stdPremium;
    }

    public double getfPre() {
        return fPre;
    }

    public void setfPre(double fPre) {
        this.fPre = fPre;
    }

    public double getSecondYear() {
        return secondYear;
    }

    public void setSecondYear(double secondYear) {
        this.secondYear = secondYear;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public double getService() {
        return service;
    }

    public void setService(double service) {
        this.service = service;
    }

    public double getSfyc() {
        return sfyc;
    }

    public void setSfyc(double sfyc) {
        this.sfyc = sfyc;
    }

    public double getXfyc() {
        return xfyc;
    }

    public void setXfyc(double xfyc) {
        this.xfyc = xfyc;
    }

    public double getInterStdPre() {
        return interStdPre;
    }

    public void setInterStdPre(double interStdPre) {
        this.interStdPre = interStdPre;
    }

    public double getCaiYCFY() {
        return caiYCFY;
    }

    public void setCaiYCFY(double caiYCFY) {
        this.caiYCFY = caiYCFY;
    }

    public double getMainPremium() {
        return mainPremium;
    }

    public void setMainPremium(double mainPremium) {
        this.mainPremium = mainPremium;
    }

    public double getAttachPremium() {
        return attachPremium;
    }

    public void setAttachPremium(double attachPremium) {
        this.attachPremium = attachPremium;
    }

    public Date getOccurMonth() {
        return occurMonth;
    }

    public void setOccurMonth(Date occurMonth) {
        this.occurMonth = occurMonth;
    }

    public String getAccountState() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState;
    }

    public Date getBalanceMonth() {
        return balanceMonth;
    }

    public void setBalanceMonth(Date balanceMonth) {
        this.balanceMonth = balanceMonth;
    }
}
