package DAO;

import DTO.UserResponses;

import java.util.List;

public class UserResponsesDAO extends BasicDAO{

    public static UserResponses getUserResponse(int id){
        return (UserResponses) get(id, UserResponses.class);
    }
    public static List<UserResponses> getUserResponses(){
        return (List<UserResponses>) getAll("UserResponses");
    }

    public static boolean createUserResponse(UserResponses userresponse) {
        if(getUserResponse(userresponse.getId()) != null){
            return false;
        }
        else {
            return create(userresponse);
        }
    }
    public static boolean updateUserResponse(UserResponses userresponse) {
        if(getUserResponse(userresponse.getId()) == null){
            return false;
        }
        else {
            return update(userresponse);
        }
    }

    public static boolean deleteUserResponse(UserResponses userresponse){
        if(getUserResponse(userresponse.getId()) == null){
            return false;
        }
        else {
            return delete(userresponse);
        }
    }
}
