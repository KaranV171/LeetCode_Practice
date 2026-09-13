class Solution {
    private void f(int idx, int[] arr ,List<List<Integer>> ans, List<Integer> list, int target){
        if(idx==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(list));
            }
            return;
            
        }
        if(arr[idx]<=target){
            list.add(arr[idx]);
            f(idx,arr,ans,list,target-arr[idx]);
            list.remove(list.size()-1);
        }

        f(idx+1,arr,ans,list,target);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        f(0,candidates,ans,new ArrayList(),target);
        return ans;
    }
}