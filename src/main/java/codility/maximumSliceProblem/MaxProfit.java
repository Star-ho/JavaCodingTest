package codility.maximumSliceProblem;

class MaxProfit {
    public int solution(int[] A) {
        int len=A.length;
        int max_ending=0;
        int max_slice=0;
        for(int i=1;i<len;i++){
            int profit=A[i]-A[i-1];
            max_ending=max_ending+profit>0?max_ending+profit:0;
            max_slice=max_ending>max_slice?max_ending:max_slice;
        }
        return max_slice;
    }
}
