package DTO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "BOOK_RESERVATIONS", schema = "QuanLyThuVien", catalog = "")
public class BookReservations {
    private int id;
    private Integer bookitemid;
    private Integer userid;
    private Timestamp time;
    private BookItems bookItemsByBookitemid;
    private Accounts accountsByUserid;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BOOKITEMID")
    public Integer getBookitemid() {
        return bookitemid;
    }

    public void setBookitemid(Integer bookitemid) {
        this.bookitemid = bookitemid;
    }

    @Basic
    @Column(name = "USERID")
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "TIME")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookReservations that = (BookReservations) o;
        return id == that.id &&
                Objects.equals(bookitemid, that.bookitemid) &&
                Objects.equals(userid, that.userid) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookitemid, userid, time);
    }

    @ManyToOne
    @JoinColumn(name = "BOOKITEMID", referencedColumnName = "ID", insertable = false, updatable = false)
    public BookItems getBookItemsByBookitemid() {
        return bookItemsByBookitemid;
    }

    public void setBookItemsByBookitemid(BookItems bookItemsByBookitemid) {
        this.bookItemsByBookitemid = bookItemsByBookitemid;
    }

    @ManyToOne
    @JoinColumn(name = "USERID", referencedColumnName = "ID",insertable = false, updatable = false)
    public Accounts getAccountsByUserid() {
        return accountsByUserid;
    }

    public void setAccountsByUserid(Accounts accountsByUserid) {
        this.accountsByUserid = accountsByUserid;
    }
}
