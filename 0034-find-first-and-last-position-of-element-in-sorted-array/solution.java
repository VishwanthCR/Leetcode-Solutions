class Solution {
    public int[] searchRange(int[] nums, int target) {
       int[] result = new int[] {-1,-1};
       result[0]= findFirstPos(nums,target);
       result[1]= findLastPos(nums,target);
       return result;
    }
    public int findFirstPos(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        int first=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid] >= target){
                if(arr[mid] == target) first= mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return first;
    }
    public int findLastPos(int[] arr, int target){
        int low=0;
        int high=arr.length-1;
        int last=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid] <= target){
                if(arr[mid] == target) last =mid;
                low=mid+1;
            }
            else high =mid-1;
        }
        return last;
    }
}
