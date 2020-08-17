package DAO;

import DTO.Authors;

import java.util.List;

public class AuthorsDAO extends BasicDAO{

    public static Authors getAuthor(int id){
        return (Authors) get(id, Authors.class);
    }
    public static List<Authors> getAuthors(){
        return (List<Authors>) getAll("Authors");
    }

    public static boolean createAuthor(Authors author) {
        if(getAuthor(author.getId()) != null){
            return false;
        }
        else {
            return create(author);
        }
    }
    public static boolean updateAuthor(Authors author) {
        if(getAuthor(author.getId()) == null){
            return false;
        }
        else {
            return update(author);
        }
    }

    public static boolean deleteAuthor(Authors author){
        if(getAuthor(author.getId()) == null){
            return false;
        }
        else {
            return delete(author);
        }
    }
}
