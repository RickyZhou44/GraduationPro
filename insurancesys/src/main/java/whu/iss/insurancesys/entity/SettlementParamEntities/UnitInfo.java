package whu.iss.insurancesys.entity.SettlementParamEntities;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/24
 */
//此类用于存储单位信息
public class UnitInfo {
    private String companyName;//单位名字
    private String phoneNum;//联系电话
    private String faxNo;//传真号码
    private String legalRepresentative;//法定代表
    private String taxNum;//税号
    private String comAddress;//单位地址
    private String rankName;//职级名称
    private String phone;//联系电话
    private String rankContent;//职级内容
    private String jobType;//职业类型
    private String income;//收入

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getTaxNum() {
        return taxNum;
    }

    public void setTaxNum(String taxNum) {
        this.taxNum = taxNum;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRankContent() {
        return rankContent;
    }

    public void setRankContent(String rankContent) {
        this.rankContent = rankContent;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }
}
