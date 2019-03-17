package whu.iss.insurancesys.entity.SettlementParamEntities;

/*
 * @Author SeanShe
 * @Date 3/6/2019 12:33
 * Notes:
 */

import lombok.Data;

import java.sql.Timestamp;

@Data
public class SettleAccountParam {

	private int insurId;

	private int year;

	private double rate;

	private Timestamp payDateStart;

	private Timestamp payDateEnd;

	private Timestamp validateDateStart;

	private Timestamp validateDateEnd;

}
