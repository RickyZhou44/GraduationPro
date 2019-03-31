package whu.iss.insurancesys.service.impl;

import org.springframework.stereotype.Service;
import whu.iss.insurancesys.dao.HumanCapital.PersonalOrganizationDao;
import whu.iss.insurancesys.service.PersonalOrganizationService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class PersonalOrganizationServiceImpl implements PersonalOrganizationService {

    @Resource
    private PersonalOrganizationDao personalOrganizationDao;
    @Override
    public List<Map<String,String>> searchPersonalOrganization(String[] branch, String[] dept, int number,
                                                               String checkPoint, boolean showLeave,
                                                               String relationType, int level, boolean nameFiled,
                                                               boolean numberFiled, boolean deptFiled, String name,
                                                               boolean joinDateFiled, boolean rankStateFiled) {
        List<Map<String,String>> res =  personalOrganizationDao.searchPersonalInNum(number,checkPoint,relationType,nameFiled,numberFiled,
                deptFiled,name,joinDateFiled);
        if(rankStateFiled){
            for(Map<String,String> item : res){
                int r = Integer.valueOf(String.valueOf(item.get("employee_no")));
                String temp = personalOrganizationDao.searchStateByNum(r);
                if(temp==null){
                    temp="在职";
                }
                item.put("state", temp);
            }
        }
        if(!showLeave){

        }
        return res;
    }

    @Override
    public Map<String, String> searchPersonalRoot(String[] branch, String[] dept, int number,
                                                        String checkPoint, boolean showLeave,
                                                        String relationType, int level, boolean nameFiled,
                                                        boolean numberFiled, boolean deptFiled, String name,
                                                        boolean joinDateFiled, boolean rankStateFiled){
        Map<String,String> res = personalOrganizationDao.searchRootPersonal(number,checkPoint,relationType,nameFiled,
                numberFiled,deptFiled,name,joinDateFiled);
        if(rankStateFiled){
            String temp = personalOrganizationDao.searchStateByNum(number);
            if(temp==null){
                temp="在职";
            }
            res.put("state", temp);
        }
        if(!showLeave&&res.get("state").equals("离职")){
            return null;
        }
        return res;
    }
}
