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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;
import model.Comment;

/**
 *
 * @author gladi
 */
public class BookDAO {

    private Connection conn;// = null;
    private PreparedStatement stmt;
    private ResultSet rs;

    public BookDAO() {
        conn = ConnectionDB.getConnection();
    }

    //search by id from tblBook
    public Book getByIdBook(int bid) {
        Book book = null;
        String sql = "SELECT * FROM tblBook WHERE bid=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, bid);
            rs = stmt.executeQuery();
            while (rs.next()) {
                book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getFloat(4), rs.getString(5), rs.getString(6), rs.getBoolean(7));
                stmt.executeUpdate();
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    //show data from tblBook 
    public List<Book> getListBook() {
        String sql = "SELECT * FROM tblBook WHERE status=1";
        List<Book> listBook = new ArrayList();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Book book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getFloat(4), rs.getString(5), rs.getString(6), rs.getBoolean(7));
                listBook.add(book);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listBook;
    }

    //get all list Book include book has status = false
    public List<Book> getAllListBook() {
        String sql = "SELECT * FROM tblBook";
        List<Book> listBook = new ArrayList();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Book book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getFloat(4), rs.getString(5), rs.getString(6), rs.getBoolean(7));
                listBook.add(book);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listBook;
    }

    //update data to tblBook
    public boolean updateDataBook(String title, String author, float price,
            String description, String image, boolean status, int bid) {
        int result = 0;
        String sql = "UPDATE tblBook SET title=?, author=?, price=?, description=?,"
                + "image=?, status=? WHERE bid=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setFloat(3, price);
            stmt.setString(4, description);
            stmt.setString(5, image);
            stmt.setBoolean(6, status);
            stmt.setInt(7, bid);
            result = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result > 0 ? true : false;
    }

    public boolean insertDataBook(String title, String author, float price,
        String description, String image, boolean status) {
        int result = 0;
        String sql = "INSERT INTO tblBook(title, author, price, description, image, status)"
                + "VALUES(?,?,?,?,?,?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setFloat(3, price);
            stmt.setString(4, description);
            stmt.setString(5, image);
            stmt.setBoolean(6, true);
            result = stmt.executeUpdate();
            //stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return (result > 0 ? true : false);
    }

    //deactive book set status = 0
    public boolean deactiveBook(int bid) {
        int result = 0;
        String sql = "UPDATE tblBook SET status=0 WHERE bid=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, bid);
            result = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result > 0 ? true : false;
    }

    //active book set status = 1
    public boolean activeBook(int bid) {
        int result = 0;
        String sql = "UPDATE tblBook SET status=1 WHERE bid=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, bid);
            result = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result > 0 ? true : false;
    }

    //insert comment
    public boolean insertComment(Comment cmt) {
        boolean result = false;
        try {
            String sql = "INSERT INTO tblComment (bid, uid, comment, date, status)"
                    + "VALUES(?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cmt.getBid());
            stmt.setInt(2, cmt.getUid());
            stmt.setString(3, cmt.getComment());
            stmt.setString(4, cmt.getCreatedDate());
            stmt.setBoolean(5, true);

            if (stmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Comment> getCommentByBookId(int bid) {
        List<Comment> listComment = new ArrayList<Comment>();
        try {
            String sql = "SELECT c.*,u.fullname,b.title,u.avatar FROM "
                    + "tblComment c INNER JOIN tblBook b ON c.bid = b.bid "
                    + "INNER JOIN tblUser u ON c.uid = u.uid WHERE b.bid = ? ORDER BY date";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, bid);

            rs = stmt.executeQuery();
            if (rs != null) {
                //listComment = new ArrayList<Comment>();
                Comment c = null;
                while (rs.next()) {
                    c = new Comment();
                    c.setCid(rs.getInt("cid"));
                    c.setBid(rs.getInt("bid"));
                    c.setTitle(rs.getString("title"));
                    c.setUid(rs.getInt("uid"));
                    c.setUsername(rs.getString("fullname"));
                    c.setComment(rs.getString("comment"));
                    c.setAvatar(rs.getString("avatar"));
                    c.setCreatedDate(rs.getString("date"));
                    c.setStatus(rs.getBoolean("status"));

                    listComment.add(c);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listComment;
    }

    public List<Book> getListUserSearch(String searchString) {
        List<Book> listBook = null;
        String sql = "SELECT * FROM tblBook WHERE title LIKE ? OR author LIKE ? OR description LIKE ? ORDER BY bid ASC";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + searchString + "%");
            stmt.setString(2, "%" + searchString + "%");
            stmt.setString(3, "%" + searchString + "%");
            rs = stmt.executeQuery();
            if (rs != null) {
                listBook = new ArrayList<Book>();
                Book b = null;
                while (rs.next()) {
                    b = new Book();
                    b.setBid(rs.getInt("bid"));
                    b.setTitle(rs.getString("title"));
                    b.setAuthor(rs.getString("author"));
                    b.setDescription(rs.getString("description"));
                    b.setPrice(rs.getFloat("price"));
                    b.setImage(rs.getString("image"));
                    //b.isStatus(rs.getBoolean("status"));
                    listBook.add(b);
                }
                rs.close();
            } else {
                listBook = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listBook;
    }

}
