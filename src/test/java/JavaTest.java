import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class JavaTest {

    //자바 배열 자르기
//    @Test
    void sliceArray(){
        var arr=new int[]{1,2,3,4,5};
        var temp=Arrays.copyOfRange(arr,1,3);
        System.out.println(Arrays.toString(temp));

    }

    //원시값과 래퍼 비교시 값으로 비교
//    @Test
    void integer(){
        int a=1;
        Integer b= new Integer(1);
        assertEquals(a,b);

    }

    //Array.equals는 해당 내용이 같은지
    //equals는 같은 객체인지 확인
//    @Test
    void ArrayAndListAndCollection(){
        //intType
        var intArr=new int[]{1,2,3,4,5};
        var intgerList= Arrays.asList(1,2,3,4,5);
        var strArr=new String[]{"123","456","789"};
        var strList=Arrays.asList("123","456","789");

        var intArrayToList=(ArrayList<Integer>)Arrays.stream(intArr).boxed().collect(Collectors.toList());
        assertTrue(intgerList.equals(intArrayToList));

        var strArrToList=Arrays.asList(strArr);
        assertTrue(strList.equals(strArrToList));

        var intListToArray= intgerList.stream().mapToInt(i->i).toArray();
       assertTrue(Arrays.equals(intArr,intListToArray));

        var strListToArray=strList.toArray();
        assertTrue(Arrays.equals(strListToArray,strArr));//??
//        System.out.println(strListToArray.getClass().isArray());//true긴함

    }

//    @Test
    void intArrayMapAndReduce(){
        var arr = new int[]{1,2,3,4,5};
        var mapTest=Arrays.stream(arr).map(i->i+1).toArray();
//        System.out.println(Arrays.toString(Arrays.stream(arr).map(i->i+1).toArray()));//출력
        assertTrue(Arrays.equals( mapTest, new int[]{2,3,4,5,6} ));

        var reduceTest= Arrays.stream(arr).reduce((sum,n)->sum+=n);//초기값 없는거 결과가 Optional객체
        var reduceTest2= Arrays.stream(arr).reduce(0,(sum,n)->sum+=n);//초기값 있는거
//        System.out.println(reduceTest2);
//        assertEquals(reduceTest,(new OptionalInt[15]).get());//비교는 잘...
        assertEquals(reduceTest2,15);

        var filterTest= Arrays.stream(arr).filter(i->i>2).toArray();
//        System.out.println(Arrays.toString(filterTest));
        assertTrue(Arrays.equals( filterTest, new int[]{3,4,5} ));
    }

    @Test
    void sortTest(){
        //참고 https://www.baeldung.com/java-sorting-arrays
        int[] intArr=new int[]{5,1,2,4,3};
        var stringArr = new String[] {   "learning", "java", "with", "baeldung" };
        var doubleIntArr=new int[][]{{1, 9},{0, 3}, {2, 6}};

        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));

        intArr=new int[]{5,1,2,4,3};
        var reversOrder=IntStream.of(intArr).boxed().sorted(Comparator.reverseOrder()).mapToInt(i->i).toArray();
        System.out.println(Arrays.toString(reversOrder));


        Arrays.sort(doubleIntArr,(a,b)->b[0]-a[0]);//이차원 배열 정렬
        for(var i : doubleIntArr){
            System.out.println(Arrays.toString(i));
        }
    }
}