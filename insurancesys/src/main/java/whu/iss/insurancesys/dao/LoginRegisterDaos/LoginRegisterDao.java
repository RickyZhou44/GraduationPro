package whu.iss.insurancesys.dao.LoginRegisterDaos;

import org.springframework.stereotype.Repository;
import whu.iss.insurancesys.entity.LoginRegisterEntities.Account;

import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/31
 */
@Repository
public interface LoginRegisterDao {
    public List<Account>getAccounts();
}
