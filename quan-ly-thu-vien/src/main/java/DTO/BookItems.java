package DTO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "BOOK_ITEMS", schema = "QuanLyThuVien", catalog = "")
public class BookItems implements DTO{
    private int id;
    private String barcode;
    private Integer status;
    private Byte canborrow;
    private Integer bookid;
    private String shelf;
    private Timestamp publishdate;
    private Collection<BookBorrow> bookBorrowsById;
    private Books booksByBookid;
    private Collection<BookReservations> bookReservationsById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BARCODE")
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Basic
    @Column(name = "STATUS")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "CANBORROW")
    public Byte getCanborrow() {
        return canborrow;
    }

    public void setCanborrow(Byte canborrow) {
        this.canborrow = canborrow;
    }

    @Basic
    @Column(name = "BOOKID")
    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    @Basic
    @Column(name = "SHELF")
    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    @Basic
    @Column(name = "PUBLISHDATE")
    public Timestamp getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Timestamp publishdate) {
        this.publishdate = publishdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookItems bookItems = (BookItems) o;
        return id == bookItems.id &&
                Objects.equals(barcode, bookItems.barcode) &&
                Objects.equals(status, bookItems.status) &&
                Objects.equals(canborrow, bookItems.canborrow) &&
                Objects.equals(bookid, bookItems.bookid) &&
                Objects.equals(shelf, bookItems.shelf) &&
                Objects.equals(publishdate, bookItems.publishdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, barcode, status, canborrow, bookid, shelf, publishdate);
    }

    @OneToMany(mappedBy = "bookItemsByBookitemid")
    public Collection<BookBorrow> getBookBorrowsById() {
        return bookBorrowsById;
    }

    public void setBookBorrowsById(Collection<BookBorrow> bookBorrowsById) {
        this.bookBorrowsById = bookBorrowsById;
    }

    @ManyToOne
    @JoinColumn(name = "BOOKID", referencedColumnName = "ID", insertable = false, updatable = false)
    public Books getBooksByBookid() {
        return booksByBookid;
    }

    public void setBooksByBookid(Books booksByBookid) {
        this.booksByBookid = booksByBookid;
    }

    @OneToMany(mappedBy = "bookItemsByBookitemid")
    public Collection<BookReservations> getBookReservationsById() {
        return bookReservationsById;
    }

    public void setBookReservationsById(Collection<BookReservations> bookReservationsById) {
        this.bookReservationsById = bookReservationsById;
    }
}
