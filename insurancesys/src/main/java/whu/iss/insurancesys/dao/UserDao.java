package whu.iss.insurancesys.dao;

import org.springframework.stereotype.Repository;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/1
 */
@Repository
public interface UserDao {
    Integer getAge(String id);
}
