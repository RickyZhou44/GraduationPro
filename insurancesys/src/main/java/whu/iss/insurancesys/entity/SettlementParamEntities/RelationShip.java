package whu.iss.insurancesys.entity.SettlementParamEntities;

import java.util.Date;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/24
 */
//存储相关亲戚朋友信息
public class RelationShip {
    private String name;
    private String sex;
    private String telephone;
    private String certf_id;
    private String relation;
    private Date birthday;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCertf_id() {
        return certf_id;
    }

    public void setCertf_id(String certf_id) {
        this.certf_id = certf_id;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
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
}
