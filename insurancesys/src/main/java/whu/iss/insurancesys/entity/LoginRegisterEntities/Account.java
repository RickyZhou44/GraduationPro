package whu.iss.insurancesys.entity.LoginRegisterEntities;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/31
 */
public class Account {
    private String username;
    private String password;
    private String user_type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
