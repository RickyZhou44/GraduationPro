package whu.iss.insurancesys.entity.HumanResourceParamEntities;

/*
 * @Author SeanShe
 * @Date 3/6/2019 15:56
 * Notes:
 */

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommissionSystemParam {

	private String code;

	private String name;

	private Timestamp createTime;

}
