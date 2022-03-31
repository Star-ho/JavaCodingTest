package forLineCodingTest;

import java.util.Arrays;
import java.util.Comparator;

//18분
public class Number1 {
    public static void main(String[] arg){
        System.out.println(solution(4578,new int[]{1, 4, 99, 35, 50, 1000})+" "+2308);
        System.out.println(solution(1999,new int[]{2, 11, 20, 100, 200, 600})+" "+2798);

    }

    public static int solution(int money, int[] costs) {
        double moneyD=money;
        double answer=0;
        int[] coin= {1,5,10,50,100,500};
        double[][] benefit=new double[6][];
        for(int i=0;i<costs.length;i++){
            benefit[i]=new double[]{coin[i],costs[i],coin[i]/(costs[i]*1.0)};
        }
        Arrays.sort(benefit, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return (int)((o2[2]-o1[2])*10000);
            }
        });
        for(int i=0;i<benefit.length;i++){
            answer = answer +  (int) (moneyD / benefit[i][0])*benefit[i][1];
            moneyD=moneyD%benefit[i][0];
            if(moneyD==0)break;
        }
        for(double[] i:benefit) System.out.print(Arrays.toString(i)+" ");
        return (int)answer;
    }
}
