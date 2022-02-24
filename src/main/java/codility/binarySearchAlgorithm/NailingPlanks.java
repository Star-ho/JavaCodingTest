package codility.binarySearchAlgorithm;

import java.util.*;


//([1,5,8,12],[4,7,11,14],[1,5,8,12])
//        ([1,5,8,12],[4,7,11,14],[1,5,8,12,14])
//        ([1,5,8,12],[12,12,12,12],[12,5,8,12,14])
//        ([1,5,8,12],[12,12,12,12],[5,8,12,14])
//        ([1,2,3,4],[12,12,12,12],[5,8,12,14])
//        ([1],[12],[5])
//        ([1],[12],[15])
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class NailingPlanks {
    public int solution(int[] A, int[] B, int[] C) {
        int[] tempNailCheck=new int[A.length];
        Res lo=new Res(0,nailedPlanks(A,B,C,0,tempNailCheck));
        Res hi=new Res(C.length,nailedPlanks(A,B,C,C.length,
                Arrays.copyOf(tempNailCheck,tempNailCheck.length)));
        if(lo.sum==A.length){
            return 1;
        }
        if(hi.sum!=A.length){
            return -1;
        }

        while(lo.index<hi.index){
            Res mid=new Res((lo.index+hi.index)/2,
                    nailedPlanks(A,B,C,(lo.index+hi.index)/2,
                            Arrays.copyOf(lo.nailedCheck,lo.nailedCheck.length)));
            if(mid.sum<A.length){
                lo=mid;
                lo.index++;
            }else{
                hi=mid;
            }
        }

        return lo.index;
    }

    private int[] nailedPlanks(int[] A,int[] B, int[] C,
                               int num,int[] nailedCheck){

        for(int j=0;j<A.length;j++){
            if(nailedCheck[j]==0){
                for(int i=0;i<num;i++){
                    if(A[j]<=C[i]&&C[i]<=B[j]){
                        nailedCheck[j]=1;
                    }
                }
            }
            if(Arrays.stream(nailedCheck).sum()==A.length){
                return nailedCheck;
            }
        }
        return nailedCheck;
    }

    class Res{
        int index;
        int sum;
        int[] nailedCheck=new int[0];
        public Res(int index,int[] nailedCheck){
            this.index=index;
            this.nailedCheck=nailedCheck;
            this.sum=Arrays.stream(nailedCheck).sum();
        }
    }
}
