class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> nums=new ArrayList<>();
        findNum(n,1,k,nums,res);
        return res;
    }
    public void findNum(int target,int start,int k,List<Integer>nums,List<List<Integer>>res){
        if(target==0 && nums.size()==k){
            res.add(new ArrayList(nums));
            return;
        }
        for(int i=start;i<=9;i++){
            if(i<=target){
                nums.add(i);
                findNum(target-i,i+1,k,nums,res);
                nums.remove(nums.size()-1);
            }
            else break;
        }
    }
}
