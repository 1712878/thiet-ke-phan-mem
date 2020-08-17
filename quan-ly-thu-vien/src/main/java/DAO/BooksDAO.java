package DAO;

import DTO.Books;

import java.util.List;

public class BooksDAO extends BasicDAO{

    public static Books getBook(int id){
        return (Books) get(id, Books.class);
    }
    public static List<Books> getBooks(){
        return (List<Books>) getAll("Books");
    }

    public static boolean createBook(Books book) {
        if(getBook(book.getId()) != null){
            return false;
        }
        else {
            return create(book);
        }
    }
    public static boolean updateBook(Books book) {
        if(getBook(book.getId()) == null){
            return false;
        }
        else {
            return update(book);
        }
    }

    public static boolean deleteBook(Books book){
        if(getBook(book.getId()) == null){
            return false;
        }
        else {
            return delete(book);
        }
    }
}
