package whu.iss.insurancesys.controller;

import org.apache.ibatis.jdbc.Null;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import whu.iss.insurancesys.dto.ResultInfo;
import whu.iss.insurancesys.service.impl.PersonalOrganizationServiceImpl;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class PersonalOrganizationController {

    @Resource
    private PersonalOrganizationServiceImpl personalOrganizationService;

    @GetMapping("/personalOrganization")
    public Object searchPersonalOrganization(@RequestParam(value = "branch", required = false) String [] branch,
                                             @RequestParam(value = "dept", required = false) String[] dept,
                                             @RequestParam(value = "number", required = false) String number,
                                             @RequestParam(value = "checkPoint", required = false)String checkPoint,
                                             @RequestParam(value = "showLeave") boolean showLeave,
                                             @RequestParam(value = "type")String relationType,
                                             @RequestParam(value = "level", defaultValue = "1") int level,
                                             @RequestParam(value = "nameFiled") boolean nameFiled,
                                             @RequestParam(value = "numberFiled") boolean numberFiled,
                                             @RequestParam(value = "deptFiled") boolean deptFiled,
                                             @RequestParam(value = "rankFiled") String name,
                                             @RequestParam(value = "joinDateFiled") boolean joinDateFiled,
                                             @RequestParam(value = "rankStateFiled") boolean rankStateFiled){

        ResultInfo resultInfo = new ResultInfo();
        if ((branch == null||branch.length==0) && (dept == null||dept.length==0) && (number==null||!number.matches("\\d+"))){
            resultInfo.setResult(false);
            resultInfo.setReason("根节点不能为空");
            return resultInfo;
        } else if (relationType.equals("")){
            resultInfo.setResult(false);
            resultInfo.setReason("上下级类型不能为空");
            return resultInfo;
        }
        int num;
        if(number==null||!number.matches("\\d+")){
            num = -1;
        }else {
            num = Integer.valueOf(number);
        }
        resultInfo.setData(personalOrganizationService.searchPersonalOrganization(branch,dept,num,checkPoint,
                showLeave,relationType,level,nameFiled,numberFiled,deptFiled,name,joinDateFiled,rankStateFiled));
        resultInfo.setResult(true);
        return resultInfo;
    }

    @GetMapping("/personalOrganization/root")
    public Object searchPersonalOrganizationRoot(@RequestParam(value = "branch", required = false) String [] branch,
                                             @RequestParam(value = "dept", required = false) String[] dept,
                                             @RequestParam(value = "number", required = false) String number,
                                             @RequestParam(value = "checkPoint", required = false)String checkPoint,
                                             @RequestParam(value = "showLeave") boolean showLeave,
                                             @RequestParam(value = "type")String relationType,
                                             @RequestParam(value = "level", defaultValue = "1") int level,
                                             @RequestParam(value = "nameFiled") boolean nameFiled,
                                             @RequestParam(value = "numberFiled") boolean numberFiled,
                                             @RequestParam(value = "deptFiled") boolean deptFiled,
                                             @RequestParam(value = "rankFiled") String name,
                                             @RequestParam(value = "joinDateFiled") boolean joinDateFiled,
                                             @RequestParam(value = "rankStateFiled") boolean rankStateFiled){

        ResultInfo resultInfo = new ResultInfo();
        if ((branch == null||branch.length==0) && (dept == null||dept.length==0) && (number==null||!number.matches("\\d+"))){
            resultInfo.setResult(false);
            resultInfo.setReason("根节点不能为空");
            return resultInfo;
        } else if (relationType.equals("")){
            resultInfo.setResult(false);
            resultInfo.setReason("上下级类型不能为空");
            return resultInfo;
        }
        int num;
        if(number==null||!number.matches("\\d+")){
            num = -1;
        }else {
            num = Integer.valueOf(number);
        }
        resultInfo.setData(personalOrganizationService.searchPersonalRoot(branch,dept,num,checkPoint,
                showLeave,relationType,level,nameFiled,numberFiled,deptFiled,name,joinDateFiled,rankStateFiled));
        resultInfo.setResult(true);
        return resultInfo;
    }
}
