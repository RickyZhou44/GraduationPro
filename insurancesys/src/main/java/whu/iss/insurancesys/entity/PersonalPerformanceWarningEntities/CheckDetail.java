package whu.iss.insurancesys.entity.PersonalPerformanceWarningEntities;

/**
 * 查核详细
 */
public class CheckDetail {
    private String project;
    private String category;
    private String policyNo;
    private double value;

    public CheckDetail() {

    }

    public CheckDetail(String policyNo, String project, String category, double value) {
        this.policyNo = policyNo;
        this.project = project;
        this.category = category;
        this.value = value;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }
}
