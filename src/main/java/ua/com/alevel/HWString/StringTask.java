package ua.com.alevel.HWString;

import java.io.BufferedReader;
import java.util.Scanner;

public class StringTask {
    public void run(BufferedReader reader) {
        System.out.println("StringTask.run");
        Task4();
    }
    public static void Task4() {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите несколько слов");
        String inputWords = console.nextLine();
        String[] result = inputWords.split(" ");
        System.out.println("Введите еще одно слово");
        String inputKey = console.nextLine();
        System.out.println("Слова начинаются с " + inputKey + ": ");
        var printed = false;
        for( String beginning : result) {
            if(beginning.startsWith(inputKey)) {
                System.out.println(beginning);
                printed = true;
            }
        }
        if (!printed) {
            System.out.println("нет слов");
        }
        System.out.println("Слова заканчиваются на " + inputKey + ": ");
        for( String ending : result) {
            if(ending.endsWith(inputKey)) {
                System.out.println(ending);
                printed = true;
            }
        }
        if (!printed) {
            System.out.println("нет слов");
        }
        char[] charsInKey = inputKey.toCharArray();
        System.out.println("Слова, которые содержут общие символы с " + inputKey + ": ");
        for( String commonSymbol: result) {
            for(char commonKey : charsInKey) {
                String stringKey = Character.toString(commonKey);
                if(commonSymbol.contains(stringKey)){
                    System.out.println(commonSymbol);
                    break;
                }
            }

        }


    }
}
