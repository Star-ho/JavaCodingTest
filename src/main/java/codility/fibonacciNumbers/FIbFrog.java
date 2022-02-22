package codility.fibonacciNumbers;

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class FIbFrog {//91점 다시풀면 100점나옴
    public int solution(int[] A) {
        int[] fiboArr=getFibo(A.length);
        int[] lenArr=new int[A.length];

        int answer=A.length+1;
        for(int cur=-1;cur < A.length;cur++){
            for(int i=0;i<fiboArr.length;i++){
                if(cur!=-1&&lenArr[cur]==0)break;
                if(fiboArr[i]==0)break;
                int nextLoc=fiboArr[i]+cur;
                if(nextLoc==A.length){
                    if(cur==-1){
                        return 1;
                    }else{
                        // System.out.println("last"+cur+" "+nextLoc);
                        answer=Math.min(answer,lenArr[cur]+1);
                    }
                }
                if(nextLoc<A.length){
                    if(lenArr[nextLoc]==0){
                        if(A[nextLoc]==1){
                            // System.out.println(cur+" "+nextLoc);
                            if(cur==-1){
                                lenArr[nextLoc]=1;
                            }else{
                                lenArr[nextLoc]=lenArr[cur]+1;
                            }
                        }
                    }
                }
            }
        }
        if(answer==A.length+1)return -1;
        return answer;
    }

    private int[] getFibo(int num){
        int[] fiboList=new int[num+3];
        fiboList[0]=1;
        fiboList[1]=2;
        int index=1;
        while(fiboList[index]<=num){
            fiboList[index+1]=fiboList[index]+fiboList[index-1];
            index++;
        }
        return fiboList;
    }
}