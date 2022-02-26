package codility.caterpillarMethod;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class CountDistinctSlices {
    public int solution(int M, int[] A) {
        int left=0, right=0, answer=0;
        int[] count=new int[M+1];
        while(left<A.length){
            if(right<A.length&&count[A[right]]==0){
                count[A[right]]++;
                right++;
            }else{
                // System.out.println(left+" "+right+" "+(right-left));
                answer+=right-left;
                count[A[left]]--;
                left++;
                if(answer>=1000000000){
                    return 1000000000;
                }
            }
        }
        return answer;
    }
}
