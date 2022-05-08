package programmers.level2;

import java.util.Arrays;

public class 최솟값_만들기 {
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length;
        for(int i=0;i<A.length;i++){
            answer+=A[i]*B[len-i-1];
        }

        return answer;
    }
}
