package codility.leader;
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Dominator {
    public int solution(int[] A) {
        int answer=-1;
        int len=A.length;
        int domiNum=(int)Math.ceil(len/2);
        int[] counter={0,0};
        for(int i=0;i<len;i++){
            if(counter[1]==0){
                counter[0]=i;
                counter[1]++;
            }else if(A[i]==A[counter[0]]){
                counter[1]++;
            }else{
                counter[1]--;
            }
        }
        int temp=-1;
        if(counter[1]>0){
            temp=A[counter[0]];
        }
        counter[1]=0;
        for(int a:A){
            if(temp==a){
                counter[1]++;
            }
        }
        if(counter[1]>domiNum){
            answer=counter[0];
        }
        return answer;
    }
}