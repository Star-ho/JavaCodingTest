package codility.sorting;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Triangle_retry {
    public int solution(int[] A) {
        if(A.length<3)return 0;
        Arrays.sort(A);
        // for(int i : nums)System.out.println(i);
        for(int i=0;i<A.length-2;i++){
            Long a=(long)A[i], b=(long)A[i+1],c=(long)A[i+2];
            if(c<a+b)
                return 1;
        }
        return 0;
    }
}