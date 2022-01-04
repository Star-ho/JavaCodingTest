package programmers;

import java.util.Arrays;

public class 문자열압축 {
    public static void main(String[] arg){
        System.out.println(solution("aabbaccc"));
    }

    public static int solution(String s) {
        int answer = 0;
        int[] answerArr=new int[s.length()/2+1];
        Arrays.fill(answerArr,s.length());
        StringBuilder sb=new StringBuilder();
        int sLen=s.length();
        sb.append(s);
        for(int i=1;i<sLen/2+1;i++){
            String curStr = "";
            int curReapet = 1;
            for (int j = 0; j < sLen - i + 1; j += i) {
                if (!curStr.equals(sb.substring(j, j + i))) {
                    curStr = sb.substring(j, j + i);
                    if (curReapet > 1) {
                        int len=(""+curReapet).length();
                        answerArr[i] = answerArr[i] - curReapet * i + len+curStr.length();
                        curReapet = 1;
                    }
                } else {
                    curReapet++;
                }
            }
            if (curReapet > 1) {
                int len=(""+curReapet).length();
                answerArr[i] = answerArr[i] - curReapet * i + len+curStr.length();

            }
        }
        answer=s.length();
        for(int i:answerArr){
            answer=Math.min(i,answer);
        }
        return answer;
    }
}
