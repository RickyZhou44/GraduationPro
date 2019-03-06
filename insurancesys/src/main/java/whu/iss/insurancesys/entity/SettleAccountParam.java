package whu.iss.insurancesys.entity;

import java.util.Date;

public class SettleAccountParam {
    private Integer insurId;

    private Integer year;

    private Double rate;

    private Date payDateStart;

    private Date payDateEnd;

    private Date validateDateStart;

    private Date validateDateEnd;

    public Integer getInsurId() {
        return insurId;
    }

    public void setInsurId(Integer insurId) {
        this.insurId = insurId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Date getPayDateStart() {
        return payDateStart;
    }

    public void setPayDateStart(Date payDateStart) {
        this.payDateStart = payDateStart;
    }

    public Date getPayDateEnd() {
        return payDateEnd;
    }

    public void setPayDateEnd(Date payDateEnd) {
        this.payDateEnd = payDateEnd;
    }

    public Date getValidateDateStart() {
        return validateDateStart;
    }

    public void setValidateDateStart(Date validateDateStart) {
        this.validateDateStart = validateDateStart;
    }

    public Date getValidateDateEnd() {
        return validateDateEnd;
    }

    public void setValidateDateEnd(Date validateDateEnd) {
        this.validateDateEnd = validateDateEnd;
    }
}