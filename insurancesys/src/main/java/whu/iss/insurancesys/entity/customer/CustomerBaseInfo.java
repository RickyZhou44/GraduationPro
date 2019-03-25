package whu.iss.insurancesys.entity.customer;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class CustomerBaseInfo {

    @NotBlank(message = "client name should not be empty")
    @Length(max = 20, message = "client name should be less then 20")
    private String name;

    @NotBlank
    @Length(max = 10)
    private String identity;

    private int identityEnum;

    @NotBlank
    @Length(max = 10)
    private String nation;

    private int nationEnum;

    @NotBlank
    @Length(max = 10)
    private String certfType;

    private int certfTypeEnum;

    @NotBlank
    @Length(max = 50)
    private String certfId;

    private Date birthday;

    @NotBlank
    @Length(max = 1)
    private String sex;

    private int sexEnum;

    @NotBlank
    @Length(max = 2)
    private String married;

    private int marriedEnum;

    @Length(max = 20)
    private String telephone;

    @Length(max = 20)
    private String phone;

    @Email
    @Length(max = 50)
    private String email;

    @Length(max = 50)
    private String backup;

    @Length(max = 100)
    private String homeAddress;

    @Length(max = 20)
    private String homeCode;

    @NotBlank
    @Length(max = 10)
    private String firstContactWay;

    private int firstContactWayEnum;

    @Length(max = 100)
    private String other;

    @NotBlank
    @Length(max = 50)
    private String type;

    private int typeEnum;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        if(type.equals("已投保客户")){
            this.typeEnum = 1;
        }else if(type.equals("潜在客户")){
            this.typeEnum = 2;
        }else if(type.equals("团险客户")){
            this.typeEnum = 3;
        }
    }

    public int getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(int typeEnum) {
        this.typeEnum = typeEnum;
        switch (typeEnum){
            case 1:
                this.type = "已投保客户";break;
            case 2:
                this.type = "潜在客户";break;
            case 3:
                this.type = "团险客户";break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
        if(identity.equals("法人")){
            this.identityEnum = 1;
        }else if(identity.equals("自然人")){
            this.identityEnum = 2;
        }
    }

    public int getIdentityEnum() {
        return identityEnum;
    }

    public void setIdentityEnum(int identityEnum) {
        this.identityEnum = identityEnum;
        switch (identityEnum){
            case 1:
                this.identity = "法人";
                break;
            case 2:
                this.identity = "自然人";
                break;
        }
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
        if(nation.equals("中国")){
            this.nationEnum = 1;
        }else if(nation.equals("外籍")){
            this.nationEnum = 2;
        }else if(nation.equals("港澳台")){
            this.nationEnum = 3;
        }
    }

    public int getNationEnum() {
        return nationEnum;
    }

    public void setNationEnum(int nationEnum) {
        this.nationEnum = nationEnum;
        switch (nationEnum){
            case 1:
                this.nation = "中国";break;
            case 2:
                this.nation = "外籍";break;
            case 3:
                this.nation = "港澳台"; break;
        }
    }

    public String getCertfType() {
        return certfType;
    }

    public void setCertfType(String certfType) {
        this.certfType = certfType;
        switch (certfType){
            case "身份证":
                this.certfTypeEnum = 1;break;
            case "军官证":
                this.certfTypeEnum = 2;break;
            case "出生证":
                this.certfTypeEnum = 3;break;
            case "台胞证":
                this.certfTypeEnum = 4;break;
            case "护照":
                this.certfTypeEnum = 5;break;
            case "港澳通行证":
                this.certfTypeEnum = 6;break;
        }
    }

    public int getCertfTypeEnum() {
        return certfTypeEnum;
    }

    public void setCertfTypeEnum(int certfTypeEnum) {
        this.certfTypeEnum = certfTypeEnum;
        switch (certfTypeEnum){
            case 1:
                this.certfType = "身份证";break;
            case 2:
                this.certfType = "军官证";break;
            case 3:
                this.certfType = "出生证";break;
            case 4:
                this.certfType = "台胞证";break;
            case 5:
                this.certfType = "护照";break;
            case 6:
                this.certfType = "港澳通行证";break;
        }
    }

    public String getCertfId() {
        return certfId;
    }

    public void setCertfId(String certfId) {
        this.certfId = certfId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        switch (sex){
            case "男":
                this.sexEnum = 1;break;
            case "女":
                this.sexEnum = 2;break;
        }
    }

    public int getSexEnum() {
        return sexEnum;
    }

    public void setSexEnum(int sexEnum) {
        this.sexEnum = sexEnum;
        switch (sexEnum){
            case 1:
                this.sex = "男";break;
            case 2:
                this.sex = "女";break;
        }
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
        switch (married){
            case "未婚":
                this.marriedEnum = 1;break;
            case "已婚":
                this.marriedEnum = 2;break;
            case "离异":
                this.marriedEnum = 3;break;
            case "丧偶":
                this.marriedEnum = 4;break;
        }
    }

    public int getMarriedEnum() {
        return marriedEnum;
    }

    public void setMarriedEnum(int marriedEnum) {
        this.marriedEnum = marriedEnum;
        switch (marriedEnum){
            case 1:
                this.married = "未婚";break;
            case 2:
                this.married = "已婚";break;
            case 3:
                this.married = "离异";break;
            case 4:
                this.married = "丧偶";break;
        }
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomeCode() {
        return homeCode;
    }

    public void setHomeCode(String homeCode) {
        this.homeCode = homeCode;
    }

    public String getFirstContactWay() {
        return firstContactWay;
    }

    public void setFirstContactWay(String firstContactWay) {
        this.firstContactWay = firstContactWay;
        switch (firstContactWay){
            case "手机":
                this.firstContactWayEnum = 1;break;
            case "家庭电话":
                this.firstContactWayEnum = 2;break;
            case "公司电话":
                this.firstContactWayEnum = 3;break;
        }
    }

    public int getFirstContactWayEnum() {
        return firstContactWayEnum;
    }

    public void setFirstContactWayEnum(int firstContactWayEnum) {
        this.firstContactWayEnum = firstContactWayEnum;
        switch (firstContactWayEnum){
            case 1:
                this.firstContactWay = "手机";break;
            case 2:
                this.firstContactWay = "家庭电话";break;
            case 3:
                this.firstContactWay = "公司电话";break;
        }
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
