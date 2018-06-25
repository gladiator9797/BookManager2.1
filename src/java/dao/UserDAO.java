/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionDB.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author gladi
 */
public class UserDAO {

    private Connection conn;// = null;
    private PreparedStatement stmt;
    private ResultSet rs;

    public UserDAO() {
        conn = ConnectionDB.getConnection();
    }

    /*
    //check valid username and password for login
    public boolean checkLogin(String username, String password) {
        int c = 0;
        String sql = "SELECT * FROM tblUser WHERE username = '" + username + "' AND password = '" + password + "' AND status=1";
        try {
            stmt = conn.prepareStatement(sql);
            //    stmt.setString(1, username);
            //    stmt.setString(2, password);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c++;
            }
            if (c == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    } */

    
    //check valid username and password for login
    public boolean checkLogin(String username, String password) {
        int c = 0;
        String sql = "SELECT * FROM tblUser WHERE username = ? AND password = ? AND status=1";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            //stmt.setInt(3, role);
            rs = stmt.executeQuery();
            while (rs.next()) {
                c++;
            }
            if (c == 1) {
                return true;
            }
            //if(role == 2) return "user";

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    } //   */
    public User getUserByUsername(String username) {
        User user = null;
        try {
            String sql = "SELECT * FROM tblUser WHERE username = '" + username + "'";
            stmt = conn.prepareStatement(sql);
            //  ps.setString(1, username);

            rs = stmt.executeQuery();
            if (rs != null) {
                user = new User();
                while (rs.next()) {
                    user.setUid(rs.getInt("uid"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setFullname(rs.getString("fullname"));
                    user.setEmail(rs.getString("email"));
                    user.setAvatar(rs.getString("avatar"));
                    user.setRole(rs.getInt("role"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    //show data from tblUser 
    public List<User> getListUser() {
        String sql = "SELECT * FROM tblUser";
        List<User> listUser = new ArrayList();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8));

                listUser.add(u);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUser;
    }

    public User getUserById(int uid) {
        String sql = "SELECT * FROM tblUser WHERE uid=?";
        User user = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, uid);
            rs = stmt.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8));
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    //update info Admin
    public boolean updateInfoUser(int uid, String fullname, String email) {
        boolean result = false;
        String sql = "UPDATE tblUser SET fullname=?, email=? WHERE uid=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, fullname);
            stmt.setString(2, email);
            stmt.setInt(3, uid);
            if (stmt.executeUpdate() > 0) {
                result = true;
                return result;
            }
            //result = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    //change password by ID
    public boolean changePassword(int uid, String newPassword) {
        boolean result = false;
        String sql = "UPDATE tblUser SET password=? WHERE uid=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, newPassword);
            stmt.setInt(2, uid);
            if (stmt.executeUpdate() > 0) {
                result = true;
                return result;
            }
            //result = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //add data to tblUser 
    public boolean insertDataUser(String username, String password,
            String fullname, String email, String avatar, boolean status) {
        int result = 0;
        String sql = "INSERT INTO tblUser(username, password, role, fullname, email, avatar, status)"
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setInt(3, 2); //2 is normal user
            stmt.setString(4, fullname);
            stmt.setString(5, email);
            stmt.setString(6, "image/avatar/" + avatar);
            stmt.setBoolean(7, true);
            result = stmt.executeUpdate();
            //stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (result > 0 ? true : false);
    }

    //deactive User (set status = 0)
    public boolean deactiveUser(int uid) {
        int result = 0;
        //String sql = "DELETE FROM tblUser WHERE uid=?";
        String sql = "UPDATE tblUser SET status=0 WHERE uid=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, uid);
            result = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0 ? true : false;
    }

    //active User (set status = 1)
    public boolean activeUser(int uid) {
        int result = 0;
        //String sql = "DELETE FROM tblUser WHERE uid=?";
        String sql = "UPDATE tblUser SET status=1 WHERE uid=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, uid);
            result = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0 ? true : false;
    }

    public List<User> getListUserSearch(String searchString) {
        List<User> listUser = null;
        String sql = "SELECT * FROM tblUser WHERE username LIKE ? OR fullname LIKE ? OR email LIKE ? ORDER BY uid ASC";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + searchString + "%");
            stmt.setString(2, "%" + searchString + "%");
            stmt.setString(3, "%" + searchString + "%");
            rs = stmt.executeQuery();
            if (rs != null) {
                listUser = new ArrayList<User>();
                User u = null;
                while (rs.next()) {
                    u = new User();
                    u.setUid(rs.getInt("uid"));
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                    u.setFullname(rs.getString("fullname"));
                    u.setEmail(rs.getString("email"));
                    u.setAvatar(rs.getString("avatar"));
                    u.setRole(rs.getInt("role"));
                    listUser.add(u);
                }
                rs.close();
            } else {
                listUser = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUser;
    }

    /*
    public int countUser() {
        int num = 0;
        String sql = "SELECT COUNT(username) AS numUsr FROM tblUser";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            num = rs.getInt("numUser");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
    */
}
