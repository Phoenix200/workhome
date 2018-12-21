package test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName UserA
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/20 17:31
 * @Version 1.0
 **/
@ToString
public class UserA {
    private String userName;
    private String password;
    public UserA(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
