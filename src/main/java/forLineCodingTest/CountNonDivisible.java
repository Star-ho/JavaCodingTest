package forLineCodingTest;

import java.sql.SQLOutput;
import java.util.*;

public class CountNonDivisible {
    public static void main(String args[]){
        solution(new int[]{3, 1, 2, 3, 6});
    }

    public static int[] solution(int[] A) {
        int[] counter=new int[2*A.length+1];
        int[] answer=new int[A.length];
        for(int a:A){
            counter[a]++;
        }
        int[] arrayF=getArrayF(counter.length);
        int[] sortedA=Arrays.stream(A).distinct().sorted().toArray();
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<sortedA.length;i++){
            List<Integer> fac=fatorial(arrayF,sortedA[i]);
            int n=0;
        }

        return new int[]{1};
    }

    public static List<Integer> fatorial(int[] arrayF,int i){
        List<Integer> resList=new ArrayList<>();
        while(arrayF[i]!=0){
            resList.add(i);
            if(i!=i/arrayF[i])resList.add(arrayF[i]);
            i=i/arrayF[i];
        }
        if(resList.get(resList.size()-1)!=i)
            resList.add(i);
        return resList;
    }

    public static int[] getArrayF(int n){
        int[] arrayF=new int[n];
        int i=2;
        int nSqrt=(int)Math.sqrt(n);
        while(i<=nSqrt){
            if(arrayF[i]==0){
                int k=i*i;
                while(k<=n){
                    if(arrayF[k]==0)
                        arrayF[k]=i;
                    k+=i;
                }
            }
            i++;
        }
        return arrayF;
    }
}
