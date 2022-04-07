package programmers;

import java.util.ArrayList;
import java.util.List;

public class n2배열자르기 {
    public int[] solution(int n, long left, long right) {
        List<Integer> answer=new ArrayList<>();
        int[] cur={(int)(left/n),(int)(left%n)};
        int[] end={(int)(right/n),(int)(right%n)};
        int i=0;
        // System.out.println("cur "+Arrays.toString(cur));
        // System.out.println("end "+Arrays.toString(end));
        do{
            i++;
            // if(i>10)break;
            // System.out.println(Arrays.toString(cur));
            answer.add(Math.max(cur[0],cur[1])+1);
            if(cur[1]==n-1){
                cur[0]++;
                cur[1]=0;
            }else{
                cur[1]++;
            }
        }while(cur[0]!=end[0]||cur[1]!=end[1]);
        answer.add(Math.max(cur[0],cur[1])+1);
        return answer.stream().mapToInt(e->e).toArray();
    }
}
