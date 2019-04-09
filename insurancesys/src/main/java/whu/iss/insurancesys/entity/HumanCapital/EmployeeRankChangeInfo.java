package whu.iss.insurancesys.entity.HumanCapital;
//
//import com.sun.istack.internal.NotNull;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import whu.iss.insurancesys.entity.EmployeeUnitRank;

import java.sql.Date;

public class EmployeeRankChangeInfo {

    @NotNull
    @Length(max = 50)
    private String introducerName;

    @NotNull
    @Length(max = 50)
    private String relationshipSuperiorName;

    @NotNull
    @Length(max = 50)
    private String administrator;

    @Length(max = 50)
    private String administrator2;

    @NotNull
    private Date rankStartTime;

    @NotNull
    private Date rankEndTime;

    private String backup;

    @NotNull
    @Length(max = 50)
    private String reason;

    @NotNull
    @Length(max = 50)
    private String toBranch;

    @NotNull
    @Length(max = 50)
    private String toDept;

    @NotNull
    @Length(max = 50)
    private String toRank;

    @NotNull
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getIntroducerName() {
        return introducerName;
    }

    public void setIntroducerName(String introducerName) {
        this.introducerName = introducerName;
    }

    public String getRelationshipSuperiorName() {
        return relationshipSuperiorName;
    }

    public void setRelationshipSuperiorName(String relationshipSuperiorName) {
        this.relationshipSuperiorName = relationshipSuperiorName;
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

    public Date getRankStartTime() {
        return rankStartTime;
    }

    public void setRankStartTime(Date rankStartTime) {
        this.rankStartTime = rankStartTime;
    }

    public Date getRankEndTime() {
        return rankEndTime;
    }

    public void setRankEndTime(Date rankEndTime) {
        this.rankEndTime = rankEndTime;
    }

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getToBranch() {
        return toBranch;
    }

    public void setToBranch(String toBranch) {
        this.toBranch = toBranch;
    }

    public String getToDept() {
        return toDept;
    }

    public void setToDept(String toDept) {
        this.toDept = toDept;
    }

    public String getToRank() {
        return toRank;
    }

    public void setToRank(String toRank) {
        this.toRank = toRank;
    }

    public static EmployeeUnitRank getUnitRankInfo(EmployeeRankChangeInfo rankChangeInfo){
        EmployeeUnitRank rank = new EmployeeUnitRank();
        rank.setEmployNo(rankChangeInfo.getNum());
        rank.setContractStarttime(rankChangeInfo.getRankStartTime());
        rank.setContractEndtime(rankChangeInfo.getRankEndTime());
        rank.setBranchName(rankChangeInfo.getToBranch());
        rank.setDepartment(rankChangeInfo.getToDept());
        rank.setCurrentRank(rankChangeInfo.getToRank());
        rank.setIntroducerName(rankChangeInfo.getIntroducerName());
        rank.setRelationshipSuperiorName(rankChangeInfo.getRelationshipSuperiorName());
        rank.setAdministratorName(rankChangeInfo.getAdministrator());
        rank.setAdministrator2Name(rankChangeInfo.getAdministrator2());
        return rank;
    }
}
