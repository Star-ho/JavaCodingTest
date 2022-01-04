package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Greddy1 {

    public static void main(String[] arg){
        int[] ar= {2,3,4,12,15};
        int[] arr={3,4,5,11};
//        System.out.println(Arrays.toString(arr));
        System.out.println(solution(20,ar,arr));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = 0;
        int borrowInt=0;
        ArrayList<Integer> lostList= (ArrayList<Integer>) Arrays.stream(lost).boxed().collect(Collectors.toList());
        Map<Integer,Boolean> reserveMap=new HashMap<>();
        for(int temp:reserve){
            reserveMap.put(temp,true);
        }

        for(int i=0;i<lostList.size();i++) {
            if (reserveMap.get(lostList.get(i)) != null && reserveMap.get(lostList.get(i))) {
                reserveMap.put(lostList.get(i), false);
                lostList.remove(i);
                i--;
                borrowInt++;
            }
        }

        for(int i=0;i<lostList.size();i++){
            if(reserveMap.get(lostList.get(i)-1)!=null&&reserveMap.get(lostList.get(i)-1)){
                reserveMap.put(lostList.get(i)-1,false);
                lostList.remove(i);
                i--;
            }else if(reserveMap.get(lostList.get(i)+1)!=null&&reserveMap.get(lostList.get(i)+1)){
                reserveMap.put(lostList.get(i)+1,false);
                lostList.remove(i);
                i--;
            }
        }
        answer=n-lostList.size();
        return answer;
    }
}
