package whu.iss.insurancesys.dao.LoginRegisterDaos;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import whu.iss.insurancesys.entity.LoginRegisterEntities.Account;

import java.util.Date;
import java.util.List;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/31
 */
//修改了一下名字
@Repository
public interface LoginRegisterDao {
    public List<Account>getAccounts();
    public void addAccount(@Param("user")String user, @Param("name")String name, @Param("email")String email, @Param("password")String password, @Param("date")Date date);
}
