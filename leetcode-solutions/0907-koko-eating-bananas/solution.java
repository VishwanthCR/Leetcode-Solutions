class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = Arrays.stream(piles).max().getAsInt();
        int low=1;
        int high=maxVal;
        int ans=maxVal;
        while(low<=high){
            int mid= low+(high-low)/2;
            long totalHours= calculateHours(piles,mid);
            if(totalHours<=h){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public long calculateHours(int[] piles,int speed){
        long totalHours=0;
        for(int banana:piles){
            totalHours+= (long)Math.ceil((double)banana/speed);
        }
        return totalHours;
    }
}
