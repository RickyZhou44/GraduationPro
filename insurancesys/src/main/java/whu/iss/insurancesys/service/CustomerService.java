package whu.iss.insurancesys.service;

import whu.iss.insurancesys.entity.customer.Customer;
import whu.iss.insurancesys.entity.customer.CustomerRelationShip;

import java.util.List;
import java.util.Map;

public interface CustomerService {

    public boolean addCustomer(Customer customer);

    public boolean updateCustomer(Customer customer);

    public List<Map<String,String>> getCustomerList(String clientName, String idCard, String address, String tel, String email,
                                                    int[] clientType, int[] sex);

    public Customer getCustomerById(String certfId);

    public boolean deleteCustomerById(String certfId);

    public List<Map<String,String>> getCustomerByName(String name);

    public List<Map<String,String>> getFriendById(String id);

    public List<Map<String,String>> getFriendList(String idCard);

    public boolean addRelationShip(CustomerRelationShip relationShip);

    public List<String> getRepresentative(String representative);

}
