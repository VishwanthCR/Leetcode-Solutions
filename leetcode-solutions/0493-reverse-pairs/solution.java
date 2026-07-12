class Solution {
    public int reversePairs(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int low=0;
        int high=nums.length-1;
        return mergeSort(nums,low,high);
    }
    public int mergeSort(int[] nums,int low,int high){
        if(low>=high) return 0;
        int mid= (low+high)/2;
        int count=0;
        count+= mergeSort(nums,low,mid);
        count+= mergeSort(nums,mid+1,high);
        count+= countPairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        return count;
    }
    public int countPairs(int[] nums,int low,int mid,int high){
        int right=mid+1;
        int count=0;
        for(int i=low;i<=mid;i++){
            while(right<=high && (long) nums[i] > (long) 2*nums[right]) right++;
            count+= (right - (mid+1));
        }
        return count;
    }
    public void merge(int[] nums,int low,int mid,int high){
        List<Integer> temp = new ArrayList<>();
        int right=mid+1;
        int left=low;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else{
                temp.add(nums[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(nums[left++]);
        }
        while(right<=high){
            temp.add(nums[right++]);
        }
        for(int i=low;i<=high;i++){
            nums[i]=temp.get(i-low);
        }
    }
}
