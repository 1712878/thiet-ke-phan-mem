package DAO;

import DTO.BookReservations;

import java.util.List;

public class BookReservationsDAO extends BasicDAO{

    public static BookReservations getBookReservation(int id){
        return (BookReservations) get(id, BookReservations.class);
    }
    public static List<BookReservations> getBookReservations(){
        return (List<BookReservations>) getAll("BookReservations");
    }

    public static boolean createBookReservation(BookReservations bookreservation) {
        if(getBookReservation(bookreservation.getId()) != null){
            return false;
        }
        else {
            return create(bookreservation);
        }
    }
    public static boolean updateBookReservation(BookReservations bookreservation) {
        if(getBookReservation(bookreservation.getId()) == null){
            return false;
        }
        else {
            return update(bookreservation);
        }
    }

    public static boolean deleteBookReservation(BookReservations bookreservation){
        if(getBookReservation(bookreservation.getId()) == null){
            return false;
        }
        else {
            return delete(bookreservation);
        }
    }
}
