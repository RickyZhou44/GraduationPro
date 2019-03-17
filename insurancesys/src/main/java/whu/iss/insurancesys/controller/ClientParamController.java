package whu.iss.insurancesys.controller;

/*
 * @Author SeanShe
 * @Date 3/6/2019 14:01
 * Notes:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import whu.iss.insurancesys.entity.ClientParamEntities.ClientTypeParam;
import whu.iss.insurancesys.entity.ClientParamEntities.NationType;
import whu.iss.insurancesys.service.ClientParamService;

import java.util.List;

@RestController
@RequestMapping("/clientParam")
public class ClientParamController {

    @Autowired
    private ClientParamService clientParamService;

    @GetMapping("/getNationType")
    public List<NationType> getNationType(){

        return clientParamService.getAllNationType();

    }

    @GetMapping("/getClientTypeParam")
    public List<ClientTypeParam> getClientTypeParam(){

        return clientParamService.getAllClientTypeParam();

    }

}
