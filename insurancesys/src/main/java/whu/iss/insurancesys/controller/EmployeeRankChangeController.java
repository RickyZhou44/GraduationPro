package whu.iss.insurancesys.controller;

import org.springframework.web.bind.annotation.*;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.HumanCapital.EmployeeRankChangeInfo;
import whu.iss.insurancesys.service.impl.EmployeeRankChangeServiceImpl;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
public class EmployeeRankChangeController {

    @Resource
    private EmployeeRankChangeServiceImpl rankChangeService;

    @PostMapping("/rankChange")
    public Object addRankChange(@RequestBody @Valid EmployeeRankChangeInfo rankChangeInfo){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(rankChangeService.addRankChange(rankChangeInfo));
        return resultInfo;
    }

    @GetMapping("/rankChange/{staffNo}")
    public Object getRankChangeByNum(@PathVariable("staffNo") String staffNo){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setData(rankChangeService.getRankChangeByNum(staffNo));
        return resultInfo;
    }
}
