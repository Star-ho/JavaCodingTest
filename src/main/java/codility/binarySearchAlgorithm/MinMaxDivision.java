package codility.binarySearchAlgorithm;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class MinMaxDivision {
    public int solution(int K, int M, int[] A) {
        int[] lo={0,-1};
        int sum=Arrays.stream(A).sum();
        int lastVal=sum/K;
        int[] hi={sum,sum};
        int[] mid=new int[2];
        while(lo[0]<hi[0]){
            mid=new int[]{(lo[0]+hi[0])/2,getMaxValue(A,K,(lo[0]+hi[0])/2)};
            if(mid[1]==-1||mid[1]<lastVal){
                lo=new int[]{mid[0]+1,mid[1]};
            }else{
                hi=new int[]{mid[0],mid[1]};
            }
        }
        return hi[1];
    }

    private int getMaxValue(int[] A,int K, int maxVal){
        int divideNum=1;
        int curSum=0;
        int res=0;
        for(int i=0;i<A.length;i++){
            if(curSum==0||curSum+A[i]<maxVal){
                curSum+=A[i];
            }else{
                res=Math.max(res,curSum);
                curSum=A[i];
                divideNum++;
            }
            if(divideNum>K)return -1;
        }
        res=Math.max(res,curSum);
        return res;
    }
}