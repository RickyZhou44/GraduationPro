package whu.iss.insurancesys.entity;

public class CarInsurPolicyMid {
    private Integer carInsurPolicyId;

    private String policyNo;

    private Integer carInsurId;

    public Integer getCarInsurPolicyId() {
        return carInsurPolicyId;
    }

    public void setCarInsurPolicyId(Integer carInsurPolicyId) {
        this.carInsurPolicyId = carInsurPolicyId;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo == null ? null : policyNo.trim();
    }

    public Integer getCarInsurId() {
        return carInsurId;
    }

    public void setCarInsurId(Integer carInsurId) {
        this.carInsurId = carInsurId;
    }
}