package codility.euclideanAlgorithm;


class ChocolatesByNumbers {
    public int solution(int N, int M) {
        int gcb=gcb(Math.max(N,M),Math.min(N,M));
        return N/gcb;
    }

    int gcb(int a,int b){
        if(a%b==0){
            return b;
        }else{
            return gcb(b,a%b);
        }
    }

}
