class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        int totSubsets=1<<n;
        List<List<Integer>> ans = new ArrayList<>();
        for(int num=0;num<totSubsets;num++){
            List<Integer> newSub = new ArrayList<>();
            for(int i=0;i<n;i++){
                if((num & (1<<i)) != 0){
                    newSub.add(nums[i]);
                }
            }
            ans.add(newSub);
        }
        return ans;
    }
}
