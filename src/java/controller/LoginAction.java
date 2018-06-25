/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionContext;
import dao.UserDAO;
import java.util.List;
import java.util.Map;
import model.User;

/**
 *
 * @author gladi
 */
public class LoginAction {

    private String username;
    private String password;
    boolean status;
    private User user = new User();
    UserDAO udao = new UserDAO();
    private Map<String, Object> session;

    public LoginAction() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDAO getUdao() {
        return udao;
    }

    public void setUdao(UserDAO udao) {
        this.udao = udao;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String login() {
        session = ActionContext.getContext().getSession();
        if (session.get("username") != null && (int) session.get("role") == 1) {
            return "successAdmin";
        } else if (session.get("username") != null && (int) session.get("role") == 2) {
            return "successUser";
        } else {
            if (udao.checkLogin(username, password)) {
                user = udao.getUserByUsername(username);
                session.put("username", username);
                session.put("avatar", user.getAvatar());
                session.put("role", user.getRole());
                session.put("fullname", user.getFullname());
                session.put("email", user.getEmail());
                session.put("uid", user.getUid());
                if ((int) session.get("role") == 1) {
                    return "successAdmin";
                } else if ((int) session.get("role") == 2) {
                    return "successUser";
                }
            }
        }
        return "fail";
    }

    public String logout() {
        session = ActionContext.getContext().getSession();
        session.clear();
        return "success";
    }
}
