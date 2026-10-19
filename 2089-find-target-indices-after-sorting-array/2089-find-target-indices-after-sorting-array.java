class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int smaller = 0;
        int equal = 0;
        for(int n: nums){
            if(n<target){
                smaller++;
            }
            if(target==n){
                equal++;
            }
        }

        for(int i=0;i<equal;i++){
            list.add(smaller+i);
        }
        return list;
    }
}