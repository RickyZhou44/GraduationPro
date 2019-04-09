package whu.iss.insurancesys.service.impl;

//import com.sun.istack.internal.Nullable;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.Customer.CustomerDao;
import whu.iss.insurancesys.entity.customer.Customer;
import whu.iss.insurancesys.service.CustomerService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDao customerDao;

    @Override
    public boolean addCustomer(Customer customer) {
        return customerDao.addCustomer(customer) == 1;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer) == 1;
    }

    @Override
    public List<Map<String,String>> getCustomerList(String clientName, String idCard, String address, String tel,
                                                    String email, int[] clientType, int[] sex) {
        return customerDao.getCustomerList(clientName,idCard,address,tel,email, clientType, sex);
    }

    @Override
    public Customer getCustomerById(String certfId) {
        return customerDao.getCustomerById(certfId);
    }

    @Override
    public boolean deleteCustomerById(String certfId) {
        return customerDao.deleteCustomerById(certfId) == 1;
    }

    @Override
    public List<String> getRepresentative(String representative) {
        return customerDao.getRepresentative(representative);
    }
}
