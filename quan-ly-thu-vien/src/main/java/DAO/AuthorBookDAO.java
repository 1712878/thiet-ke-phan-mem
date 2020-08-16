package DAO;

import DTO.AuthorBook;

import java.util.List;

public class AuthorBookDAO extends BasicDAO{

    public static AuthorBook getAuthorBook(int id){
        return (AuthorBook) get(id, AuthorBook.class);
    }
    public static List<AuthorBook> getAuthorBook(){
        return (List<AuthorBook>) getAll("AuthorBook");
    }

    public static boolean createAuthorBook(AuthorBook authorbook) {
        if(getAuthorBook(authorbook.getId()) != null){
            return false;
        }
        else {
            return create(authorbook);
        }
    }
    public static boolean updateAuthorBook(AuthorBook authorbook) {
        if(getAuthorBook(authorbook.getId()) == null){
            return false;
        }
        else {
            return update(authorbook);
        }
    }

    public static boolean deleteAuthorBook(AuthorBook authorbook){
        if(getAuthorBook(authorbook.getId()) == null){
            return false;
        }
        else {
            return delete(authorbook);
        }
    }
}
