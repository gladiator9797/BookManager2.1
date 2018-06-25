package controller;

import com.opensymphony.xwork2.ActionContext;
import dao.BookDAO;
import dao.UserDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import model.Book;
import model.Comment;
import model.User;


public class CommentAction {

    private int bid;
    private int cid;
    private int uid;
    private String comment;
    private Book book;
    private User user;
    private Comment cmt;
    private List<Comment> listComment;
    private Map<String, Object> session;
    
    BookDAO bdao = new BookDAO();
    UserDAO udao = new UserDAO();
    
    public CommentAction() {
    }

    public CommentAction(int bid, int cid, int uid, String comment, Book book, User user, Comment cmt) {
        this.bid = bid;
        this.cid = cid;
        this.uid = uid;
        this.comment = comment;
        this.book = book;
        this.user = user;
        this.cmt = cmt;
    }


    public List<Comment> getListComment() {
        return listComment;
    }

    public void setListComment(List<Comment> listComment) {
        this.listComment = listComment;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
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

    public Comment getCmt() {
        return cmt;
    }

    public void setCmt(Comment cmt) {
        this.cmt = cmt;
    }



    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    
    
    //bugs
    public String addComment() {
        String result = "fail";
        session = ActionContext.getContext().getSession();
        if (session.containsKey("username")) {
            try {
                cmt = new Comment();
                book = bdao.getByIdBook(bid);
                cmt.setBid(book.getBid());
                cmt.setComment("comment");
//                c.setContent(content);
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
            }
        } else {
            result = "fail";
        }

        return result;
    }
    
    
    
//    public String adddComment() {
//        DataProcessComment dpc = new DataProcessComment();
//        if (dpc.insertDataComment(2, 2, 2, comment, true)){
//            listComment = dpc.getListComment();
//            return "success";
//        }
//        return "fail";
//    }

}
