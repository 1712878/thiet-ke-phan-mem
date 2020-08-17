package DAO;

import DTO.BookBorrow;

import java.util.List;

public class BookBorrowDAO extends BasicDAO{

    public static BookBorrow getBookBorrow(int id){
        return (BookBorrow) get(id, BookBorrow.class);
    }
    public static List<BookBorrow> getBookBorrow(){
        return (List<BookBorrow>) getAll("BookBorrow");
    }

    public static boolean createBookBorrow(BookBorrow bookborrow) {
        if(getBookBorrow(bookborrow.getId()) != null){
            return false;
        }
        else {
            return create(bookborrow);
        }
    }
    public static boolean updateBookBorrow(BookBorrow bookborrow) {
        if(getBookBorrow(bookborrow.getId()) == null){
            return false;
        }
        else {
            return update(bookborrow);
        }
    }

    public static boolean deleteBookBorrow(BookBorrow bookborrow){
        if(getBookBorrow(bookborrow.getId()) == null){
            return false;
        }
        else {
            return delete(bookborrow);
        }
    }
}
