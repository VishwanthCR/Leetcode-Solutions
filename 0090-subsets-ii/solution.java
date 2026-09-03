class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        Arrays.sort(nums);
        findSubset(0,nums,ds,res);
        return res;
    }
    public void findSubset(int index,int[] arr,List<Integer>ds,List<List<Integer>>res){
        res.add(new ArrayList<>(ds));
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i] == arr[i-1]) continue;
            ds.add(arr[i]);
            findSubset(i+1,arr,ds,res);
            ds.remove(ds.size()-1);
        }
    }
}
