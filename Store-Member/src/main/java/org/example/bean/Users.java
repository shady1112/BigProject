package org.example.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * Users
 * @author 
 */
@Data
public class Users implements Serializable {

    private Integer id;

    private String account;

    private String password;

    private static final long serialVersionUID = 1L;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}