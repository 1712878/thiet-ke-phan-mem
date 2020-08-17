package DAO;

import DTO.Accounts;

import java.util.List;

public class AccountsDAO extends BasicDAO{

    public static Accounts getAccount(int id){
        return (Accounts) get(id, Accounts.class);
    }
    public static List<Accounts> getAccounts(){
        return (List<Accounts>) getAll("Accounts");
    }

    public static boolean createAccount(Accounts account) {
        if(getAccount(account.getId()) != null){
            return false;
        }
        else {
            return create(account);
        }
    }
    public static boolean updateAccount(Accounts account) {
        if(getAccount(account.getId()) == null){
            return false;
        }
        else {
            return update(account);
        }
    }

    public static boolean deleteAccount(Accounts account){
        if(getAccount(account.getId()) == null){
            return false;
        }
        else {
            return delete(account);
        }
    }
}

