package whu.iss.insurancesys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.customer.Customer;
import whu.iss.insurancesys.entity.customer.CustomerBaseInfo;
import whu.iss.insurancesys.entity.customer.CustomerRelationShip;
import whu.iss.insurancesys.service.impl.CustomerServiceImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Resource
    private CustomerServiceImpl customerService;

    @PostMapping("/customer")
    public Object addCustomer(@RequestBody @Valid Customer customer){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(customerService.addCustomer(customer));
        return resultInfo;
    }

    @GetMapping("/customer")
    public Object getCustomerList(@Max (value = 20, message = "clientName's length should less then 20") @RequestParam(value = "clientName") String clientName,
                                  @Max (value = 50) @RequestParam(value = "idCard") String idCard,
                                  @Max (value = 100) @RequestParam(value = "address") String address,
                                  @Max (value = 20)@RequestParam(value = "tel") String tel,
                                  @Email @Max(value = 50) @RequestParam(value = "email") String email,
                                  @RequestParam(value = "clientType")String[] clientType,
                                  @RequestParam(value = "sex")String[] sex,
                                  @NotNull @RequestParam(value = "limit")int limit,
                                  @NotNull @RequestParam(value = "page") int page){
        ResultInfo resultInfo = new ResultInfo();
        List<Map<String,String>> res = customerService.getCustomerList(clientName, idCard, address, tel, email,
                CustomerBaseInfo.clientType2clientTypeEnum(clientType), CustomerBaseInfo.sex2sexEnum(sex));
        resultInfo.setData(res);
        return resultInfo;
    }

    @GetMapping("/customer/{certfId}")
    public Object getCustomerByCId(@PathVariable(value = "certfId")String certfId){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setData(customerService.getCustomerById(certfId));
        return resultInfo;
    }

    @DeleteMapping("/customer/{certfId}")
    public Object deleteCustomerById(@PathVariable(value = "certfId")String certfId){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(customerService.deleteCustomerById(certfId));
        return resultInfo;
    }

    @GetMapping("/customer/friend")
    public Object getCustomerByName(@RequestParam(value = "name", required = false)String name,
                                    @RequestParam(value = "id", required = false)String id){
        ResultInfo resultInfo = new ResultInfo();
        if(name!=null){
            resultInfo.setData(customerService.getCustomerByName(name));
        }
        if(id !=null){
            resultInfo.setData(customerService.getFriendById(id));
        }
        return resultInfo;
    }

    @GetMapping("/customer/friends")
    public Object getFriendList(@RequestParam(value = "id")String idCard){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setData(customerService.getFriendList(idCard));
        return resultInfo;
    }

    @PostMapping("/customer/friend")
    public Object addRelationShip(@Valid @RequestBody CustomerRelationShip relationShip){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(customerService.addRelationShip(relationShip));
        return resultInfo;
    }

    @GetMapping("/customer/representative")
    public Object getRepresentative(@Max(20) @RequestParam(value = "queryString")String queryString){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setData(customerService.getRepresentative(queryString));
        return resultInfo;
    }

    @PutMapping("/customer")
    public Object updateCustomer(@RequestBody @Valid Customer customer){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(customerService.updateCustomer(customer));
        return resultInfo;
    }
}
