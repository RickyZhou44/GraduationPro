package whu.iss.insurancesys.entity.PersonalPerformanceWarningEntities;

/**
 * 查核详细
 */
public class CheckDetail {
    private String project;
    private String category;
    private String period;
    private double value;

    public CheckDetail() {

    }

    public CheckDetail(String project, String category, String period, double value) {
        this.period = period;
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

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
