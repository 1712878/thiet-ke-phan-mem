package DAO;

import DTO.Publishers;

import java.util.List;

public class PublishersDAO extends BasicDAO{

    public static Publishers getPublisher(int id){
        return (Publishers) get(id, Publishers.class);
    }
    public static List<Publishers> getPublishers(){
        return (List<Publishers>) getAll("Publishers");
    }

    public static boolean createPublisher(Publishers publisher) {
        if(getPublisher(publisher.getId()) != null){
            return false;
        }
        else {
            return create(publisher);
        }
    }
    public static boolean updatePublisher(Publishers publisher) {
        if(getPublisher(publisher.getId()) == null){
            return false;
        }
        else {
            return update(publisher);
        }
    }

    public static boolean deletePublisher(Publishers publisher){
        if(getPublisher(publisher.getId()) == null){
            return false;
        }
        else {
            return delete(publisher);
        }
    }
}
