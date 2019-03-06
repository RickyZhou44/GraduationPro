package whu.iss.insurancesys.entity;

public class ClientVehicle {
    private Integer id;

    private String certfId;

    private String licensePlateNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCertfId() {
        return certfId;
    }

    public void setCertfId(String certfId) {
        this.certfId = certfId == null ? null : certfId.trim();
    }

    public String getLicensePlateNo() {
        return licensePlateNo;
    }

    public void setLicensePlateNo(String licensePlateNo) {
        this.licensePlateNo = licensePlateNo == null ? null : licensePlateNo.trim();
    }
}