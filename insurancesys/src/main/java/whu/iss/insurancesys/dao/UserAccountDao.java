package whu.iss.insurancesys.dao;

/*
 * @Author SeanShe
 * @Date 2019/3/30 12:21
 * Notes:
 * */

import org.apache.ibatis.annotations.Param;
import whu.iss.insurancesys.entity.UserAccount;

public interface UserAccountDao {

    UserAccount getByUserName(@Param("username")String name);

    int update(UserAccount userAccount);

    int updatePassword(@Param("userNo")int no,
                       @Param("username")String username,
                       @Param("password")String password);

    int deleteByUserNo(@Param("userNo") int userNo);

    int insert(UserAccount userAccount);

}
