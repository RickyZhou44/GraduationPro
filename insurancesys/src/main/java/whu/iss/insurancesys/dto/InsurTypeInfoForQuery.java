package whu.iss.insurancesys.dto;

/*
 * @Author SeanShe
 * @Date 3/25/2019 16:40
 * Notes:
 * */

import java.util.Date;

public class InsurTypeInfoForQuery {

    private String[] companies;
    private String insuranceCname;
    private String code;
    private String mainOrVice;
    private String paramType;
    private Date startFrom;
    private Date startTo;
    private Date endFrom;
    private Date endTo;

    public String[] getCompanies() {
        return companies;
    }

    public void setCompanies(String[] companies) {
        this.companies = companies;
    }

    public String getInsuranceCname() {
        return insuranceCname;
    }

    public void setInsuranceCname(String insuranceCname) {
        this.insuranceCname = insuranceCname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMainOrVice() {
        return mainOrVice;
    }

    public void setMainOrVice(String mainOrVice) {
        this.mainOrVice = mainOrVice;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public Date getStartFrom() {
        return startFrom;
    }

    public void setStartFrom(Date startFrom) {
        this.startFrom = startFrom;
    }

    public Date getStartTo() {
        return startTo;
    }

    public void setStartTo(Date startTo) {
        this.startTo = startTo;
    }

    public Date getEndFrom() {
        return endFrom;
    }

    public void setEndFrom(Date endFrom) {
        this.endFrom = endFrom;
    }

    public Date getEndTo() {
        return endTo;
    }

    public void setEndTo(Date endTo) {
        this.endTo = endTo;
    }
}
