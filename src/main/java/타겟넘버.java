import java.util.Arrays;

public class 타겟넘버 {
    public static void main(String[] arg){
        System.out.println(solution(new int[]{1,1, 1,1,1},3));
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer+=DFS(0,numbers,0,target);
        return answer;
    }
    public static int DFS(int index,int[] numbers,int res,int target){
        if(index<numbers.length){
            return DFS(index+1,numbers,res+numbers[index],target)+DFS(index+1,numbers,res-numbers[index],target);
        }else {
            if(res==target){
                return 1;
            }else {
                return 0;
            }
        }

    }
}
