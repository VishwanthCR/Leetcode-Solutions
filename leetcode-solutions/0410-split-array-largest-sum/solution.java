class Solution {
    public int splitArray(int[] nums, int k) {
        int low= Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        while(low<=high){
            int mid = low+(high-low)/2;
            int partitions= countSub(nums,mid);
            if(partitions>k) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
    public int countSub(int[] nums, int maxSum){
        int subArr = 1;
        int n=nums.length;
        int subSum=0;
        for(int i=0;i<n;i++){
            if(subSum + nums[i] <= maxSum) subSum+=nums[i];
            else{
                subArr++;
                subSum = nums[i];
            }
        }
        return subArr;
    }
}
