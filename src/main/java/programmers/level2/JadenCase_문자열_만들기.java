package programmers.level2;

public class JadenCase_문자열_만들기 {
    public String solution(String s) {
        String answer = "";
        s=s.toLowerCase();
        String[] strArr=s.split(" ");
        for(int i=0;i<strArr.length;i++){
            char[] charArr=strArr[i].toCharArray();
            if(charArr.length==0)continue;
            if(charArr[0]>='a'&&charArr[0]<='z'){
                charArr[0]-=('a'-'A');
            }
            // System.out.println(Arrays.toString(charArr));
            strArr[i]=new String(charArr);
        }
        answer=String.join(" ",strArr);
        char[] ss = s.toCharArray();
        if(ss[ss.length-1]==' ')answer+=" ";
        return answer;
    }
}
