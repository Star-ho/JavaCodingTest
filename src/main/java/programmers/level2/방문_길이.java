package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class 방문_길이 {
    public int solution(String dirs) {
        int answer = 0;
        Map<String,Boolean> visited = new HashMap<>();
        int[] cur={0,0};

        char[] dirArr=dirs.toCharArray();
        for(int i=0;i<dirArr.length;i++){
            int[] next=null;
            if(dirArr[i]=='L'){
                if(cur[1]-1>=-5){
                    next=new int[]{cur[0],cur[1]-1};
                }
            }else if(dirArr[i]=='R'){
                if(cur[1]+1<=5){
                    next = new int[]{cur[0],cur[1]+1};
                }
            }else if(dirArr[i]=='U'){
                if(cur[0]+1<=5){
                    next = new int[]{cur[0]+1,cur[1]};
                }
            }else{
                if(cur[0]-1>=-5){
                    next = new int[]{cur[0]-1,cur[1]};
                }
            }
            if(next!=null){
                if(!visited.containsKey(""+cur[0]+cur[1]+next[0]+next[1])){
                    // System.out.println(Arrays.toString(cur));
                    answer++;
                    visited.put(""+cur[0]+cur[1]+next[0]+next[1],true);
                    visited.put(""+next[0]+next[1]+cur[0]+cur[1],true);
                }
                cur=new int[]{next[0],next[1]};
            }
        }
        return answer;
    }

}
