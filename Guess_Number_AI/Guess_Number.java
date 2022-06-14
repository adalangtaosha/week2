/**
 * 对键盘输入要猜测的数据范围，判别是否合法
 * 在合法数据范围内生成  数字答案
 * 识别不了，就在后面加  “!"
 */
package week2.Guess_Number_AI;
import java.util.Scanner;

public class Guess_Number {
    public String answer(int num_start,int num_end){
        String ret = null;
        return "不合法";
    }

    /*
         对键盘输入要猜测的数据范围，判别是否合法
     */
    public boolean Judge_Range(int start_scope, int end_scope){
        int mod = end_scope - start_scope;
        if (start_scope < 0 || end_scope < 0){
            System.out.println("开始或结束值必须是正数或者0");
            return false;
        }else if (mod <= 1){   //将mod==1，修改为mod<=1,考虑到结束小于开始的场景
            System.out.println("非法的数字范围:("+start_scope+","+end_scope+")");
            return false;
        }else {
            return true;
        }
    }

    /*
          生成要猜测的数字答案
     */
    public int Create_Guess_Number(int start_scope,int end_scope) {
        int big_num = (int) (Math.random() * end_scope * 100);
        int Num_to_Guess = (big_num % (end_scope - start_scope)) + start_scope;
        if (Num_to_Guess <= start_scope) {
            Num_to_Guess = start_scope + 1;
        } else if (Num_to_Guess > end_scope) {
            Num_to_Guess = end_scope - 1;
        }
        return Num_to_Guess;
    }

    /*
      判断猜测数字是否正确
      游戏次数统计
      游戏正确次数统计
      是否结束游戏
 */
    public boolean Judge_Guess_Number(int start_scope, int end_scope,int print_count) {
        // 游戏统计
        int correct_count = 0;//游戏正确次数
        int game_count = 0;//游戏次数
        boolean game_end = false;//是否继续游戏
        Scanner guess = new Scanner(System.in);

        while(!game_end){
            game_count++;
            int num_to_guess = Create_Guess_Number(start_scope,end_scope);
            int left_count = print_count;//本轮剩余次数
            boolean game_start = true;
            boolean guess_correct = false;
            while(left_count>0) {
                System.out.println("本轮游戏的数字范围为(" + start_scope + "," + end_scope + "),可输入次数为" +
                        left_count + ",请输入要猜测的数字,回车确认");
                int guess_num = guess.nextInt();
                if (guess_num == -1) {
                    game_end = true;
                    guess_correct = true;
                    game_count--;
                    System.out.println("停止游戏");
//                    return false;
                    break;

                }
                if (guess_num <= start_scope || guess_num >= end_scope) {
                    System.out.println("猜测数字不在规定范围内，请重新输入范围在(" + start_scope + "," + end_scope + ")内的数");
                    continue;
                }
                if (game_start){
                    game_start = false;
                }
                left_count--;
                if (guess_num > num_to_guess) {
                    System.out.println("输入数字比目标数字大");
                } else if (guess_num < num_to_guess) {
                    System.out.println("输入数字比目标数字小");
                } else {
                    correct_count++;
                    guess_correct = true;
                    System.out.println("输入数字正确！");
                    break;
                }
                if(left_count == 0){
                    System.out.println("本轮猜测失败，正确数字为:"+num_to_guess);
                }

            }
            System.out.println("共进行了" + game_count + "次游戏，其中正确的为" + correct_count + "次");

        }
        return false;
    }
}
