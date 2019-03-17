package whu.iss.insurancesys.entity.SettlementParamEntities;

/*
 * @Author SeanShe
 * @Date 3/6/2019 12:33
 * Notes:
 */

import lombok.Data;

import java.sql.Timestamp;

@Data
public class InsuranceTypeInfo {

	private int insurId;

	private String company;

	private String insuranceCname;

	private String insuranceSname;

	private String code;

	private String mainOrVice;

	private String praramType;

	private String insuranceType;

	private Timestamp startSaleTime;

	private Timestamp stopSaleTime;

	private String remark;

	private String commonYear;

}
