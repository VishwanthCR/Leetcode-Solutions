class Solution {
    public int beautySum(String s) {
       int sum=0;
       int n=s.length();
       for(int i=0;i<n;i++){
        Map<Character,Integer> freq = new HashMap<>();
        for(int j=i;j<n;j++) {
            freq.put(s.charAt(j),freq.getOrDefault(s.charAt(j),0)+1);
            int maxi = Integer.MIN_VALUE;
            int mini= Integer.MAX_VALUE;
            for(int val : freq.values()){
                maxi = Math.max(val,maxi);
                mini = Math.min(val,mini);
            }
            sum+=(maxi-mini);
        }
       } 
       return sum;
    }
}
