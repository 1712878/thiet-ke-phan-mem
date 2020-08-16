package DAO;

import DTO.Categories;

import java.util.List;

public class CategoriesDAO extends BasicDAO{

    public static Categories getCategorie(int id){
        return (Categories) get(id, Categories.class);
    }
    public static List<Categories> getCategories(){
        return (List<Categories>) getAll("Categories");
    }

    public static boolean createCategorie(Categories categorie) {
        if(getCategorie(categorie.getId()) != null){
            return false;
        }
        else {
            return create(categorie);
        }
    }
    public static boolean updateCategorie(Categories categorie) {
        if(getCategorie(categorie.getId()) == null){
            return false;
        }
        else {
            return update(categorie);
        }
    }

    public static boolean deleteCategorie(Categories categorie){
        if(getCategorie(categorie.getId()) == null){
            return false;
        }
        else {
            return delete(categorie);
        }
    }
}
