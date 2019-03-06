package whu.iss.insurancesys.entity;

public class InsurCompanyBasicInfo {
    private Integer companyId;

    private String companyName;

    private String companyType;

    private String chineseSimpleName;

    private String englishSimpleName;

    private String provinceCity;

    private String registeredBusinessAddress;

    private String phoneNumber;

    private String fax;

    private String email;

    private String website;

    private String note;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    public String getChineseSimpleName() {
        return chineseSimpleName;
    }

    public void setChineseSimpleName(String chineseSimpleName) {
        this.chineseSimpleName = chineseSimpleName == null ? null : chineseSimpleName.trim();
    }

    public String getEnglishSimpleName() {
        return englishSimpleName;
    }

    public void setEnglishSimpleName(String englishSimpleName) {
        this.englishSimpleName = englishSimpleName == null ? null : englishSimpleName.trim();
    }

    public String getProvinceCity() {
        return provinceCity;
    }

    public void setProvinceCity(String provinceCity) {
        this.provinceCity = provinceCity == null ? null : provinceCity.trim();
    }

    public String getRegisteredBusinessAddress() {
        return registeredBusinessAddress;
    }

    public void setRegisteredBusinessAddress(String registeredBusinessAddress) {
        this.registeredBusinessAddress = registeredBusinessAddress == null ? null : registeredBusinessAddress.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}