package codility.sieveOfEratosthenes;

class CountSemiprimes {
    public int[] solution(int N, int[] P, int[] Q) {
        int[] numArr=new int[N*2+1];

        int num=2;
        while(num<numArr.length){
            if(numArr[num]==0){
                int k=num+num;
                while(k<numArr.length){
                    numArr[k]+=numArr[num]+1;
                    if(k/num==num)numArr[k]++;
                    else numArr[k]+=numArr[k/num];
                    k+=num;
                }
            }
            num++;
        }

        int[] primeSliceSumArr=new int[N+1];

        int accumSum=0;
        for(int i=0;i<primeSliceSumArr.length;i++){
            if(numArr[i]==2){
                accumSum++;
            }
            primeSliceSumArr[i]=accumSum;
        }

        int[] answerArr=new int[P.length];
        for(int i=0;i<P.length;i++){
            answerArr[i]=primeSliceSumArr[Q[i]]-primeSliceSumArr[P[i]-1];
        }

        return answerArr;
    }
}

