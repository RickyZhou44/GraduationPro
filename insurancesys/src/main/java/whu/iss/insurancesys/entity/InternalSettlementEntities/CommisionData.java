package whu.iss.insurancesys.entity.InternalSettlementEntities;

import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/31
 */
public class CommisionData {
    private List<PolicyDetail>policyDetails;
    private List<SalaryParam>salaryParams;

    public List<PolicyDetail> getPolicyDetails() {
        return policyDetails;
    }

    public void setPolicyDetails(List<PolicyDetail> policyDetails) {
        this.policyDetails = policyDetails;
    }

    public List<SalaryParam> getSalaryParams() {
        return salaryParams;
    }

    public void setSalaryParams(List<SalaryParam> salaryParams) {
        this.salaryParams = salaryParams;
    }
}
