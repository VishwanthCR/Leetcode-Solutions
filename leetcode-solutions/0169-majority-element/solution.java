class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int max_freq =0;
        for(var entry : map.entrySet()){
            if(entry.getValue() > Math.floor(n/2)){
                max_freq = entry.getKey();
            }
        }
        return max_freq;

    }
}
