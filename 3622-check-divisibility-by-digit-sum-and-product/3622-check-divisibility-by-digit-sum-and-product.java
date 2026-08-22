class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int prod = 1;
        int sum =0;
        while(n!=0){
            int r = n%10;
            n=n/10;
            sum+=r;
            prod*=r;
        }
        int totalsum = prod + sum;
        return (temp%totalsum)==0;
    }
}