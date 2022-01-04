package 더생각;

import java.util.Arrays;

public class 없는숫자더하기 {
    public static void main(String[] arg){
        System.out.println(solution(new int[]{1,2,3,4,6,7,8,0}));
    }

    public static int solution(int[] numbers) {
        int answer = -1;
        for (int i=0;i<10;i++){
            int finalI = i;
            if (!Arrays.stream(numbers).anyMatch(num->num== finalI))continue;
            if (answer==-1)answer=0;
            answer+=i;
        }
        return answer;
    }
}
