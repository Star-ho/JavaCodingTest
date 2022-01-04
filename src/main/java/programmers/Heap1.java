package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Heap1 {
    public static void main(String[] arg){
        int[] arr = {1,2, 3, 9, 12,10 };

//        System.out.println(Arrays.toString(arr));
        System.out.println(solution(arr,7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        var listScoville= new PriorityQueue<Integer>();

        for(int i : scoville){
            listScoville.add(i);
        }
        int temp=listScoville.poll();
        while(temp<K){
            temp=temp+listScoville.poll()*2;
            listScoville.add(temp);
            temp=listScoville.poll();
            if(listScoville.size()==1&&temp<K){
                return -1;
            }
            answer++;
        }
        return answer;
    }
}
