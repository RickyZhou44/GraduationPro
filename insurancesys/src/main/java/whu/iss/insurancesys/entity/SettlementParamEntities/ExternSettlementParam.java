package whu.iss.insurancesys.entity.SettlementParamEntities;

import java.util.Date;
import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/19
 */
public class ExternSettlementParam {
    private Date validateDate;
    private Date paidDate;
    private Date preMonth;//应收月
    private String yearPayTime;//年度交次
    private String insurCom;//保险公司名字
    private String num;//相关单据号码
    private String policy_no;
    private String check;//核佣状态
    private List<InsuranceParam>insuranceParams;//每个保险公司下面的明细

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
}
