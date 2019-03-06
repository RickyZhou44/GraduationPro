package whu.iss.insurancesys.entity;

public class ClientContact {
    private String clientaId;

    private String clientbId;

    private String relation;

    public String getClientaId() {
        return clientaId;
    }

    public void setClientaId(String clientaId) {
        this.clientaId = clientaId == null ? null : clientaId.trim();
    }

    public String getClientbId() {
        return clientbId;
    }

    public void setClientbId(String clientbId) {
        this.clientbId = clientbId == null ? null : clientbId.trim();
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }
}