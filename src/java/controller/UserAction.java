/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionContext;
import dao.UserDAO;
import util.FileUpload;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import model.User;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author gladi
 */
public class UserAction {

    int uid;
    String username;
    String password;
    String newPassword;
    String newPasswordRetype;
    String searchString;

    int role;
    String fullname;
    String email;
    String avatar;
    boolean status;
    Map session;
    User user;
    List<User> listUser;

    //test 
    File myFile;
    String myFileContentType;
    String myFileFileName;
    String destPath;

    UserDAO udao = new UserDAO();

    public UserAction() {
    }

    public UserAction(int uid, String username, String password, int role, String fullname, String email, String avatar, boolean status, User user) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.role = role;
        this.fullname = fullname;
        this.email = email;
        this.avatar = avatar;
        this.status = status;
        this.user = user;
    }

    public UserDAO getUdao() {
        return udao;
    }

    public void setUdao(UserDAO udao) {
        this.udao = udao;
    }

    public File getMyFile() {
        return myFile;
    }

    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }

    public String getMyFileContentType() {
        return myFileContentType;
    }

    public void setMyFileContentType(String myFileContentType) {
        this.myFileContentType = myFileContentType;
    }

    public String getMyFileFileName() {
        return myFileFileName;
    }

    public void setMyFileFileName(String myFileFileName) {
        this.myFileFileName = myFileFileName;
    }

    public String getDestPath() {
        return destPath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordRetype() {
        return newPasswordRetype;
    }

    public void setNewPasswordRetype(String newPasswordRetype) {
        this.newPasswordRetype = newPasswordRetype;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getListUser() {
        return listUser;
    }

    public void setListUser(List<User> listUser) {
        this.listUser = listUser;
    }

    //add new User to tblUser
    public String addUser() throws IOException {
        //fileUpload.FileUpload f = new FileUpload();
        try {
            destPath = ServletActionContext.getServletContext().getRealPath("/");
            
            int a = destPath.indexOf("\\build\\web");
            destPath = destPath.substring(0, a);
            destPath = destPath.concat("\\web\\image\\avatar");
            
            File destFile = new File(destPath, myFileFileName);
            FileUtils.copyFile(myFile, destFile);

            //user.setAvatar(fileName);
            udao.insertDataUser(username, password, fullname, email, myFileFileName, true);
            listUser = udao.getListUser();
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    //delete user (set status = 0)
    public String deactiveUser() {
        if (udao.deactiveUser(uid)) {
            listUser = udao.getListUser();
            return "success";
        }
        return "fail";
    }

    //active user (set status = 1)
    public String activeUser() {
        if (udao.activeUser(uid)) {
            listUser = udao.getListUser();
            return "success";
        }
        return "fail";
    }

    //show list user
    public String showListUser() throws Exception {
        if (udao.getListUser() != null) {
            listUser = udao.getListUser();
            return "success";
        }
        return "fail";
    }

    //get info user data=>user
    public String getUserInfo() {
        if (udao.getUserById(uid) != null) {
            user = udao.getUserById(uid);
            return "success";
        }
        return "fail";
    }

    //do update user info
    public String doUpdateUserInfo() {
        if (udao.updateInfoUser(uid, fullname, email)) {
            user = udao.getUserById(uid);
            return "success";
        }
        return "fail";
    }

    public String showInfoUserSession() {
        session = ActionContext.getContext().getSession();
        user = udao.getUserById((int) session.get("uid"));
        return "success";
    }

    //change password for admin
    public String ChangePassword() {
        session = ActionContext.getContext().getSession();
        String result = "fail";
        String x = newPassword;
        if (udao.checkLogin((String) session.get("username"), password) && x.equals(newPasswordRetype)) {
            if (udao.changePassword((int) session.get("uid"), newPassword)) {
                result = "success";
            } else {
                return result;
            }
        }
        return result;
    }

    public String searchUser() {
        if (udao.getListUserSearch(searchString) != null) {
            listUser = udao.getListUserSearch(searchString);
            return "success";
        } else {
            return "fail";
        }
    }

}
