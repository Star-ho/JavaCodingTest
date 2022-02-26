package codility.caterpillarMethod;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class CountTriangles {
    public int solution(int[] A) {
        int answer=0;
        Arrays.sort(A);
        // for(int a:A){
        //     System.out.print(a+" ");
        // }
        // System.out.println();
        int a=0,b=1,c=2;
        int tempEnd=A.length-1;
        while(a<A.length-2){//a가 끄점 도달할떄까지
            if(A[a]+A[b]>A[c]){//삼각형
                if(c<tempEnd){
                    c++;
                }else{
                    // System.out.println(a+" "+b+" "+c+" "+(c-b));
                    answer+=c-b;
                    b++;
                    tempEnd=A.length-1;
                    if(c<tempEnd&&b==c){
                        c++;
                    }
                }
            }else{
                c--;
                tempEnd=c;
                if(b==c&&c<A.length-2){
                    b++;
                    c=b+1;
                    tempEnd=A.length-1;
                }

            }
            if(b==c){
                a++;
                b=a+1;
                c=b+1;
                tempEnd=A.length-1;
            }
        }
        return answer;
    }
}