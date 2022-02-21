package codility.sieveOfEratosthenes;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class CountNonDivisible_retry {
    public int[] solution(int[] A) {
        int[] countArr=new int[100001];
        int n=A.length;
        Arrays.fill(countArr,0);

        for(int i=0;i<n;i++){
            countArr[A[i]]++;
        }

        int index=0;
        int[] resArr=new int[A.length];
        for(int i=0;i<n;i++){
            int now=A[i];

            int count =0;
            for(int j=1;j*j<=now;j++){
                if(now%j==0){
                    count+=countArr[j];

                    if(now/j!=j){
                        count+=countArr[now/j];
                    }
                }
            }
            resArr[index]=n-count;
            index++;
        }

        return resArr;
    }
}
