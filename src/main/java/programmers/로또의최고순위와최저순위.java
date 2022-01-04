package programmers;

import java.util.Arrays;

public class 로또의최고순위와최저순위 {
    public static void main(String[] arg){
        var answer=solution(new int[]{44, 1, 0, 0, 31, 25},new int[]{31, 10, 45, 1, 6, 19});
        Arrays.stream(answer).forEach(System.out::println);
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};
        int zeroCount=0;
        int count=0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i]==0) {
                zeroCount++;
                continue;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i]==win_nums[j]) {
                    count++;
                    break;
                }
            }
        }
        var resArray=new int[]{count + zeroCount, count};
        for (int i = 0; i < resArray.length; i++) {
            switch (resArray[i]){
                case 0:
                case 1: answer[i]=6;break;
                case 2:answer[i]=5;break;
                case 3:answer[i]=4;break;
                case 4:answer[i]=3;break;
                case 5:answer[i]=2;break;
                default:answer[i]=1;break;
            }
        }
        return answer;
    }
}
