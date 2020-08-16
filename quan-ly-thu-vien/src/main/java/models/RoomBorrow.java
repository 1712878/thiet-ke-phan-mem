package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ROOM_BORROW", schema = "QuanLyThuVien", catalog = "")
public class RoomBorrow {
    private int id;
    private Integer roomid;
    private Integer accountid;
    private Timestamp borrowtime;
    private Timestamp duetime;
    private ReadingRoom readingRoomByRoomid;
    private Accounts accountsByAccountid;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROOMID")
    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    @Basic
    @Column(name = "ACCOUNTID")
    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomBorrow that = (RoomBorrow) o;
        return id == that.id &&
                Objects.equals(roomid, that.roomid) &&
                Objects.equals(accountid, that.accountid) &&
                Objects.equals(borrowtime, that.borrowtime) &&
                Objects.equals(duetime, that.duetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomid, accountid, borrowtime, duetime);
    }

    @ManyToOne
    @JoinColumn(name = "ROOMID", referencedColumnName = "ID", insertable = false, updatable = false)
    public ReadingRoom getReadingRoomByRoomid() {
        return readingRoomByRoomid;
    }

    public void setReadingRoomByRoomid(ReadingRoom readingRoomByRoomid) {
        this.readingRoomByRoomid = readingRoomByRoomid;
    }

    @ManyToOne
    @JoinColumn(name = "ACCOUNTID", referencedColumnName = "ID", insertable = false, updatable = false)
    public Accounts getAccountsByAccountid() {
        return accountsByAccountid;
    }

    public void setAccountsByAccountid(Accounts accountsByAccountid) {
        this.accountsByAccountid = accountsByAccountid;
    }
}
