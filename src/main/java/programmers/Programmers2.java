package programmers;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Programmers2 {
    public static void main(String[] args) {
        String[] phone_book={"99456456456456456456","123", "112", "789"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        HashSet<String> hashSet = (HashSet<String>) Arrays.stream(phone_book).collect(Collectors.toSet());
        var a =Arrays.asList(1);
        for (String key : hashSet)
            for (int j = 1; j <= key.length() - 1; j++) {

                if (hashSet.contains(key.substring(0, j))) return false;
            }
        return true;
    }

}
