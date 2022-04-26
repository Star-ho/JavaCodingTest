package programmers.previous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N으로_표현 {
    public static void main(String[] arg){
        System.out.println(solution(8,53));
    }

    public static int solution(int N, int number) {
        int answer = 0;
        List<Integer> numList=new ArrayList<>();
        numList.add(N);
        for(int i=1;i<=8;i++){
            List<Integer> newNumList=new ArrayList<>();
            for(Integer num:numList){
                newNumList.add(num+N);
                newNumList.add(num*N);
                newNumList.add(num/N);
                String str="";
                for(int j=0;j<i;j++){
                    str+=N;
                }
                newNumList.add(Integer.parseInt(str));
                newNumList.add(num-N);
                if(num!=0){
                    newNumList.add(N/num);
                }
            }
//            System.out.println(newNumList);
            numList=newNumList;
            answer++;
            if(numList.contains(number)){
                break;
            }if(i==7){
                answer=-1;
            }
        }
        return answer;
    }
}
