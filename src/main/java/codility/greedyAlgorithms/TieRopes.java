package codility.greedyAlgorithms;


class TieRopes {
    public int solution(int K, int[] A) {
        int cur=0;
        int answer=0;
        for(int i=0;i<A.length;i++){
            cur+=A[i];
            if(cur>=K){
                answer++;
                cur=0;
            }
        }
        return answer;
    }
}
