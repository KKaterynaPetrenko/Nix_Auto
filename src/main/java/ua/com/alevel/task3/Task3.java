package ua.com.alevel.task3;

import java.io.BufferedReader;
import java.util.Scanner;

public class Task3 {
    public void run(BufferedReader reader) {
        System.out.println("Task3.run");
        Task3();
    }
    public static void Task3() {
        Scanner console = new Scanner(System.in);
        System.out.println("Please, input lesson number:");
        String input = console.nextLine();
        int numLesson = Integer.parseInt(input);
        int numOfBreak = numLesson - 1;
        int durationOfBreak = (numOfBreak / 2 * 20) + (numOfBreak % 2) * 5;
        int durationOfLesson = numLesson * 45;
        int allTime = durationOfBreak + durationOfLesson;
        int hours = allTime / 60 + 9;
        int minutes = allTime % 60;

        System.out.print( "End of lesson: " + hours + ":" + minutes);
    }
}
