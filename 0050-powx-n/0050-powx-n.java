class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N<0){
            N=-N;
            x=1/x;
        }
        double pow =1;
        while(N!=0){
            if((N&1)!=0){
                pow=pow*x;
            }
            x=x*x;
            N>>>=1;
        }
        return pow;
    }
}