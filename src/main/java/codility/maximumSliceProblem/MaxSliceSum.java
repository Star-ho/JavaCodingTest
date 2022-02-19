package codility.maximumSliceProblem;

class MaxSliceSum {
    public int solution(int[] A) {
        int maxEnd=0;
        int maxSlice=0;
        int len=A.length;
        int[] checkMinus={0,Integer.MIN_VALUE};
        for(int i=0;i<len;i++){
            if(A[i]<0&&checkMinus[0]>-1){
                checkMinus[0]=1;
                if(A[i]>checkMinus[1]){
                    checkMinus[1]=A[i];
                }
            }else{
                checkMinus[0]=-1;
            }
            maxEnd=maxEnd+A[i]>0?maxEnd+A[i]:0;
            maxSlice=maxSlice>maxEnd?maxSlice:maxEnd;
        }
        if(maxSlice==0&&checkMinus[0]>0)return checkMinus[1];
        return maxSlice;
    }
}