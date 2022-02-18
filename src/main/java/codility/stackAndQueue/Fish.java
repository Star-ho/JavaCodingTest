package codility.stackAndQueue;

// you can also use imports, for example:
import java.util.Stack;

class Fish {
    public int solution(int[] A, int[] B) {
        int answer=0;
        Stack<int[]> numStack=new Stack<>();
        int aLen=A.length;

        for(int i=0;i<aLen;i++){
            int[] cur={A[i],B[i]};
            if(cur[1]==0&&numStack.size()==0){
                answer++;
            }else{
                if(cur[1]==1){
                    numStack.push(cur);
                }else{
                    while(numStack.size()>0){
                        int[] last=numStack.peek();
                        if(last[0]<cur[0]){
                            numStack.pop();
                        }else{
                            break;
                        }
                    }
                    if(numStack.size()==0){
                        answer++;
                    }
                }
            }
        }
        for(int[] numArr:numStack){
            if(numArr[1]==1){
                answer++;
            }
        }
        return answer;
    }
}