package DTO;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "READING_ROOM", schema = "QuanLyThuVien", catalog = "")
public class ReadingRoom implements DTO{
    private int id;
    private String roomname;
    private Collection<RoomBorrow> roomBorrowsById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROOMNAME")
    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReadingRoom that = (ReadingRoom) o;
        return id == that.id &&
                Objects.equals(roomname, that.roomname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomname);
    }

    @OneToMany(mappedBy = "readingRoomByRoomid")
    public Collection<RoomBorrow> getRoomBorrowsById() {
        return roomBorrowsById;
    }

    public void setRoomBorrowsById(Collection<RoomBorrow> roomBorrowsById) {
        this.roomBorrowsById = roomBorrowsById;
    }
}
