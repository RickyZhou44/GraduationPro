package whu.iss.insurancesys.dao.HumanCapital;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PersonalOrganizationDao {

    public List<Map<String,String>> searchPersonalInNum(@Param("num") int number,
                                                          @Param("checkPoint") String checkPoint,
                                                          @Param("relationType") String relationType,
                                                          @Param("nameFiled") boolean nameFiled,
                                                          @Param("numberFiled")boolean numberFiled,
                                                          @Param("deptFiled")boolean deptFiled,
                                                          @Param("rankName")String name,
                                                          @Param("joinDateFiled") boolean joinDateFiled);

    public String searchStateByNum(@Param("employee_no") int number);

    public Map<String,String> searchRootPersonal(@Param("num") int number,
                                                 @Param("checkPoint") String checkPoint,
                                                 @Param("relationType") String relationType,
                                                 @Param("nameFiled") boolean nameFiled,
                                                 @Param("numberFiled")boolean numberFiled,
                                                 @Param("deptFiled")boolean deptFiled,
                                                 @Param("rankName")String name,
                                                 @Param("joinDateFiled") boolean joinDateFiled);
}
