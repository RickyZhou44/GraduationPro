package whu.iss.insurancesys.service.impl;

import com.sun.istack.internal.Nullable;
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

        int res = customerDao.addCustomer(customer);
        return res == 1;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        int res = customerDao.updateCustomer(customer);
        return res == 1;
    }

    @Override
    public List<Map<String,String>> getCustomerList(String clientName, String idCard, String address, String tel,
                                                    String email, int[] clientType, int[] sex) {
        List<Map<String,String>> mapList = customerDao
                .getCustomerList(clientName,idCard,address,tel,email, clientType, sex);
        return mapList;
    }

    @Override
    public Customer getCustomerById(String certfId) {
        Customer customer = customerDao.getCustomerById(certfId);
        return customer;
    }

    @Override
    public boolean deleteCustomerById(String certfId) {
        int res = customerDao.deleteCustomerById(certfId);
        return res == 1;
    }

    @Override
    public List<String> getRepresentative(String representative) {
        List<String> res = customerDao.getRepresentative(representative);
        return res;
    }
}
