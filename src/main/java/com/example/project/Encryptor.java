package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    
    public static int determineColumns(int messageLen, int rows) {
        if (messageLen==0) {return 1;}
        if (messageLen%rows==0) {
        return messageLen/rows;
        } else {return (int) Math.round((1.0*messageLen/rows)+0.5);}
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        int columns = determineColumns(message.length(), rows);
        String[][] encrypt = new String[rows][columns];
        int iteration = 0;
        for (int i = 0; i < rows; i++) {
            for (int x = 0; x < columns; x++) {
                if (iteration < message.length()) {
                    encrypt[i][x] = message.substring(iteration, iteration + 1); 
                    iteration++;
                } else {
                    encrypt[i][x] = "="; 
                }
            }
        }
        return encrypt;
    }
    

    public static String encryptMessage(String message, int rows){
        String encrypted = "";
        String[][] encrypt = generateEncryptArray(message, rows);
        int columns = determineColumns(message.length(), rows);
        for (int i=columns-1; i>=0; i--) {
            for (int x=0; x<rows; x++) {
                encrypted+=encrypt[x][i];
            }
        }
        return encrypted;
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        String decrypted = "";
        int columns = encryptedMessage.length()/rows;
        String[][] message = new String[rows][columns];
        int iteration = 0;
        for (int i=columns-1; i>=0; i--) {
            for (int x=0; x<rows; x++) {
                message[x][i] = encryptedMessage.substring(iteration, iteration+1);
                if (iteration<encryptedMessage.length()-1) {iteration++;}
            }
        }
        for (int x=0; x<rows; x++) {
            for (int i=0; i<columns; i++) {
                if (!message[x][i].equals("=")) {decrypted+=message[x][i];}
            }
        }
        return decrypted;
    }

    public static void main(String[] args) {
        System.out.println(decryptMessage("lsai h nysaewoenm a ewitno n o ftekyor=======Aak steol tt hs aecnb rte noerwo h ebad======", 45));
    }
}