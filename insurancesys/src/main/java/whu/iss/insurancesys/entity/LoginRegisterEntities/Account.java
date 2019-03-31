package whu.iss.insurancesys.entity.LoginRegisterEntities;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/31
 */
public class Account {
    private String username;
    private String user_realname;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_realname() {
        return user_realname;
    }

    public void setUser_realname(String user_realname) {
        this.user_realname = user_realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
