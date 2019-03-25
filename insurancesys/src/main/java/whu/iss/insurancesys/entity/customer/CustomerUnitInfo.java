package whu.iss.insurancesys.entity.customer;

import org.hibernate.validator.constraints.Length;

public class CustomerUnitInfo {
    @Length(max = 50)
    private String comName;
    @Length(max = 20)
    private String comPhone;
    @Length(max = 20)
    private String faxNo;
    @Length(max = 20)
    private String representative;
    @Length(max = 50)
    private String taxNo;
    @Length(max = 50)
    private String comAddress;
    @Length(max = 20)
    private String jobName;
    @Length(max = 20)
    private String jobType;
    @Length(max = 50)
    private String jobContent;
    @Length(max = 20)
    private String income;

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComPhone() {
        return comPhone;
    }

    public void setComPhone(String comPhone) {
        this.comPhone = comPhone;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }
}
