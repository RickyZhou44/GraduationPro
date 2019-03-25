package whu.iss.insurancesys.entity.SettlementParamEntities;

import java.util.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/24
 */
//投保人的基础信息
public class InsuredBasicInfo {
    private String name;//客户姓名
    private String lawIdentity;//法律身份
    private String type;//客户类型
    private String nation;//国籍
    private String certfType;//证件类型
    private String certfId;//证件号码
    private Date birthday;
    private int age;
    private String sex;//性别
    private String married;//是否已婚
    private String telephone;//手机
    private String email;//邮箱
    private String phone;//座机电话
    private String backup;//备用
    private String homeAddress;//家庭住址
    private String homeCode;//家庭邮编
    private String firstContactWay;//首选联系方式
    private String firstAddress;//首选联系地址
    private String other;//信息补充

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLawIdentity() {
        return lawIdentity;
    }

    public void setLawIdentity(String lawIdentity) {
        this.lawIdentity = lawIdentity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getCertfType() {
        return certfType;
    }

    public void setCertfType(String certfType) {
        this.certfType = certfType;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public void setFirstAddress(String firstAddress) {
        this.firstAddress = firstAddress;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
