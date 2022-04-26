package programmers.level1;

public class 콜라츠_추측 {
    public int solution(int num) {
        int repeat = 0;
        long longNum=num;
        while(repeat<500){
            if(longNum==1)break;
            if(longNum%2==0){
                longNum=longNum/2;
            }else{
                longNum=longNum*3+1;
            }
            repeat++;
        }
        if(longNum!=1)return -1;
        return repeat;
    }
}
