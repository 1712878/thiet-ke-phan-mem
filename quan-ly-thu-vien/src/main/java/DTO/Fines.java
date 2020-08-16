package DTO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Fines {
    private int id;
    private Timestamp createdat;
    private Integer bookborrowid;
    private Double amount;
    private BookBorrow bookBorrowByBookborrowid;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CREATEDAT")
    public Timestamp getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Timestamp createdat) {
        this.createdat = createdat;
    }

    @Basic
    @Column(name = "BOOKBORROWID", nullable=false)
    public Integer getBookborrowid() {
        return bookborrowid;
    }

    public void setBookborrowid(Integer bookborrowid) {
        this.bookborrowid = bookborrowid;
    }

    @Basic
    @Column(name = "AMOUNT")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fines fines = (Fines) o;
        return id == fines.id &&
                Objects.equals(createdat, fines.createdat) &&
                Objects.equals(bookborrowid, fines.bookborrowid) &&
                Objects.equals(amount, fines.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdat, bookborrowid, amount);
    }

    @ManyToOne
    @JoinColumn(name = "BOOKBORROWID", referencedColumnName = "ID", insertable = false, updatable = false)
    public BookBorrow getBookBorrowByBookborrowid() {
        return bookBorrowByBookborrowid;
    }

    public void setBookBorrowByBookborrowid(BookBorrow bookBorrowByBookborrowid) {
        this.bookBorrowByBookborrowid = bookBorrowByBookborrowid;
    }
}
