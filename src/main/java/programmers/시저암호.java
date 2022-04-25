package programmers;

public class 시저암호 {
    public String solution(String s, int n) {
        String answer = "";
        char[] sArr = s.toCharArray();
        boolean[] isBig = new boolean[sArr.length];
        for(int i=0;i<isBig.length;i++){
            if(sArr[i]<97)isBig[i]=true;
        }
        for(int i=0;i<sArr.length;i++){
            int c=sArr[i];
            if(c==' ')answer+=' ';
            else{
                if(isBig[i]){
                    if(c+n>90){
                        answer+=(char)(c+n-26);
                    }else{
                        answer+=(char)(c+n);
                    }
                }else{
                    if(c+n>122){
                        answer+=(char)(c+n-26);
                    }else{
                        answer+=(char)(c+n);
                    }
                }


            }
        }

        return answer;
    }
}
