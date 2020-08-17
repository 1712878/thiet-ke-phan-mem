package DAO;

import DTO.ReadingRoom;

import java.util.List;

public class ReadingRoomDAO extends BasicDAO{

    public static ReadingRoom getReadingRoom(int id){
        return (ReadingRoom) get(id, ReadingRoom.class);
    }
    public static List<ReadingRoom> getReadingRoom(){
        return (List<ReadingRoom>) getAll("ReadingRoom");
    }

    public static boolean createReadingRoom(ReadingRoom readingroom) {
        if(getReadingRoom(readingroom.getId()) != null){
            return false;
        }
        else {
            return create(readingroom);
        }
    }
    public static boolean updateReadingRoom(ReadingRoom readingroom) {
        if(getReadingRoom(readingroom.getId()) == null){
            return false;
        }
        else {
            return update(readingroom);
        }
    }

    public static boolean deleteReadingRoom(ReadingRoom readingroom){
        if(getReadingRoom(readingroom.getId()) == null){
            return false;
        }
        else {
            return delete(readingroom);
        }
    }
}
