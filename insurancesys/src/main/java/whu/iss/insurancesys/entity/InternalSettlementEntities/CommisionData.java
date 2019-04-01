package whu.iss.insurancesys.entity.InternalSettlementEntities;

import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/31
 */
//修改了一下名字
public class CommisionData {
    private List<PolicyDetailInfo>policyDetails;
    private List<SalaryParam>salaryParams;

    public List<PolicyDetailInfo> getPolicyDetails() {
        return policyDetails;
    }

    public void setPolicyDetails(List<PolicyDetailInfo> policyDetails) {
        this.policyDetails = policyDetails;
    }

    public List<SalaryParam> getSalaryParams() {
        return salaryParams;
    }

    public void setSalaryParams(List<SalaryParam> salaryParams) {
        this.salaryParams = salaryParams;
    }
}
