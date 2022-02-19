package codility.maximumSliceProblem;

class EquiLeader {
    public int solution(int[] A) {
        int[] counter={0,0};
        for(int i=0;i<A.length;i++){
            if(counter[1]==0){
                counter[0]=A[i];
                counter[1]++;
            }else if(counter[0]==A[i]){
                counter[1]++;
            }else{
                counter[1]--;
            }
        }

        int leader=-1;
        if(counter[1]>0){
            int candidate=counter[0];
            int candidateCounter=0;
            for(int a:A){
                if(a==candidate){
                    candidateCounter++;
                }
            }
            if(candidateCounter>Math.ceil(A.length/2)){
                leader=candidate;
            }
        }
        if(leader==-1){
            return 0;
        }

        int beforeCounter=0;
        int answer=0;
        int afterCounter=0;
        int flag=0;
        for(int i=0;i<A.length;i++){
            int a=A[i];
            if(a==leader){
                beforeCounter++;
                afterCounter-=flag;
            }else{
                beforeCounter--;
                afterCounter+=flag;
            }
            if(beforeCounter>0){
                if(flag==0){
                    for(int j=i+1;j<A.length;j++){
                        if(A[j]==leader){
                            afterCounter++;
                        }else{
                            afterCounter--;
                        }
                    }
                    flag=1;
                }
                if(afterCounter>0){
                    answer++;
                }
            }
        }
        return answer;
    }
}
