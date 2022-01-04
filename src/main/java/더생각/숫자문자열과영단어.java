package 더생각;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class 숫자문자열과영단어 {
    public static void main(String[] arg){
        System.out.println(solution("one4seveneight"));
    }

    public static int solution(String s) {
        StringBuilder answer = new StringBuilder();

        var map=makeMap();
        String[] numArr={"0","1","2","3","4","5","6","7","8","9"};
        var numStrArr=map.keySet();
        var numBuilder=new StringBuilder(s);
        for (int i = 0; i < numBuilder.length(); i++) {
            int finalI = i;
            if(Arrays.stream(numArr).anyMatch(numBuilder.substring(finalI,finalI+1)::equals)){
                answer.append(numBuilder.substring(finalI,finalI+1));
            }else {
                for (var numStr:numStrArr) {
                    if (finalI+numStr.length()>numBuilder.length())continue;
                    String splitStr=numBuilder.substring(finalI,finalI+numStr.length());
                    if (Objects.equals(splitStr, numStr)) {
                        i += numStr.length()-1;
                        answer.append(map.get(numStr));
                    }
                };
            }
        }
        return Integer.parseInt(answer.toString());
    }

    private static Map<String,String> makeMap(){
        var map = new HashMap<String,String>();
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");
        return map;
    }
}
