package whu.iss.insurancesys.controller;

/*
 * @Author SeanShe
 * @Date 3/6/2019 16:50
 * Notes:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import whu.iss.insurancesys.service.HumanResourceParamService;

@RestController
@RequestMapping("/humanResourceParam")
public class HumanResourceParamController {

    @Autowired
    private HumanResourceParamService humanResourceParamService;

}
