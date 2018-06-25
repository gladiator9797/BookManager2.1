/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionContext;
import dao.BookDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import model.Book;
import model.Comment;
import model.User;

/**
 *
 * @author gladi
 */
public class BookAction {

    private int bid;
    private String title;
    private String author;
    private float price;
    private String description;
    private String image;
    private boolean status;
    private String searchString;
    private List<Book> listBook;
    private List<Comment> listComment;

    private int cid;
    private int uid;
    private String comment;
    private Book book;
    private User user;
    private Comment cmt;
    private Map<String, Object> session;

    BookDAO bdao = new BookDAO();

    public BookAction(int bid, String title, String author, float price, String description, String image, boolean status, List<Book> listBook, Book b) {
        this.bid = bid;
        this.title = title;
        this.author = author;
        this.price = price;
        this.description = description;
        this.image = image;
        this.status = status;
        this.listBook = listBook;
        this.book = book;
    }

    //comment action class
    public BookAction(int bid, int cid, int uid, String comment, Book book, User user, Comment cmt) {
        this.bid = bid;
        this.cid = cid;
        this.uid = uid;
        this.comment = comment;
        this.book = book;
        this.user = user;
        this.cmt = cmt;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public BookAction() {
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Book> getListBook() {
        return listBook;
    }

    public void setListBook(List<Book> listBook) {
        this.listBook = listBook;
    }

    public List<Comment> getListComment() {
        return listComment;
    }

    public void setListComment(List<Comment> listComment) {
        this.listComment = listComment;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public Comment getCmt() {
        return cmt;
    }

    public void setCmt(Comment cmt) {
        this.cmt = cmt;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    //show list book status = true
    public String showListBook() {
        if (bdao.getListBook() != null) {
            listBook = bdao.getListBook();
            return "success";
        }
        return "fail";
    }

    //show all list book include status book = false
    public String showAllListBook() {
        if (bdao.getAllListBook() != null) {
            listBook = bdao.getAllListBook();
            return "success";
        }
        return "fail";
    }

    //detail info book: data=>b (book)
    public String bookDetail() {
        session = ActionContext.getContext().getSession();
        session.put("bid", bid);
        book = bdao.getByIdBook((int) session.get("bid"));
        listComment = bdao.getCommentByBookId((int) session.get("bid"));
        //  book = bdao.getByIdBook(bid);
        //  listComment = bdao.getCommentByBookId(bid);
        return "success";
    }

    //do update book informaition
    public String doUpdateBookInfo() {
        if (bdao.updateDataBook(title, author, price, description, image, status, bid)) {
            return "success";
        }
        return "fail";
    }

    //add new Book
    public String addBook() {
        if (bdao.insertDataBook(title, author, price, description, image, status)) {
            listBook = bdao.getListBook();
            return "success";
        }
        return "fail";
    }

    public String deactiveBook() throws Exception {
        if (bdao.deactiveBook(bid)) {
            return "success";
        }
        return "fail";
    }

    public String activeBook() throws Exception {
        if (bdao.activeBook(bid)) {
            return "success";
        }
        return "fail";
    }

    public String addComment() {
        String result = "fail";
        session = ActionContext.getContext().getSession();
        if (session.containsKey("username")) {
            try {
                cmt = new Comment();
                //b = dpb.getByIdBook((int)session.get("bid"));
                //int x = b.getBid();
                
                cmt.setBid((int) session.get("bid"));
                cmt.setComment(comment);
                cmt.setUid((int) session.get("uid"));
                String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
                cmt.setCreatedDate(timeStamp);

                if (bdao.insertComment(cmt)) {
                    listComment = new ArrayList<Comment>();
                    listComment = bdao.getCommentByBookId(cmt.getBid());
                    book = bdao.getByIdBook(cmt.getBid());
                    result = "success";
                } else {
                    result = "fail";
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e);
            }
        } else {
            result = "fail";
        }

        return result;
    }

    public String showListCommentAsc() {
        String result = "fail";
        if (bdao.getCommentByBookId(bid) != null) {
            listComment = bdao.getCommentByBookId(bid);
            result = "success";
        }
        return result;
    }
    //end comment action class

    //search book by user and admin
    public String searchBook() {
        if (bdao.getListUserSearch(searchString) != null) {
            listBook = bdao.getListUserSearch(searchString);
            return "success";
        } else {
            return "fail";
        }
    }

}
