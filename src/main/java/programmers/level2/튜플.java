package programmers.level2;

import java.util.*;

public class 튜플 {
    public int[] solution(String s) {
        s=s.replaceAll("[\\{}]","");
        Integer[] numArr= Arrays.stream(s.split(","))
                .mapToInt(e->Integer.parseInt(e)).boxed().toArray(Integer[]::new);
        Map<Integer,Integer> intMap=new HashMap<>();

        for(int num:numArr){
            if(!intMap.containsKey(num)){
                intMap.put(num,0);
            }
            intMap.put(num,intMap.get(num)+1);
        }

        List<int[]> intArrList = new ArrayList<>();
        for(int key : intMap.keySet()){
            intArrList.add(new int[]{key,intMap.get(key)});
        }
        Collections.sort(intArrList,(a,b)->b[1]-a[1]);
        int[] answer = intArrList.stream().mapToInt(e->e[0]).toArray();
        return answer;
    }
}
