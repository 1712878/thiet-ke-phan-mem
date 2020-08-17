package DAO;

import DTO.ReaderTypes;

import java.util.List;

public class ReaderTypesDAO extends BasicDAO{

    public static ReaderTypes getReaderType(int id){
        return (ReaderTypes) get(id, ReaderTypes.class);
    }
    public static List<ReaderTypes> getReaderTypes(){
        return (List<ReaderTypes>) getAll("ReaderTypes");
    }

    public static boolean createReaderType(ReaderTypes readertype) {
        if(getReaderType(readertype.getId()) != null){
            return false;
        }
        else {
            return create(readertype);
        }
    }
    public static boolean updateReaderType(ReaderTypes readertype) {
        if(getReaderType(readertype.getId()) == null){
            return false;
        }
        else {
            return update(readertype);
        }
    }

    public static boolean deleteReaderType(ReaderTypes readertype){
        if(getReaderType(readertype.getId()) == null){
            return false;
        }
        else {
            return delete(readertype);
        }
    }
}
