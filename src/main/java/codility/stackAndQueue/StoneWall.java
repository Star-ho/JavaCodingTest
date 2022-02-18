package codility.stackAndQueue;

// you can also use imports, for example:
import java.util.*;
import java.util.stream.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class StoneWall {
    public int solution(int[] H) {
        int answer=0;
        Deque<Integer> numDeque=new ArrayDeque<>();

        numDeque.addLast(H[0]);
        answer++;
        int hLen=H.length;
        for(int i=1;i<hLen;i++){
            int h=H[i];
            int last=numDeque.getLast();
            if(last==h){
                answer--;
            }else{
                if(last>h){

                    while(last>h){
                        numDeque.removeLast();
                        if(numDeque.isEmpty()){
                            break;
                        }
                        last=numDeque.getLast();
                    }
                    if(last==h){
                        answer--;
                    }
                }
                numDeque.addLast(h);
            }
            answer++;
        }
        return answer;
    }
}