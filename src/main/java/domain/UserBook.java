package domain;

import java.sql.Date;

public class UserBook {

    private Long id;
    private Date createDate;
    private Book.Status status;
    private Long bookFk;
    private Long userFk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Book.Status getStatus() {
        return status;
    }

    public void setStatus(Book.Status status) {
        this.status = status;
    }

    public Long getBookFk() {
        return bookFk;
    }

    public void setBookFk(Long bookFk) {
        this.bookFk = bookFk;
    }

    public Long getUserFk() {
        return userFk;
    }

    public void setUserFk(Long userFk) {
        this.userFk = userFk;
    }

    public UserBook(Long id, Date createDate, Book.Status status, Long bookFk, Long userFk) {
        this.id = id;
        this.createDate = createDate;
        this.status = status;
        this.bookFk = bookFk;
        this.userFk = userFk;
    }

    public UserBook(Date createDate, Book.Status status, Long bookFk, Long userFk) {
        this.createDate = createDate;
        this.status = status;
        this.bookFk = bookFk;
        this.userFk = userFk;
    }

    public UserBook() {
    }

    @Override
    public String toString() {
        return "UserBook{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", status=" + status +
                ", bookFk=" + bookFk +
                ", userFk=" + userFk +
                '}';
    }
}
