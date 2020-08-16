package DAO;

import DTO.Fines;

import java.util.List;

public class FinesDAO extends BasicDAO{

    public static Fines getFine(int id){
        return (Fines) get(id, Fines.class);
    }
    public static List<Fines> getFines(){
        return (List<Fines>) getAll("Fines");
    }

    public static boolean createFine(Fines fine) {
        if(getFine(fine.getId()) != null){
            return false;
        }
        else {
            return create(fine);
        }
    }
    public static boolean updateFine(Fines fine) {
        if(getFine(fine.getId()) == null){
            return false;
        }
        else {
            return update(fine);
        }
    }

    public static boolean deleteFine(Fines fine){
        if(getFine(fine.getId()) == null){
            return false;
        }
        else {
            return delete(fine);
        }
    }
}
