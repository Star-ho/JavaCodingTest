package hackerRank;

import java.util.*;

public class JavaSubString {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        String[] aArr=A.split("");
        for(int i=0;i<aArr.length;i++){
            if(!aArr[i].equals(aArr[aArr.length-1-i])){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
        return;

    }
}



