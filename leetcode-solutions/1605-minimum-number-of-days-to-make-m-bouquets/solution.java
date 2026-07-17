class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long totalFlowers = (long)m*k;
        if(totalFlowers>bloomDay.length) return -1;
        int min=Arrays.stream(bloomDay).min().getAsInt();
        int max=Arrays.stream(bloomDay).max().getAsInt();
        int low=min;
        int high=max;
        int result=-1;
        while(low<=high){
            int mid=low +(high-low)/2;
            if(isPossible(bloomDay,mid,m,k)){
                result=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return result;
    }
    public boolean isPossible(int[] bloomDay,int day,int m,int k){
        int count=0;
        int bouquets=0;
        for(int bloom: bloomDay){
            if(bloom <= day){
                count++;
                if(count==k){
                    bouquets++;
                    count=0;
                }
            }
            else{
                count =0;
            }
        }
        return bouquets>=m;
    }
}
