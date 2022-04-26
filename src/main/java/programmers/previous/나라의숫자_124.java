package programmers.previous;


// 너무.. 어려워서 해답을 봤다
//수학 지식 부족했다
// 컴퓨팅 사고가 부족한 걸까/...
public class 나라의숫자_124 {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        while(n>0){
            int a=n%3;
            n=n/3;
            if(a==0){
                n--;
                a+=3;
            }
            if(a!=3)answer.insert(0,a);
            else answer.insert(0,4);
        }
        return answer.toString();
    }
}
