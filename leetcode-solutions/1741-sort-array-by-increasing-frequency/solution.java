class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Integer[] temp= new Integer[nums.length];
        for(int i =0;i<nums.length;i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp, (a,b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);
            if(freqA != freqB) return Integer.compare(freqA,freqB);
            else return Integer.compare(b,a);
        });
        for(int i =0;i<nums.length;i++) {
            nums[i] = temp[i];
        }
        return nums;
    }
}
