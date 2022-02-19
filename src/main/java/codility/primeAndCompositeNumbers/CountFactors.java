package codility.primeAndCompositeNumbers;

class CountFactors {
    public int solution(int N) {
        int answer=0;
        int nSqrt=(int)Math.sqrt(N);
        int i=1;
        for(;i<=nSqrt;i++){
            if(i*i==N){
                answer++;
                break;
            }
            if(N%i==0){
                answer+=2;
            }
        }

        return answer;
    }
}