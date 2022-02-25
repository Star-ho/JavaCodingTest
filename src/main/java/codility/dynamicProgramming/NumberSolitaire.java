package codility.dynamicProgramming;

class NumberSolitaire {
    public int solution(int[] A) {
        int[] resArr=new int[A.length];
        resArr[0]=A[0];
        for(int i=1;i<A.length;i++){
            int max=Integer.MIN_VALUE;
            if(i<7){
                for(int j=0;j<i;j++){
                    max=Math.max(max,resArr[j]);
                }
            }else{
                for(int j=i-6;j<i;j++){
                    max=Math.max(max,resArr[j]);
                }
            }
            resArr[i]=max+A[i];
        }
        // for(int i : resArr){
        //     System.out.println(i);
        // }
        return resArr[resArr.length-1];
    }
}