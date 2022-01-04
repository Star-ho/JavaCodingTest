package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {
    public static void main(String[] arg){
        System.out.println(solution(new int[]{3, 30, 34, 5, 9,10,21,0,30,100}));
    }
    public static String solution(int[] numbers) {
        String answer = "";
        String[] strArr=new String[numbers.length];
        for(int i=0;i<strArr.length;i++){
            strArr[i]=Integer.toString(numbers[i]);
        }

        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(Integer.parseInt(o1)%10==0){
                    if(Integer.parseInt(o1)/10==Integer.parseInt(o2)){
                        return 1;
                    }
                }
                if(Integer.parseInt(o2)%10==0){
                    if(Integer.parseInt(o2)/10==Integer.parseInt(o1)){
                        return -1;
                    }
                }
                return o2.compareTo(o1);
            }
        });

        for(var i : strArr){
            answer+=i;
        }
        return answer;
    }


}
