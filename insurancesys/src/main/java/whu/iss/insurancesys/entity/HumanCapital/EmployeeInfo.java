package whu.iss.insurancesys.entity.HumanCapital;

//import com.sun.istack.internal.NotNull;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import whu.iss.insurancesys.entity.EmployeeBasicInformation;
import whu.iss.insurancesys.entity.EmployeeUnitRank;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

public class EmployeeInfo {
    @NotNull
    @NotBlank
    @Length(max = 50)
    private String cName;

    @NotNull
    @NotBlank
    @Length(max = 50)
    private String eName;

    @NotNull
    @NotBlank
    @Length(max = 2)
    private String sex;

    @NotBlank
    @Length(max = 50)
    private String certfId;

    @NotBlank
    @Length(max = 50)
    private String certfType;

    private Date birthday;

    @NotNull
    private int num;

    @NotBlank
    @Length(max = 2)
    private String married;

    @NotNull
    @Length(max = 10)
    private String people;

    @Length(max = 20)
    private String blood;

    @NotNull
    @Length(max = 100)
    private String address;

    @Length(max = 7)
    private String code;

    @NotNull
    @Length(max = 11)
    private String tel;

    @Email
    private String email;

    @Length(max = 20)
    private String phone;


    @NotNull
    @Length(max = 30)
    private String emergencyContactName;

    @NotNull
    @Length(max = 11)
    private String emergencyContactPhone;

    @NotNull
    @Length(max = 50)
    private String emergencyContactEmail;

    @NotNull
    @Length(max = 50)
    private String branch;

    @NotNull
    @Length(max = 50)
    private String dept;

    @NotNull
    @Length(max = 50)
    private String introducer;

    @NotNull
    @Length(max = 50)
    private String serviceType;

    @NotNull
    @Length(max = 50)
    private String relationshipSuperior;

    @NotNull
    @Length(max = 50)
    private String currentRank;

    @NotNull
    @Length(max = 50)
    private String administrator;

    @Length(max = 50)
    private String administrator2;

    @NotNull
    private Date entryTime;

    @NotNull
    @Length(max = 50)
    private String contractNumber;

    @NotNull
    private Date contractStartTime;

    @NotNull
    private Date contractEndTime;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCertfId() {
        return certfId;
    }

    public void setCertfId(String certfId) {
        this.certfId = certfId;
    }

    public String getCertfType() {
        return certfType;
    }

    public void setCertfType(String certfType) {
        this.certfType = certfType;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public String getEmergencyContactEmail() {
        return emergencyContactEmail;
    }

    public void setEmergencyContactEmail(String emergencyContactEmail) {
        this.emergencyContactEmail = emergencyContactEmail;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getIntroducer() {
        return introducer;
    }

    public void setIntroducer(String introducer) {
        this.introducer = introducer;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getRelationshipSuperior() {
        return relationshipSuperior;
    }

    public void setRelationshipSuperior(String relationshipSuperior) {
        this.relationshipSuperior = relationshipSuperior;
    }

    public String getCurrentRank() {
        return currentRank;
    }

    public void setCurrentRank(String currentRank) {
        this.currentRank = currentRank;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    public String getAdministrator2() {
        return administrator2;
    }

    public void setAdministrator2(String administrator2) {
        this.administrator2 = administrator2;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Date getContractStartTime() {
        return contractStartTime;
    }

    public void setContractStartTime(Date contractStartTime) {
        this.contractStartTime = contractStartTime;
    }

    public Date getContractEndTime() {
        return contractEndTime;
    }

    public void setContractEndTime(Date contractEndTime) {
        this.contractEndTime = contractEndTime;
    }

    public static EmployeeBasicInformation getBasicInfo(EmployeeInfo employeeInfo){
        EmployeeBasicInformation basicInfo = new EmployeeBasicInformation();
        basicInfo.setBirthday(employeeInfo.getBirthday());
        basicInfo.setBloodGroup(employeeInfo.getBlood());
        basicInfo.setPostalCode(employeeInfo.getCode());
        basicInfo.setCertificateNo(employeeInfo.getCertfId());
        basicInfo.setCertificateTypeName(employeeInfo.getCertfType());
        basicInfo.setChineseName(employeeInfo.getcName());
        basicInfo.setContactAddress(employeeInfo.getAddress());
        basicInfo.setEmail(employeeInfo.getEmail());
        basicInfo.setEmergencyContactAddress(employeeInfo.getEmergencyContactEmail());
        basicInfo.setEmergencyContactName(employeeInfo.getEmergencyContactName());
        basicInfo.setEmergencyContactPhoneNumber(employeeInfo.getEmergencyContactPhone());
        basicInfo.setEmployeeNo(employeeInfo.getNum());
        basicInfo.setEnglishName(employeeInfo.geteName());
        basicInfo.setGender(employeeInfo.getSex());
        basicInfo.setMaritalStatus(employeeInfo.getMarried());
        basicInfo.setNationalityName(employeeInfo.getPeople());
        basicInfo.setPhoneNumber(employeeInfo.getTel());
        basicInfo.setLandlineNumber(employeeInfo.getPhone());
        return basicInfo;
    }

    public static EmployeeUnitRank getUnitInfo(EmployeeInfo employeeInfo){
        EmployeeUnitRank unitInfo = new EmployeeUnitRank();
        unitInfo.setEmployNo(employeeInfo.getNum());
        unitInfo.setBranchName(employeeInfo.getBranch());
        unitInfo.setDepartment(employeeInfo.getDept());
        unitInfo.setCurrentRank(employeeInfo.getCurrentRank());
        unitInfo.setServiceType(employeeInfo.getServiceType());
        unitInfo.setIntroducerName(employeeInfo.getIntroducer());
        unitInfo.setRelationshipSuperiorName(employeeInfo.getRelationshipSuperior());
        unitInfo.setAdministratorName(employeeInfo.getAdministrator());
        unitInfo.setAdministrator2Name(employeeInfo.getAdministrator2());
        unitInfo.setEntryTime(employeeInfo.getEntryTime());
        unitInfo.setContractNumber(employeeInfo.getContractNumber());
        unitInfo.setContractStarttime(employeeInfo.getContractStartTime());
        unitInfo.setContractEndtime(employeeInfo.getContractEndTime());
        return unitInfo;
    }
}
