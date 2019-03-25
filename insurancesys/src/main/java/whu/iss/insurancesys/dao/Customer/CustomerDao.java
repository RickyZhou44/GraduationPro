package whu.iss.insurancesys.dao.Customer;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import whu.iss.insurancesys.entity.customer.Customer;

import java.util.List;
import java.util.Map;

@Repository
public interface CustomerDao {
    public int addCustomer(Customer customer);

    public List<Map<String,String>> getCustomerList(@Param("name") String clientName, @Param("certf_id") String idCard,
                                                    @Param("home_address") String address, @Param("telephone") String tel,
                                                    @Param("email") String email);

    public Customer getCustomerById(@Param("certf_id") String certfId);
}
