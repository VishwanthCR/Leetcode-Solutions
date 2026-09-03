class Solution {
    public int longestConsecutive(int[] nums) {
        int longest =1;
        Set<Integer> s=new HashSet<>();
        int n=nums.length;
        if(n==0){
            return n;
        }
        for(int i=0;i<n;i++){
            s.add(nums[i]);
        }
        for(int item : s){
            if(!s.contains(item-1)){
                int count=1;
                while(s.contains(item+1)){
                    item++;
                    count++;
                }
                longest = Math.max(count,longest);
            }
        }
        return longest;
    }
}
