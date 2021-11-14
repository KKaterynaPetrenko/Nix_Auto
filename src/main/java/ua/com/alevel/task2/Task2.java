package ua.com.alevel.task2;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Task2 {
    public void run(BufferedReader reader) {
        System.out.println("Task2.run");
        Task2();
    }
    public static void Task2() {
        Scanner console = new Scanner(System.in);
        System.out.println("Please, input word: ");
        String name = console.nextLine();
        char[] result = name.toCharArray();

        var alphabeticSymbols = new ArrayList<Character>();
        for (int i = 0; i < result.length; i++) {
            if (Character.isAlphabetic(result[i])) {
                alphabeticSymbols.add(result[i]);
            }
        }

        var charByCount = new HashMap<Character, Integer>();
        for (var i: alphabeticSymbols) {
            if (charByCount.containsKey(i)) {
                charByCount.replace(i, charByCount.get(i) + 1);
            }
            else {
                charByCount.put(i, 1);
            }
        }

        var pairs = new ArrayList<>(charByCount.entrySet());
        for (int i = 0; i < pairs.size()-1; i++)
            for (int j = 0; j < pairs.size()-i-1; j++)
                if (pairs.get(j).getValue() < pairs.get(j+1).getValue()) {
                    var temp = pairs.get(j);
                    pairs.set(j, pairs.get(j+1));
                    pairs.set(j+1, temp);
                }

        for (var i = 0; i < pairs.size(); i++) {
            System.out.print(String.format("%d. %s - %d%n", i + 1, pairs.get(i).getKey(), pairs.get(i).getValue()));
        }
    }
}

