import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        // Step 1: Populate the Frequency Map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Extract and sort only the unique elements
        List<Integer> uniqueNums = new ArrayList<>(freqMap.keySet());
        Collections.sort(uniqueNums);
        
        int maxFrequency = 0;
        
        // Step 3: Iterate through each unique number as the "target"
        for (int i = 0; i < uniqueNums.size(); i++) {
            int target = uniqueNums.get(i);
            int currentFreq = freqMap.get(target);
            long remainingK = k;
            
            // Look backward to smaller unique numbers to see if we can upgrade them
            for (int j = i - 1; j >= 0; j--) {
                int smallerNum = uniqueNums.get(j);
                int countOfSmaller = freqMap.get(smallerNum);
                
                // Cost to upgrade ONE 'smallerNum' to 'target'
                long costPerElement = (long) target - smallerNum;
                
                // Total cost to upgrade ALL available copies of 'smallerNum'
                long totalCostNeeded = costPerElement * countOfSmaller;
                
                if (remainingK >= totalCostNeeded) {
                    // We have enough k to upgrade all copies of this element
                    currentFreq += countOfSmaller;
                    remainingK -= totalCostNeeded;
                } else {
                    // We can only afford to upgrade a partial amount of them
                    long partialCount = remainingK / costPerElement;
                    currentFreq += partialCount;
                    break; // No more k left to check even smaller numbers
                }
            }
            
            // Track the best result found
            maxFrequency = Math.max(maxFrequency, currentFreq);
        }
        
        return maxFrequency;
    }
}
