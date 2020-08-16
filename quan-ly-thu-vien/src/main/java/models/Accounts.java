package models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Accounts {
    private int id;
    private Integer userid;
    private String username;
    private String password;
    private Integer status;
    private Readers readersByUserid;
    private Collection<BookBorrow> bookBorrowsById;
    private Collection<BookReservations> bookReservationsById;
    private Collection<RoomBorrow> roomBorrowsById;
    private Collection<UserResponses> userResponsesById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "STATUS")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return id == accounts.id &&
                Objects.equals(userid, accounts.userid) &&
                Objects.equals(username, accounts.username) &&
                Objects.equals(password, accounts.password) &&
                Objects.equals(status, accounts.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, username, password, status);
    }

    @ManyToOne
    @JoinColumn(name = "USERID", referencedColumnName = "PERSONID", insertable = false, updatable = false)
    public Readers getReadersByUserid() {
        return readersByUserid;
    }

    public void setReadersByUserid(Readers readersByUserid) {
        this.readersByUserid = readersByUserid;
    }

    @OneToMany(mappedBy = "accountsByAccountid")
    public Collection<BookBorrow> getBookBorrowsById() {
        return bookBorrowsById;
    }

    public void setBookBorrowsById(Collection<BookBorrow> bookBorrowsById) {
        this.bookBorrowsById = bookBorrowsById;
    }

    @OneToMany(mappedBy = "accountsByUserid")
    public Collection<BookReservations> getBookReservationsById() {
        return bookReservationsById;
    }

    public void setBookReservationsById(Collection<BookReservations> bookReservationsById) {
        this.bookReservationsById = bookReservationsById;
    }

    @OneToMany(mappedBy = "accountsByAccountid")
    public Collection<RoomBorrow> getRoomBorrowsById() {
        return roomBorrowsById;
    }

    public void setRoomBorrowsById(Collection<RoomBorrow> roomBorrowsById) {
        this.roomBorrowsById = roomBorrowsById;
    }

    @OneToMany(mappedBy = "accountsByAccountid")
    public Collection<UserResponses> getUserResponsesById() {
        return userResponsesById;
    }

    public void setUserResponsesById(Collection<UserResponses> userResponsesById) {
        this.userResponsesById = userResponsesById;
    }
}
