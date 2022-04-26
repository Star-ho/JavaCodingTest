package programmers.previous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class 모의고사 {
    public static void main(String[] arg){
        System.out.println(solution(new int[]{1, 3, 2, 4, 2,1,1,1,1,1,1,1,11,1,1,1,1,1,1,1,11,1,1,1,1,1,1,1,11,1,1,1,1,12,3,5,7,1,2,3,4,5,6,5}));
    }

    public static int[] solution(int[] answers) {
        int[] answer = {};
        ArrayList<Integer> firstMan=new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));//5
        ArrayList<Integer> secondMan=new ArrayList<>(Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));//8
        ArrayList<Integer> thirdMan=new ArrayList<>(Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));//10

        for(int i=0;i<10000;i++){
            if(firstMan.size()<=answers.length){
                firstMan.addAll(firstMan);
            }
            if(secondMan.size()<=answers.length){
                secondMan.addAll(secondMan);
            }
            if(thirdMan.size()<=answers.length){
                thirdMan.addAll(thirdMan);
            }
        }
        System.out.println(firstMan);
        ArrayList<Integer> temp=new ArrayList<>();
        int first=matchAnswer(firstMan,answers);
        int second=matchAnswer(secondMan,answers);
        int third=matchAnswer(thirdMan,answers);
        System.out.println(first+"   "+answers+"   "+third);
        if(first>=second&&first>=third){
            temp.add(1);
        }
        if(second>=first&&second>=third){
            temp.add(2);
        }
        if(third>=second&&third>=first){
            temp.add(3);
        }
        answer = temp.stream().mapToInt(i->i).toArray();

        return answer;
    }

    public static int matchAnswer(ArrayList<Integer> student,int[] answers){
        int match=0;
        for(int i=0;i< answers.length;i++){
            System.out.println(i);
            if(student.get(i)==answers[i]){
                match++;
            }
        }
        return match;
    }
}
