package programmers;

public class 다트_게임 {
    public int solution(String dartResult) {
        int answer = 0;
        char[] dartChar = dartResult.toCharArray();
        int cur = 0;
        int[] answerArr=new int[3];
        for(int i=0;i<answerArr.length;i++){
            int n=0;
            if(dartChar[cur]=='1'){
                if(dartChar[cur+1]!='S'&&dartChar[cur+1]!='D'&&dartChar[cur+1]!='T'){
                    n=10;
                    cur++;
                }else{
                    n=1;
                }
            }else{
                n=Character.getNumericValue(dartChar[cur]);
            }

            cur++;
            switch(dartChar[cur]){
                case 'D':n=(int)Math.pow(n,2);
                    break;
                case 'T':n=(int)Math.pow(n,3);
                    break;
            }
            cur++;
            if(cur>=dartChar.length){
                answer+=n;
                break;
            }
            if(dartChar[cur]=='*'){
                if(i>0)answerArr[i-1]=answerArr[i-1]*2;
                n=n*2;
                answerArr[i]=n;
                cur++;
            }else if(dartChar[cur]=='#'){
                n=n*(-1);
                answerArr[i]=n;
                cur++;
            }else{
                answerArr[i]=n;
            }

        }

        for(int n : answerArr)answer+=n;
        return answer;
    }
}
