class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int i=1;
        int count =0;
        while(count<k){
            if(!set.contains(i)){
                count++;
            }
            i++;
        }
        return i-1;
    }
}