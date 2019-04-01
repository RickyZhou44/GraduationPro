package whu.iss.insurancesys.controller;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.web.bind.annotation.*;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.entity.HumanCapital.EmployeeInfo;
import whu.iss.insurancesys.service.PersonRankService;
import whu.iss.insurancesys.service.impl.PersonRankServiceImpl;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PersonRankController {

    @Resource
    private PersonRankServiceImpl personRankService;

    @GetMapping("/personRank")
    public Object getPersonRank(@Max(50)@RequestParam("staffNo") String staffNo,
                                @Max(50)@RequestParam("staffName") String staffName,
                                @Max(50)@RequestParam("branch") String branch,
                                @Max(50)@RequestParam("dept") String dept,
                                @Max(11)@RequestParam("tel") String tel,
                                @Max (50)@RequestParam("rank") String rank,
                                @NotNull @RequestParam(value = "limit")int limit,
                                @NotNull @RequestParam(value = "page") int page){
        ResultInfo resultInfo = new ResultInfo();
        Map<String, Object> res = new HashMap<>();
        List<Map<String,String>> mapList = personRankService.getPersonRankList(staffNo,staffName,branch,dept,tel,rank);
        res.put("total", mapList.size());
        int offset = (page-1)*limit;
        if(offset>=mapList.size()){
            offset=0;
        }
        if(offset+limit > mapList.size()){
            res.put("list", mapList.subList(offset, mapList.size()));
        }else {
            res.put("list", mapList.subList((page - 1) * limit, (page - 1) * limit + limit));
        }
        resultInfo.setData(res);
        return resultInfo;
    }

    @DeleteMapping("/personRank/{num}")
    public Object deletePersonRankByNum(@PathVariable(value = "num")int num){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(personRankService.deletePersonRankByNum(num));
        return resultInfo;
    }

    @GetMapping("/personRank/staff")
    public Object getStaffByName(@RequestParam("name")String input){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setData(personRankService.getStaffByName(input));
        return resultInfo;
    }

    @GetMapping("/personRank/{num}")
    public Object getPersonRankByNum(@PathVariable(value = "num")int num){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setData(personRankService.getPersonRankByNum(num));
        return resultInfo;
    }

    @PostMapping("/personRank")
    public Object addPersonRank(@RequestBody @Valid EmployeeInfo employeeInfo){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(personRankService.addPersonRank(employeeInfo));
        return resultInfo;
    }

    @PutMapping("/personRank")
    public Object updatePersonRankOne(@RequestBody @Valid EmployeeInfo employeeInfo){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(personRankService.updatePersonRankOne(employeeInfo));
        return resultInfo;
    }
}
