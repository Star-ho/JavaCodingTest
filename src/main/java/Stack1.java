import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stack1 {
    public static void main(String[] arg){
        int[] arr = {93, 30, 55};
        int[] arr2={1, 30, 5};
        System.out.println(Arrays.toString(solution(arr,arr2)));
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int answerIndex=0;
        for(int j=0;j<progresses.length;){
            int progressDay=(int)Math.ceil((double)(100-progresses[j])/speeds[j]);
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] = progresses[i] + speeds[i] * progressDay;
            }

            while(progresses[j]>=100){
                j++;
                if(answer.size()<=answerIndex){
                    answer.add(1);
                }else{
                    answer.set(answerIndex, answer.get(answerIndex)+1);
                }
                if(j==progresses.length){
                    break;
                }
            }
            answerIndex++;
        }
        int[] answerArr=new int[answer.size()];
        for(int i=0;i<answerArr.length;i++){
            answerArr[i]=answer.get(i);
        }
        return answerArr;
    }
}
