package codility.caterpillarMethod;

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class AbsDistinct {
    public int solution(int[] A) {
        int head=0;
        int tail=A.length-1;
        int c=0;
        while(head<=tail){
            if(head>0&&A[head]==A[head-1]){
                head++;
                continue;
            }
            if(tail<A.length-1&&A[tail]==A[tail+1]){
                tail--;
                continue;
            }

            long  headAbs=Math.abs(Long.valueOf(A[head]));
            long  tailAbs=Math.abs(Long.valueOf(A[tail]));

            if(headAbs==tailAbs){
                head++;
                tail--;
            }else if(headAbs>tailAbs){
                head++;
            }else{
                tail--;
            }
            c++;
        }

        return c;
    }
}
