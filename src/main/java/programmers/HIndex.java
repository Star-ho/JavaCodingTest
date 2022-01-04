package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class HIndex {
    public static void main(String[] arg){
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
    }
    public static int solution(int[] citations) {
        int answer = 0;
        var list=Arrays.stream(citations).boxed().collect(Collectors.toList());
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            if(list.get(i)>=i+1){
                answer= i+1;
            }
        }
        return answer;
    }
}
