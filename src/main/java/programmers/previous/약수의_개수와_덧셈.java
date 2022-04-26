package programmers.previous;

public class 약수의_개수와_덧셈 {
    public int solution(int left, int right) {
        int answer = 0;
        int[] numArr = new int[right+1];
        for(int i=1;i<numArr.length;i++){
            for(int j=i;j<numArr.length;j+=i){
                if(j%i==0){
                    numArr[j]++;
                }
            }
        }
        for(int i=left;i<=right;i++){
            if(numArr[i]%2==0){
                answer+=i;
            }else{
                answer-=i;
            }
        }

        // System.out.println(Arrays.toString(numArr));

        return answer;
    }
}
