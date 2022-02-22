package codility.fibonacciNumbers;

import java.util.*;
import java.util.stream.*;

class Ladder {
    public int[] solution(int[] A, int[] B) {
        int[] answer=new int[A.length];
        int[] fiboArr=getFiboArr(A.length);

        for(int i=0;i<answer.length;i++){
            answer[i]=fiboArr[A[i]+1]%(int)Math.pow(2,B[i]);
        }

        return answer;
    }

    private int[] getFiboArr(int num){
        int[] resArr=new int[num+3];
        resArr[0]=0;
        resArr[1]=1;
        int maxPow=(int)Math.pow(2,30);
        for(int i=2;i<resArr.length;i++){
            resArr[i]=(resArr[i-1]+resArr[i-2])%maxPow;
        }
        return resArr;
    }
}