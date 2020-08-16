package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "BOOK_BORROW", schema = "QuanLyThuVien", catalog = "")
public class BookBorrow {
    private int id;
    private Timestamp borrowtime;
    private Timestamp duetime;
    private Integer bookitemid;
    private Integer accountid;
    private BookItems bookItemsByBookitemid;
    private Accounts accountsByAccountid;
    private Collection<Fines> finesById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BORROWTIME")
    public Timestamp getBorrowtime() {
        return borrowtime;
    }

    public void setBorrowtime(Timestamp borrowtime) {
        this.borrowtime = borrowtime;
    }

    @Basic
    @Column(name = "DUETIME")
    public Timestamp getDuetime() {
        return duetime;
    }

    public void setDuetime(Timestamp duetime) {
        this.duetime = duetime;
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
    @Column(name = "ACCOUNTID")
    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookBorrow that = (BookBorrow) o;
        return id == that.id &&
                Objects.equals(borrowtime, that.borrowtime) &&
                Objects.equals(duetime, that.duetime) &&
                Objects.equals(bookitemid, that.bookitemid) &&
                Objects.equals(accountid, that.accountid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, borrowtime, duetime, bookitemid, accountid);
    }

    @ManyToOne
    @JoinColumn(name = "BOOKITEMID", referencedColumnName = "ID",insertable = false, updatable = false)
    public BookItems getBookItemsByBookitemid() {
        return bookItemsByBookitemid;
    }

    public void setBookItemsByBookitemid(BookItems bookItemsByBookitemid) {
        this.bookItemsByBookitemid = bookItemsByBookitemid;
    }

    @ManyToOne
    @JoinColumn(name = "ACCOUNTID", referencedColumnName = "ID",insertable = false, updatable = false)
    public Accounts getAccountsByAccountid() {
        return accountsByAccountid;
    }

    public void setAccountsByAccountid(Accounts accountsByAccountid) {
        this.accountsByAccountid = accountsByAccountid;
    }

    @OneToMany(mappedBy = "bookBorrowByBookborrowid")
    public Collection<Fines> getFinesById() {
        return finesById;
    }

    public void setFinesById(Collection<Fines> finesById) {
        this.finesById = finesById;
    }
}
