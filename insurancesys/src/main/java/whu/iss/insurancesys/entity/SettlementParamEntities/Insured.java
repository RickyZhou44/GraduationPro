package whu.iss.insurancesys.entity.SettlementParamEntities;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/24
 */
//此类用于从dao层获得投保人信息
public class Insured {
    private String policy_holder_id;
    private String name;
    private String period;
    private String pay_mode;
    private String pay_way;
    private String policy_type;
    private String agent_type;

    public String getPay_mode() {
        return pay_mode;
    }

    public void setPay_mode(String pay_mode) {
        this.pay_mode = pay_mode;
    }

    public String getPay_way() {
        return pay_way;
    }

    public void setPay_way(String pay_way) {
        this.pay_way = pay_way;
    }

    public String getPolicy_type() {
        return policy_type;
    }

    public void setPolicy_type(String policy_type) {
        this.policy_type = policy_type;
    }

    public String getAgent_type() {
        return agent_type;
    }

    public void setAgent_type(String agent_type) {
        this.agent_type = agent_type;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPolicy_holder_id() {
        return policy_holder_id;
    }

    public void setPolicy_holder_id(String policy_holder_id) {
        this.policy_holder_id = policy_holder_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
