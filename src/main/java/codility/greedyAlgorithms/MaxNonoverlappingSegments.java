package codility.greedyAlgorithms;

class MaxNonoverlappingSegments {
    public int solution(int[] A, int[] B) {
        int[] checkArr=new int[A.length];
        int c=0;
        for(int i=0;i<A.length-1;i++){
            if(checkArr[i]==1)continue;
            if(A[i+1]<=B[i]){
                checkArr[i+1]=1;
                for(int j=i+1;j<A.length;j++){
                    if(A[j]<=B[i]){
                        checkArr[j]=1;
                    }
                }
            }
            c++;
        }
        if(A.length>0&&checkArr[A.length-1]!=1)c++;
        return c;
    }
}
