package programmers.previous;

import java.util.*;
import java.util.regex.Pattern;

public class 메뉴_리뉴얼 {

    public String[] solution(String[] orders, int[] course) {
        List<String> answer=new ArrayList<>();
        for(int n:course){
            Map<String,Integer> courseMap=new HashMap<>();
            for(String order:orders){
                char[] orderArr=order.toCharArray();
                Arrays.sort(orderArr);
                findCourse(orderArr,"",n,courseMap,-1);
            }
            findAnswer(courseMap,answer);
            // System.out.println(courseMap);
        }

        // System.out.println(answer);
        String[] answerA= answer.toArray(String[]::new);
        Pattern pattern=Pattern.compile("123");

        Arrays.sort(answerA);
        return answerA;
    }
    private void findAnswer(Map<String,Integer> courseMap, List<String> answer){
        int max=2;
        List<String> temp=new ArrayList<>();
        List<String> keyList=new ArrayList<>(courseMap.keySet());
        for(String key:keyList){
            if(courseMap.get(key)>max){
                temp=new ArrayList<>();
                max=courseMap.get(key);
            }
            if(courseMap.get(key)==max){
                temp.add(key);
            }
        }
        answer.addAll(temp);

    }

    private void findCourse(char[] orderArr,String cur,int n,
                            Map<String,Integer> courseMap,int index){
        if(cur.length()==n){
            if(!courseMap.containsKey(cur)){
                courseMap.put(cur,0);
            }
            courseMap.put(cur,courseMap.get(cur)+1);
            return;
        }
        if(index==orderArr.length-1){
            return;
        }
        for(int i=index+1;i<orderArr.length;i++){
            findCourse(orderArr,cur+orderArr[i],n,courseMap,i);
        }
    }
}
