package codility.primeAndCompositeNumbers;

class MinPerimeterRectangle {
    public int solution(int N) {
        int nSqrt=(int)Math.sqrt(N);
        for(int i=nSqrt;i>0;i--){
            if(N%i==0){
                int j=N/i;
                // System.out.println(i+" "+j);
                return (i+j)*2;
            }
        }
        return 0;
    }
}