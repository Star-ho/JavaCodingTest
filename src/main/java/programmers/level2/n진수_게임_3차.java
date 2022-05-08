package programmers.level2;

public class n진수_게임_3차 {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int len = (m)*t;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<len;i++){
            sb.append(Integer.toString(i,n).toUpperCase());
        }
        int cur = p-1;
        // System.out.println(str);
        while(answer.length()<t){
            answer+=sb.charAt(cur);
            cur+=(m);
        }
        return answer;
    }
}
