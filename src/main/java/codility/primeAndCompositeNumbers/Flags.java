package codility.primeAndCompositeNumbers;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");


class Flags {
    public int solution(int[] A) {
        int[] peeks=new int[A.length];

        for(int i=1;i<A.length-1;i++){
            if(A[i]>Math.max(A[i-1],A[i+1])){
                peeks[i]=1;
            }
        }

        int[] nextPeek=new int[A.length];
        nextPeek[A.length-1]=-1;
        for(int i=A.length-2;i>=0;i--){
            if(peeks[i]==1){
                nextPeek[i]=i;
            }else{
                nextPeek[i]=nextPeek[i+1];
            }
        }

        int answer=0;
        int maxFlag=(int)Math.sqrt(peeks.length)+12;
        for(int flag=1;flag<maxFlag;flag++){
            int getFlag=0;
            int pos=1;
            for(;pos<peeks.length&&getFlag<flag;){
                pos=nextPeek[pos];
                if(pos==-1){
                    break;
                }
                pos+=flag;
                getFlag++;
            }
            answer=Math.max(answer,getFlag);
        }

        return answer;
    }
}