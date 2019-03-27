package whu.iss.insurancesys.entity.FeeRateEntities;

/*
 * @Author SeanShe
 * @Date 3/26/2019 16:49
 * Notes:
 * */

public class DeleteInfo {

    private int insurId;

    private String payDateStart;

    private String payDateEnd;

    public int getInsurId() {
        return insurId;
    }

    public void setInsurId(int insurId) {
        this.insurId = insurId;
    }

    public String getPayDateStart() {
        return payDateStart;
    }

    public void setPayDateStart(String payDateStart) {
        this.payDateStart = payDateStart;
    }

    public String getPayDateEnd() {
        return payDateEnd;
    }

    public void setPayDateEnd(String payDateEnd) {
        this.payDateEnd = payDateEnd;
    }
}
