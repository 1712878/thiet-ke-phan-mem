package DAO;

import DTO.Readers;

import java.util.List;

public class ReadersDAO extends BasicDAO{

    public static Readers getReader(int id){
        return (Readers) get(id, Readers.class);
    }
    public static List<Readers> getReaders(){
        return (List<Readers>) getAll("READERS");
    }

    public static boolean createReader(Readers reader) {
        if(getReader(reader.getPersonid()) != null){
            return false;
        }
        else {
            return create(reader);
        }
    }
    public static boolean updateReader(Readers reader) {
        if(getReader(reader.getPersonid()) == null){
            return false;
        }
        else {
            return update(reader);
        }
    }

    public static boolean deleteReader(Readers reader){
        if(getReader(reader.getPersonid()) == null){
            return false;
        }
        else {
            return delete(reader);
        }
    }
}
