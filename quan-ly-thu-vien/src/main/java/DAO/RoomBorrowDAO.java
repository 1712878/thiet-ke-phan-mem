package DAO;

import DTO.RoomBorrow;

import java.util.List;

public class RoomBorrowDAO extends BasicDAO{

    public static RoomBorrow getRoomBorrow(int id){
        return (RoomBorrow) get(id, RoomBorrow.class);
    }
    public static List<RoomBorrow> getRoomBorrow(){
        return (List<RoomBorrow>) getAll("RoomBorrow");
    }

    public static boolean createRoomBorrow(RoomBorrow roomborrow) {
        if(getRoomBorrow(roomborrow.getId()) != null){
            return false;
        }
        else {
            return create(roomborrow);
        }
    }
    public static boolean updateRoomBorrow(RoomBorrow roomborrow) {
        if(getRoomBorrow(roomborrow.getId()) == null){
            return false;
        }
        else {
            return update(roomborrow);
        }
    }

    public static boolean deleteRoomBorrow(RoomBorrow roomborrow){
        if(getRoomBorrow(roomborrow.getId()) == null){
            return false;
        }
        else {
            return delete(roomborrow);
        }
    }
}
