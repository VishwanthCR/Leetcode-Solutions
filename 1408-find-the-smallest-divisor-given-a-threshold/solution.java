class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
      int max=Arrays.stream(nums).max().getAsInt();
      int low=1;
      int high=max;
      if(nums.length > threshold) return -1;
      while(low<=high){
        int mid=low +(high-low)/2;
        if(sumByDiv(nums,mid) <= threshold){
            high=mid-1;
        }
        else{
            low=mid+1;
        }
      }
      return low;
    }
    public int sumByDiv(int[] nums,int d){
        int sum=0;
        for(int num:nums){
            sum+= Math.ceil((double)num/d);
        }
        return sum;
    }
}
