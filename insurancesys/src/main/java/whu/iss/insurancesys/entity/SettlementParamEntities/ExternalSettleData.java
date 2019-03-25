package whu.iss.insurancesys.entity.SettlementParamEntities;

import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/23
 */
//此类用于封装返回外部结算查询数据
public class ExternalSettleData {
    private double totalPremium;
    private List<ExternSettlementParam> externSettlementParams;

    public double getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(double totalPremium) {
        this.totalPremium = totalPremium;
    }

    public List<ExternSettlementParam> getExternSettlementParams() {
        return externSettlementParams;
    }

    public void setExternSettlementParams(List<ExternSettlementParam> externSettlementParams) {
        this.externSettlementParams = externSettlementParams;
    }
}
