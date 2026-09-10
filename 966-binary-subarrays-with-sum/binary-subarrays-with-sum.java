class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums,goal) - atMost(nums,goal-1);
    }
    public int atMost(int[] nums, int goal) {
        int count=0;
        int left=0;
        int currSum =0;
        if(goal<0) return 0;
        for(int right=0;right<nums.length;right++) {
            currSum += nums[right];
            while(currSum > goal) {
                currSum -= nums[left];
                left++;
            }
            count += right-left+1;
        }
        return count;
    }
}