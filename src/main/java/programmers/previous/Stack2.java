package programmers.previous;

import java.util.*;
import java.util.stream.Collectors;

public class Stack2 {
    public static void main(String[] arg){
        int[] arr = {1,1,9,1,1,1 };
        int arr2=0;
        System.out.println((solution(arr,arr2)));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 1;
        var prioritiesList=new ArrayList<int[]>();
        for(int i=0;i<priorities.length;i++){
            if(i==location){
                var arr=new int[]{priorities[i],1};
                prioritiesList.add(arr);
            }
            var arr=new int[]{priorities[i],0};
            prioritiesList.add(arr);
        }
        while(prioritiesList.size()!=0){
            var max= Collections.max(prioritiesList.stream().map(i->i[0]).collect(Collectors.toList()) );
            if(max == prioritiesList.get(0)[0]){
                System.out.println(Arrays.toString(prioritiesList.get(0)));
                if(prioritiesList.get(0)[1]==1){
                    return answer;
                }else{
                    prioritiesList.remove(0);
                    answer++;
                }
            }else {
                prioritiesList.add(prioritiesList.get(0));
                prioritiesList.remove(0);
            }
        }

        return answer;
    }
}
