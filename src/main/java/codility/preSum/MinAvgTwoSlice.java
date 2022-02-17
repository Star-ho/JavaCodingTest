package codility.preSum;

/**
 * 너무 코드로 풀려고 해서 망했음,
 * 수학적 지식이 필요한 문제
 * 너무 코드로 풀려고 하지 말것,
 * 수학으로 되는것도 있으니 코드만 너무 생각하지 말자
 */

public class MinAvgTwoSlice {
    public int solution(int[] A) {
        int aLen=A.length;
        int minIndex=0;
        double minValue=Integer.MAX_VALUE;
        for(int i=0;i<aLen;i++){
            int divieNum=2;
            int counter=A[i];
            for(int j=i+1;j<aLen;j++){
                counter+=A[j];
                if(counter/(divieNum*1.0)<minValue){
                    minValue=counter/(divieNum*1.0);
                    minIndex=i;
                }
                divieNum++;
                if(divieNum==4){
                    break;
                }
            }
        }

        return minIndex;
    }
}
