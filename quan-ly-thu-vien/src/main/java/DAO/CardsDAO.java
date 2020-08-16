package DAO;

import DTO.Cards;

import java.util.List;

public class CardsDAO extends BasicDAO{

    public static Cards getCard(int id){
        return (Cards) get(id, Cards.class);
    }
    public static List<Cards> getCards(){
        return (List<Cards>) getAll("Cards");
    }

    public static boolean createCard(Cards card) {
        if(getCard(card.getId()) != null){
            return false;
        }
        else {
            return create(card);
        }
    }
    public static boolean updateCard(Cards card) {
        if(getCard(card.getId()) == null){
            return false;
        }
        else {
            return update(card);
        }
    }

    public static boolean deleteCard(Cards card){
        if(getCard(card.getId()) == null){
            return false;
        }
        else {
            return delete(card);
        }
    }
}
