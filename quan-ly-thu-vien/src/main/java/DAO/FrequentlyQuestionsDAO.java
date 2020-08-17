package DAO;

import DTO.FrequentlyQuestions;

import java.util.List;

public class FrequentlyQuestionsDAO extends BasicDAO{

    public static FrequentlyQuestions getFrequentlyQuestion(int id){
        return (FrequentlyQuestions) get(id, FrequentlyQuestions.class);
    }
    public static List<FrequentlyQuestions> getFrequentlyQuestions(){
        return (List<FrequentlyQuestions>) getAll("FrequentlyQuestions");
    }

    public static boolean createFrequentlyQuestion(FrequentlyQuestions frequentlyquestion) {
        if(getFrequentlyQuestion(frequentlyquestion.getId()) != null){
            return false;
        }
        else {
            return create(frequentlyquestion);
        }
    }
    public static boolean updateFrequentlyQuestion(FrequentlyQuestions frequentlyquestion) {
        if(getFrequentlyQuestion(frequentlyquestion.getId()) == null){
            return false;
        }
        else {
            return update(frequentlyquestion);
        }
    }

    public static boolean deleteFrequentlyQuestion(FrequentlyQuestions frequentlyquestion){
        if(getFrequentlyQuestion(frequentlyquestion.getId()) == null){
            return false;
        }
        else {
            return delete(frequentlyquestion);
        }
    }
}
