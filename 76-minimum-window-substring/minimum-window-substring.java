class Solution {
    public String minWindow(String s, String t) {
        int map[]= new int[128];
        for(char c: t.toCharArray()) {
            map[c]++;
        }
        int left=0;
        int minlen=Integer.MAX_VALUE;
        int minstart=0;
        int right=0;
        int count = t.length();
        while(right<s.length()) {
            char curr = s.charAt(right);
            if(map[curr] > 0) {
                count--;
            }
            map[curr]--;
            right++;
            while(count==0) {
                char currLeft = s.charAt(left);
                if(right-left<minlen) {
                    minlen= right-left;
                    minstart= left;
                }
                map[currLeft]++;
                if(map[currLeft] >0) {
                    count++;
                }
                left++;
            }
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(minstart,minstart+minlen);
    }
}