package whu.iss.insurancesys.entity.FeeRateEntities;

/*
 * @Author SeanShe
 * @Date 3/16/2019 17:14
 * Notes:
 * */

import java.util.Date;

public class SettleAccountParam {

	private int insurId;

	private int year;

	private double rate;

	private Date payDateStart;

	private Date payDateEnd;

	private Date validateDateStart;

	private Date validateDateEnd;

	private String inOrOut;

	private String feeRateParam;

	public int getInsurId() {
		return insurId;
	}

	public void setInsurId(int insurId) {
		this.insurId = insurId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
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

	public String getInOrOut() {
		return inOrOut;
	}

	public void setInOrOut(String inOrOut) {
		this.inOrOut = inOrOut;
	}

	public String getFeeRateParam() {
		return feeRateParam;
	}

	public void setFeeRateParam(String feeRateParam) {
		this.feeRateParam = feeRateParam;
	}

}
