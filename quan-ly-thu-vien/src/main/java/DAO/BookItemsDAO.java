package DAO;

import DTO.BookItems;

import java.util.List;

public class BookItemsDAO extends BasicDAO{

    public static BookItems getBookItem(int id){
        return (BookItems) get(id, BookItems.class);
    }
    public static List<BookItems> getBookItems(){
        return (List<BookItems>) getAll("BookItems");
    }

    public static boolean createBookItem(BookItems bookitem) {
        if(getBookItem(bookitem.getId()) != null){
            return false;
        }
        else {
            return create(bookitem);
        }
    }
    public static boolean updateBookItem(BookItems bookitem) {
        if(getBookItem(bookitem.getId()) == null){
            return false;
        }
        else {
            return update(bookitem);
        }
    }

    public static boolean deleteBookItem(BookItems bookitem){
        if(getBookItem(bookitem.getId()) == null){
            return false;
        }
        else {
            return delete(bookitem);
        }
    }
}
