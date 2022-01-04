package programmers;

import java.util.*;

public class Programmers1 {
    public static void main(String[] args) {
        String a[] = {"mislav", "stanko", "mislav", "ana"};
        String b[] = {"stanko", "ana", "mislav"};
        System.out.println(solution(a,b));
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> partMap= new HashMap<>();
        for(String i : participant){
            if(partMap.get(i)!=null) {
                partMap.put(i, partMap.get(i) + 1);
            }else{
                partMap.put(i,1);
            }
        }
        for(String i : completion){
            partMap.put(i, partMap.get(i) -1);
        }
        for(String i:participant){
            if(partMap.get(i)>0){
                answer=i;
            }
        }
        return answer;
    }

}


