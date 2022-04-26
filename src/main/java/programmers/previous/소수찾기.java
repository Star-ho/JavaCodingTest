package programmers.previous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 소수찾기 {
    public int solution(int n) {
        int answer = 0;
        boolean[] arr = new boolean[n+1];
        for(int i=2;i<arr.length;i++){
            if(!arr[i]){
                answer++;
                for(int j=i;j<arr.length;j+=i){
                    arr[j]=true;
                }
            }
        }
        return answer;
    }
}
