package week2.Guess_Number_AI;
import week2.Guess_Number_AI.Guess_Number;
import java.util.Scanner;

public class Guess_Number_App {
    public static void main(String[] args) {
        Guess_Number guess = new Guess_Number();
        Scanner num_in = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("请输入开始范围");
            int start_scope = num_in.nextInt();
            System.out.println("请输入结束范围");
            int end_scope = num_in.nextInt();
            boolean answer_scope = guess.Judge_Range(start_scope,end_scope);  //判别输入范围是否合法
            if (answer_scope){ // 若输入范围合法则继续游戏
                System.out.println("请输入本轮游戏次数");
                int print_count = num_in.nextInt();
//                guess.Judge_Guess_Number(start_scope,end_scope,print_count);
                flag = guess.Judge_Guess_Number(start_scope,end_scope,print_count);
            }else{
                continue;
            }


        }
    }

}
