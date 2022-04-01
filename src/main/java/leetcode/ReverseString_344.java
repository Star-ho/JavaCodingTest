package leetcode;

public class ReverseString_344 {
    public void reverseString(char[] s) {
        char[] reverseS=new char[s.length];
        int len=s.length/2;
        for(int i=0;i<len;i++){
            char temp=s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=temp;
        }
    }
}
