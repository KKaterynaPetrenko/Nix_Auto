package ua.com.alevel.cipherTask;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CipherGame
{
    private Map<String, String> dictionary = new HashMap<String, String>();

    public void Run(BufferedReader reader) {
        while (true) {
            PrintInfo();
            var console = new Scanner(System.in);
            var operation = console.nextLine();


            switch (operation) {
                case "1": {
                    System.out.println("Enter your word: ");
                    var word = console.nextLine();
                    var unicode = ConvertToUnicodeString(word);
                    dictionary.put(word, unicode);
                    System.out.println("Word is added.");
                    break;
                }
                case "2": {
                    System.out.println(dictionary);
                    break;
                }
            }
        }
    }

    private String ConvertToUnicodeString(String operation) {
        char[] result = operation.toCharArray();
        String codeKey = "";
        for (int i = 0; i < result.length; i++) {
            int codePoint = operation.codePointAt(i);
            codeKey += String.valueOf(codePoint);
        }
        return codeKey;
    }

    private static void PrintInfo(){
        System.out.println("if you want to put your word in dictionary, please select 1");
        System.out.println("if you want to look all dictionary list, please select 2");
        System.out.println("Select you event:");
        System.out.println();
    }
}
