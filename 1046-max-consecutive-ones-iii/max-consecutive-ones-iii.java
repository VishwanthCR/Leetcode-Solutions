class Solution {
    public int longestOnes(int[] nums, int k) {
        int zero=0;
        int maxLen =0;
        int left=0;
        for(int right=0;right<nums.length;right++) {
            if(nums[right] == 0) zero++;
            if(zero > k) {
                if(nums[left] == 0) {
                    zero--;
                }
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}