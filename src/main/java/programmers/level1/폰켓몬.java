package programmers.level1;

import java.util.Arrays;

public class 폰켓몬 {
    public int solution(int[] nums) {
        int maxNum=nums.length/2;
        int distinctNum = Arrays.stream(nums).distinct().toArray().length;
        return Math.min(maxNum, distinctNum);
    }
}
