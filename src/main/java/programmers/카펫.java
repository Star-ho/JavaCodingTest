package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 카펫 {
    public static void main(String[] arg){
        System.out.println(Arrays.toString(solution(10,2)));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        int sum=brown+yellow;
        int loopLast=sum/2;
        int left=0;
        for(int i=2;i<loopLast;i++){
            if(sum%i==0){
                left=i;
            }
        }

        int right=sum/left;
        if(left>right){
            answer[0]=left;
            answer[1]=right;
        }else {
            answer[0]=right;
            answer[1]=left;
        }

        return answer;
    }
}
