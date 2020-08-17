package DAO;

import DTO.Constants;

import java.util.List;

public class ConstantsDAO extends BasicDAO{

    public static Constants getConstant(int id){
        return (Constants) get(id, Constants.class);
    }
    public static List<Constants> getConstants(){
        return (List<Constants>) getAll("Constants");
    }

    public static boolean createConstant(Constants constant) {
        if(getConstant(constant.getId()) != null){
            return false;
        }
        else {
            return create(constant);
        }
    }
    public static boolean updateConstant(Constants constant) {
        if(getConstant(constant.getId()) == null){
            return false;
        }
        else {
            return update(constant);
        }
    }

    public static boolean deleteConstant(Constants constant){
        if(getConstant(constant.getId()) == null){
            return false;
        }
        else {
            return delete(constant);
        }
    }
}
