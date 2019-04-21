package whu.iss.insurancesys.entity.customer;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class CustomerRelationShip {
    @NotBlank
    @Length(max = 50)
    private String idA;

    @NotBlank
    @Length(max = 50)
    private String idB;

    @NotBlank
    @Length(max = 50)
    private String relation;

    public String getIdA() {
        return idA;
    }

    public void setIdA(String idA) {
        this.idA = idA;
    }

    public String getIdB() {
        return idB;
    }

    public void setIdB(String idB) {
        this.idB = idB;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
