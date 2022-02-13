import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;


public class TemplateBackup {
    public static void main(String[] arg){
        System.out.println(solution(new int[]{1, 5, 2, 6, 3, 7, 4},new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int i=0;
        var a=0;
        while(i<10){
            try {
                System.out.println("try block");
                System.out.println(1/0);
                break;
            }catch (Exception e){
                System.out.println("Catch block");
                i++;
            }
        }

        return new int[]{1, 5, 2, 6, 3, 7, 4};

    }
}

