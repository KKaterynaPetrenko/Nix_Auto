package ua.com.alevel.task1;

import java.io.BufferedReader;
import java.util.Scanner;

public class Task1 {

    public void run(BufferedReader reader) {
        System.out.println("Task1.run");
        task1();
    }

    public static void task1() {
        Scanner console = new Scanner(System.in);
        System.out.println("Please, input word:");
        String name = console.nextLine();
        char[] result = name.toCharArray();
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] >= '0' && '9' >= result[i]) {
                sum += result[i] - '0';
            }
        }
        System.out.println("Sum = " + sum);
    }
}
