package whu.iss.insurancesys.dao.FeeRateDaos;

import whu.iss.insurancesys.entity.FeeRateEntities.CarInsuranceTypePlus;
import whu.iss.insurancesys.entity.FeeRateEntities.CarInsuranceType;

import java.util.List;

public interface CarInsuranceTypeDao {

    int insert(CarInsuranceType record);

    int insertSelective(CarInsuranceType record);

    List<CarInsuranceTypePlus> getByName(List<String> companyName);

}