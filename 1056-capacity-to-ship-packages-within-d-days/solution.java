class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=Arrays.stream(weights).max().getAsInt();
        int high=Arrays.stream(weights).sum();
        while(low<high){
            int mid =low+(high-low)/2;
            if(calDays(weights,mid) <= days) high=mid;
            else low=mid+1;
        }
        return low;
    }
    public int calDays(int[] weights, int capacity){
        int days=1;
        int currCapacity=0;
        for(int w:weights){
            if(currCapacity + w > capacity){
                days++;
                currCapacity=w;
            }
            else currCapacity+=w;
        }
        return days;
    }
}
