import java.math.BigInteger;
import java.util.*;

public class Programmers2 {
    public static void main(String[] args) {
        String[] phone_book={"456","123", "112","11234", "789"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        List<String> phone_book_String= Arrays.asList(phone_book);
        List<BigInteger> phone_book_Integer=new ArrayList<BigInteger>();
        for(String i : phone_book_String)phone_book_Integer.add(new BigInteger(i));
        Collections.sort(phone_book_Integer);
        phone_book_String=new ArrayList<String>();
        for(BigInteger i : phone_book_Integer)phone_book_String.add(i.toString());

        for(int i=0;i<phone_book.length;i++){
            for(int j=i+1;j< phone_book.length;j++){
                if(phone_book[j].startsWith(phone_book[i])){
                    answer=false;
                    break;
                }
            }
        }
        return answer;
    }

}
