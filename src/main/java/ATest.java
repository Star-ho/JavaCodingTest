import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATest {
    public static void main(String[] arg){
        String a="111{123}111{444}asd";
        Pattern pattern = Pattern.compile("\\{(.*?)}");
        Matcher matcher = pattern.matcher(a);
        Set<String> set = new HashSet<>();
        while(matcher.find()){
            set.add(matcher.group(1));
            if(matcher.group(1)==null)break;
        }

        System.out.println(set);

        for(String literal : set){
            a=a.replaceAll("\\{"+literal+"}","ff");
        }
        System.out.println(a);


    }

    public static String[] solution(String[][] tickets) {
        List<String> answer=new ArrayList<>();
        Map<String, PriorityQueue<String>> ticketMap=new HashMap<>();
        for(String[] ticket:tickets){
            if(ticketMap.containsKey(ticket[0])){
                ticketMap.get(ticket[0]).add(ticket[1]);
            }else{
                ticketMap.put(ticket[0],new PriorityQueue<String>());
                ticketMap.get(ticket[0]).add(ticket[1]);
            }
        }

        String cur="ICN";
        answer.add(cur);

        while(true){
            System.out.println(cur);
            String temp=ticketMap.get(cur).poll();
            if(temp==null){
                break;
            }else{
                cur=temp;
                answer.add(cur);
            }
        }

        return new String[]{};
        // return answer.stream().toArray(String[]::new);

    }
}
