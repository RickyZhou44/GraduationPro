package whu.iss.insurancesys.entity.customer;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Customer {

    @Valid
    @NotNull
    private CustomerBaseInfo baseInfo;

    @Valid
    @NotNull
    private CustomerUnitInfo unitInfo;

    public CustomerBaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(CustomerBaseInfo customerBaseInfo) {
        this.baseInfo = customerBaseInfo;
    }

    public CustomerUnitInfo getUnitInfo() {
        return unitInfo;
    }

    public void setUnitInfo(CustomerUnitInfo customerUnitInfo) {
        this.unitInfo = customerUnitInfo;
    }
}
