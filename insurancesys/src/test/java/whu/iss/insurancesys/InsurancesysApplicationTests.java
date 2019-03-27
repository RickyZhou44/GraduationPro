package whu.iss.insurancesys;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import whu.iss.insurancesys.dao.EmployeeBasicInformationDao;
import whu.iss.insurancesys.dao.EmployeeUnitRankDao;
import whu.iss.insurancesys.entity.EmployeeBasicInformation;
import whu.iss.insurancesys.entity.EmployeeUnitRank;
import whu.iss.insurancesys.util.JPZUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsurancesysApplicationTests {

    @Resource
    private EmployeeBasicInformationDao employeeBasicInformationDao;
    @Resource
    private EmployeeUnitRankDao employeeUnitRankDao;

    @Test
    public void contextLoads() {
    }


    @Transactional
    @Rollback(false)
    @Test
    public void insertData() {
        String[] genders = {"女", "男"};
        String[] maritalStatuses = {"未婚", "已婚", "离婚", "丧偶"};
        String[] blodTypes = {"A型", "B型", "AB型", "O型"};

        String[] branchNames = {"北京分公司", "上海分公司", "广州分公司", "深圳分公司"};
        String[] departments = {"客服部", "营销部", "人力资源部", "财务部", "业务部", "拓展部"};
        String[] ranks = {"总经理", "部门经理", "内勤人员", "结算管理员", "出单员", "培训管理"};
        String[] states = {"晋升", "考核"};

        for (int i = 1; i <= 200; i++) {
            int employee_no = i;
            String chineseName = JPZUtil.getRandomName(4);
            String englishName = chineseName;
            Random random = new Random();
            int num = random.nextInt(2);
            String sex = genders[num];
            String certificateTypeName = "身份证";
            String certificateNo = JPZUtil.getFixLenthNumber(18);
            Date birthday = JPZUtil.getRandomDate("1960-01-01", "2000-01-01", "yyyy-MM-dd");
            num = random.nextInt(4);
            String martialStatus = maritalStatuses[num];
            String nationalityName = "汉族";
            num = random.nextInt(4);
            String blodType = blodTypes[num];
            String contactAddress = JPZUtil.getRandomName(30);
            String postalCode = null;
            String phoneNum = JPZUtil.getFixLenthNumber(11);
            String email = JPZUtil.getFixLenthNumber(8) + "@qq.com";
            String landlineNumber = null;
            String emergencyContactName = JPZUtil.getRandomName(5);
            String emergencyContactPhoneNumber = JPZUtil.getFixLenthNumber(11);
            String emergencyContactAddress = JPZUtil.getRandomName(30);
            String familyPhone = null;
            String familyAddress = null;
            String familyAddressPostalCode = null;
            String birthplace = null;
            String householdRegistration = null;
            EmployeeBasicInformation employeeBasicInformation = new EmployeeBasicInformation();
            employeeBasicInformation.setEmployeeNo(employee_no);
            employeeBasicInformation.setEnglishName(englishName);
            employeeBasicInformation.setGender(sex);
            employeeBasicInformation.setCertificateTypeName(certificateTypeName);
            employeeBasicInformation.setCertificateNo(certificateNo);
            employeeBasicInformation.setBirthday(birthday);
            employeeBasicInformation.setMaritalStatus(martialStatus);
            employeeBasicInformation.setNationalityName(nationalityName);
            employeeBasicInformation.setBloodGroup(blodType);
            employeeBasicInformation.setContactAddress(contactAddress);
            employeeBasicInformation.setPhoneNumber(phoneNum);
            employeeBasicInformation.setEmail(email);
            employeeBasicInformation.setEmergencyContactName(emergencyContactName);
            employeeBasicInformation.setEmergencyContactPhoneNumber(emergencyContactPhoneNumber);
            employeeBasicInformation.setEmergencyContactAddress(emergencyContactAddress);
            employeeBasicInformationDao.insert(employeeBasicInformation);

            num = random.nextInt(4);
            String branchName = branchNames[num];
            num = random.nextInt(6);
            String department = departments[num];
            num = random.nextInt(6);
            String rank = ranks[num];
            String serviceType = rank;
            String introducerName = JPZUtil.getRandomName(4);
            String relationshipSuperiorName = JPZUtil.getRandomName(4);
            String administratorName = JPZUtil.getRandomName(4);
            Date entryTime = JPZUtil.getRandomDate("2002-01-01", "2018-12-31", "yyyy-MM-dd");
            String contractNumber = JPZUtil.getFixLenthNumber(6);
            Date contractStarttime = entryTime;
            Date contractEndTime = JPZUtil.dateAddYear(contractStarttime, 3);
            num = random.nextInt(2);
            String state = states[num];
            EmployeeUnitRank employeeUnitRank = new EmployeeUnitRank();
            employeeUnitRank.setEmployNo(employee_no);
            employeeUnitRank.setBranchName(branchName);
            employeeUnitRank.setDepartment(department);
            employeeUnitRank.setCurrentRank(rank);
            employeeUnitRank.setServiceType(serviceType);
            employeeUnitRank.setRelationshipSuperiorName(relationshipSuperiorName);
            employeeUnitRank.setIntroducerName(introducerName);
            employeeUnitRank.setAdministratorName(administratorName);
            employeeUnitRank.setEntryTime(entryTime);
            employeeUnitRank.setContractNumber(contractNumber);
            employeeUnitRank.setContractStarttime(contractStarttime);
            employeeUnitRank.setContractEndtime(contractEndTime);
            employeeUnitRank.setState(state);
            employeeUnitRankDao.insert(employeeUnitRank);
        }
    }

}
