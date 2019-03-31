package whu.iss.insurancesys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface PersonalOrganizationService {
    public List<Map<String,String>> searchPersonalOrganization(String [] branch, String[] dept, int number, String checkPoint,
                                                     boolean showLeave, String relationType, int level, boolean nameFiled,
                                                     boolean numberFiled, boolean deptFiled, String name,
                                                     boolean joinDateFiled, boolean rankStateFiled);

    public Map<String,String> searchPersonalRoot(String [] branch, String[] dept, int number, String checkPoint,
                                                               boolean showLeave, String relationType, int level, boolean nameFiled,
                                                               boolean numberFiled, boolean deptFiled, String name,
                                                               boolean joinDateFiled, boolean rankStateFiled);
}
