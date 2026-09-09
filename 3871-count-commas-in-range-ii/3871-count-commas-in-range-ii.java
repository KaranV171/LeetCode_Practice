class Solution {
    public long countCommas(long n) {
        if(n<=999){
            return 0;
        }
        long count = 0;
        long start = 1000;
        while(start<=n){
            count +=(n-start+1);
            start*=1000;
        }
        return count;

    }
}