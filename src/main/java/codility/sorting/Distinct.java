package codility.sorting;

// you can also use imports, for example:
import java.util.*;

class Distinct {
    public int solution(int[] A) {
        int[] countArr=new int[2000001];
        Arrays.fill(countArr,0);
        int answer=0;

        for(int a:A){
            countArr[a+1000000]++;
        }
        int countLen=countArr.length;

        for(int i=0;i<countLen;i++){
            if(countArr[i]>0){
                answer++;
            }
        }
        return answer;
    }
}