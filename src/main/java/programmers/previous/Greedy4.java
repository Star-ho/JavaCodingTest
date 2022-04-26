package programmers.previous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Greedy4 {
    public static void main(String[] arg){
        System.out.println(solution(new int[]{70,50,80},100));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left=0;
        int right=people.length-1;
        while (left<=right){
            int weight=people[right--];
            if(weight+people[left]<=limit){
                left++;
            }
            answer++;
        }
        return answer;
    }
}
