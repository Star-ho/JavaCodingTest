package programmers.level2;

public class 다음_큰_숫자 {
    public int solution(int n) {
        int answer = 0;
        int nOneCount=getOneNumber(n);
        int nextN=n+1;
        int nextOneCount=getOneNumber(nextN);
        while(nOneCount!=nextOneCount){
            nextN++;
            nextOneCount=getOneNumber(nextN);
        }

        return nextN;
    }

    private int getOneNumber(int n){
        String binaryN = Integer.toString(n,2);
        char[] binaryArr = binaryN.toCharArray();
        int c= 0;
        for(char chr : binaryArr){
            if(chr=='1')c++;
        }
        return c;
    }
}
