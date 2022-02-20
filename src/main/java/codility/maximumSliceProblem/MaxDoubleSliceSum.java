package codility.maximumSliceProblem;

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class MaxDoubleSliceSum {
    public int solution(int[] A) {
        if(A.length==3)return 0;
        int answer=0;
        int[] slicedA=Arrays.copyOfRange(A,1,A.length-1);
        int[] headSum=new int[slicedA.length+1];
        int[] tailSum=new int[slicedA.length+1];
        headSum[0]=0;
        for(int i=1;i<=slicedA.length;i++){
            headSum[i]=Math.max(headSum[i-1]+slicedA[i-1],0);
            // System.out.print(headSum[i]+" ");
        }
        // System.out.println();

        tailSum[slicedA.length-2]=0;
        for(int i=slicedA.length-1;i>=0;i--){
            tailSum[i]=Math.max(tailSum[i+1]+slicedA[i],0);
            // System.out.print(tailSum[i]+" ");
        }
        // System.out.println();

        for(int i=1;i<slicedA.length+1;i++){
            // System.out.println(headSum[i-1]+" "+tailSum[i]);
            answer=Math.max(headSum[i-1]+tailSum[i],answer);
        }

        return answer;
    }
}