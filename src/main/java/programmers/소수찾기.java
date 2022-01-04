package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 소수찾기 {
    public static void main(String[] arg){
        System.out.println(solution("17"));
    }

    public static int solution(String numbers) {
        int answer = 0;
        List<String >  numList=new ArrayList<>();
        var a= numbers.split("");
        System.out.println(Arrays.toString(a));


        return answer;
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

}
