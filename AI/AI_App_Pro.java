package week2.AI;

import java.util.Scanner;

public class AI_App_Pro {
    public static void main(String[] args) {
        AI_Pro ai = new AI_Pro();
        Scanner in = new Scanner(System.in);
        while (true) {
            String input = in.next();
            if ("exit".equals(input)) {
                System.out.println("再见！");
                break;
            }
            String answer = ai.answer(input);
            System.out.println(answer);
        }
    }
}
