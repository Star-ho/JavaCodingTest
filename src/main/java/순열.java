import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 순열 {
    public static void main(String[] arg){
        int[] numArr={1,2,3,4};
        Boolean[] booleanArr=new Boolean[numArr.length];
        Arrays.fill(booleanArr,false);
        List<List<Integer>> resList=new ArrayList<>();

        for(int i=0;i<numArr.length;i++) {
            booleanArr[i]=true;
            resList.addAll(permutation(numArr,new ArrayList<>(Arrays.asList(numArr[i])),booleanArr));
            booleanArr[i]=false;
        }
        resList.forEach(System.out::println);
    }

    public static List<List<Integer>> permutation(int[] numArr,List<Integer> resList,Boolean[] booleanArr){
        if(Arrays.stream(booleanArr).reduce(((aBoolean, aBoolean2) -> aBoolean&&aBoolean2)).get()){
            List<List<Integer>> newResList = new ArrayList<>();
            newResList.add(resList.stream().map(i->i).collect(Collectors.toList()));

            return newResList;
        }
        List<List<Integer>> newResList=new ArrayList<>();
        for (int i=0;i<numArr.length;i++){
            if (!booleanArr[i]){
                booleanArr[i]=true;
                resList.add(numArr[i]);
                newResList.addAll(permutation(numArr,resList,booleanArr));
                resList.remove(resList.size()-1);
                booleanArr[i]=false;
            }
        }
        return newResList;
    }
}
