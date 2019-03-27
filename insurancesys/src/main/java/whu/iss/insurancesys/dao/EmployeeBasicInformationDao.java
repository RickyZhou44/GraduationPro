package whu.iss.insurancesys.dao;

import org.springframework.stereotype.Repository;
import whu.iss.insurancesys.entity.EmployeeBasicInformation;

@Repository
public interface EmployeeBasicInformationDao {
    int insert(EmployeeBasicInformation record);

}