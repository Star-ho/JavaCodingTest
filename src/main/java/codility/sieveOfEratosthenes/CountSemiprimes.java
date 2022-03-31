package codility.sieveOfEratosthenes;

class CountSemiprimes {
    public int[] solution(int N, int[] P, int[] Q) {
        int[] F=arrayF(N);
        int[] semiPrimeNumArr=new int[F.length];
        for(int i=1;i<F.length;i++){
            if(F[i]==2){
                semiPrimeNumArr[i]=semiPrimeNumArr[i-1]+1;
            }else{
                semiPrimeNumArr[i]=semiPrimeNumArr[i-1] ;
            }
        }
        int[] answer=new int[P.length];
        for(int i=0;i<answer.length;i++){
            answer[i]=semiPrimeNumArr[Q[i]]-semiPrimeNumArr[P[i]-1];
        }
        return answer;
    }

    private int[] arrayF(int n){
        int[] F=new int[n+1];
        int i=2;
        int nSqrt=(int)Math.sqrt(n);
        while(i<=n){
            if(F[i]==0){
                F[i]=1;
                if(i<=nSqrt)F[i*i]++;
            }
            int k=i+i;
            while(k<=n){
                F[k]+=F[i];
                k+=i;
            }
            i++;
        }
        return F;
    }
}

