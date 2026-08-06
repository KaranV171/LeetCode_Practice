class Solution {
    private int product(int temp){
        int mul =1;
        while(temp!=0){
            int r = temp%10;
            mul*=r;
            temp = temp/10;
        }
        return mul;
    }
    public int smallestNumber(int n, int t) {
        int temp = n;
        while(true){
            int pro = product(temp);
            if(pro%t==0){
                break;
            }
            temp++;
        }
        return temp;
    }
}