import java.sql.SQLOutput;
import java.util.*;

public class ATest {
    public static void main(String[] arg){
        System.out.println(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));
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
