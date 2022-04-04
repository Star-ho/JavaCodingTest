package leetcode;

public class SplitAStringInBalancedStrings_1221 {
    public int balancedStringSplit(String s) {
        char[] cArr=s.toCharArray();
        int answer=0;
        int bal=0;
        for(char c:cArr){
            if(c=='R')bal++;
            else if(c=='L')bal--;
            if(bal==0)answer++;
        }
        return answer;
    }
}
