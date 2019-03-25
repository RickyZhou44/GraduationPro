package whu.iss.insurancesys.controller;

import org.springframework.web.bind.annotation.*;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.customer.Customer;
import whu.iss.insurancesys.service.impl.CustomerServiceImpl;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;

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
                                  @Email @Max(value = 50) @RequestParam(value = "email") String email){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setData(customerService.getCustomerList(clientName, idCard, address, tel, email));
        return resultInfo;
    }

    @GetMapping("/customer/{certfId}")
    public Object getCustomerByCId(@PathVariable(value = "certfId")String certfId){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setData(customerService.getCustomerById(certfId));
        return resultInfo;
    }
}
