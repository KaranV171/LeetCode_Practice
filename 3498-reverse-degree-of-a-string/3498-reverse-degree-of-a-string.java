class Solution {
    public int reverseDegree(String s) {
        int sum =0;
        int i =1;
        for(char ch : s.toCharArray()){
            int idx =('z' - ch +1);
            int prod = idx*i;
            i++;
            sum+=prod;
        }
        return sum;
    }
}