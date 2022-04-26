package programmers.previous;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Greedy3 {
    public static void main(String[] arg){
        System.out.println(solution("19274",2));
    }

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int numLen=number.length();
        List<Integer> numberList= Arrays.asList(number.split("")).stream().map(Integer::parseInt).collect(Collectors.toList());
        int index=0;
        while (answer.length()<numLen-k){
            if(numLen-index/*이제 남은 길이*/<=numLen-k-answer.length()/*구해야할 길이에서 구한길이*/) {
                for(int i=index;i<numberList.size();i++){
                    answer.append( numberList.get(i));
                }
                break;
            }

            int a=numLen-k-answer.length()-1;//빼야하는 갯수 구해야하는갯수
            List<Integer> sublist=numberList.subList(index,numLen-a);

            int curMax=Collections.max(sublist);
            loop:for(int i=index;i<numberList.size();i++){
                if(curMax==numberList.get(i)){
                    index=i+1;
                    break loop;
                }
            }
            answer.append(curMax);

        }

        return answer.toString();
    }

}
