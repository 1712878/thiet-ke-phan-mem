package UTILS;

import DTO.DTO;

import java.io.*;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.FileHandler;

public class GenerateDAOFiles {
    private static final String DTO_PATH = System.getProperty("user.dir")+"/src/main/java/DTO";
    private static final String DAO_PATH = System.getProperty("user.dir")+"/src/main/java/DAO/";
    private static String getFileName(String file){
        if(file!= null){
            return file.substring(0, file.lastIndexOf("."));
        }
        return null;

    }
    private static String createFileDAOName(String DTOName){
        if(DTOName!= null){
            return DTOName+"DAO.java";
        }
        return null;

    }
    private static String readFile(String fileName){
        StringBuilder builder = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(new File(fileName))));
            while (scanner.hasNext()){
                builder.append(scanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
    private static boolean writeFile(File file, String value){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(value);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        File DTOFile = new File(DTO_PATH);

        for(File file : Objects.requireNonNull(DTOFile.listFiles())){
            if(!file.getName().contains("DTO") && !file.getName().contains("Accounts")){
                String DTOFilename = getFileName(file.getName());
                String tempContent = readFile(DAO_PATH + "AccountsDAO.java");


                String output = tempContent.replace("Accounts", DTOFilename)
                                            .replace("Account", DTOFilename.endsWith("s") ? DTOFilename.substring(0, DTOFilename.length()-1) : DTOFilename)
                                            .replace("account",DTOFilename.endsWith("s") ? DTOFilename.substring(0, DTOFilename.length()-1).toLowerCase() : DTOFilename.toLowerCase());

               writeFile(new File(DAO_PATH+createFileDAOName(DTOFilename)), output);
            }
        }
    }
}
