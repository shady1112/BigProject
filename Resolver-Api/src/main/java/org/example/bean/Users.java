package org.example.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Users
 * @author 
 */
@Data
public class Users implements Serializable {

    private Integer id;

    private String account;

    private String password;

    private Date last_login;

    private Date reg_time;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private static final long serialVersionUID = 1L;


    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public Date getReg_time() {
        return reg_time;
    }

    public void setReg_time(Date reg_time) {
        this.reg_time = reg_time;
    }

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