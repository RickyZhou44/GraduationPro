package whu.iss.insurancesys;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import whu.iss.insurancesys.dao.EmployeeBasicInformationDao;
import whu.iss.insurancesys.entity.EmployeeBasicInformation;
import whu.iss.insurancesys.util.JPZUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsurancesysApplicationTests {
    
    @Resource
    private EmployeeBasicInformationDao employeeBasicInformationDao;

    @Test
    public void contextLoads() {
    }


    @Transactional
    @Rollback(false)
    @Test
    public void insertEmployeeData() {
        String[] genders = {"女", "男"};
        String[] maritalStatuses = {"未婚", "已婚", "离婚", "丧偶"};
        String[] blodTypes = {"A型", "B型", "AB型", "O型"};
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
            employeeBasicInformationDao.insertSelective(employeeBasicInformation);
        }
    }

}
