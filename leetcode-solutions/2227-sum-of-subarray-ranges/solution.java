class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrMax(nums) - sumSubarrMin(nums);
    }

    public long sumSubarrMin(int[] nums) {
        int n=nums.length;
        int[] psee = findPSEE(nums);
        int[] nse = findNSE(nums);
        long sum=0;
        for(int i=0;i<n;i++) {
            int left = i-psee[i];
            int right = nse[i] - i;
            long freq = left * right * 1L;
            long val = (freq * nums[i]);
            sum+=val;
        }
        return sum;
    }

    public int[] findPSEE(int[] nums) {
        int n=nums.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for(int i=0;i<n;i++) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            res[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return res;
    }

    public int[] findNSE(int[] nums) {
        int n=nums.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for(int i=n-1;i>=0;i--) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) st.pop();
            res[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return res;
    }

    public long sumSubarrMax(int[] nums) {
        int n=nums.length;
        int[] pgee = findPGEE(nums);
        int[] nge = findNGE(nums);
        long sum=0;
        for(int i=0;i<n;i++) {
            int left = i-pgee[i];
            int right = nge[i] - i;
            long freq = left * right * 1L;
            long val = (freq * nums[i]);
            sum+=val;
        }
        return sum;
    }

    public int[] findPGEE(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            res[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return res;
    }

    public int[] findNGE(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n-1; i>=0; i--) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            res[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return res;
    }
}
