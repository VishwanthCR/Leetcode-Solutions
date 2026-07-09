class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int count1=0;
        int count2=0;
        int el1 = Integer.MIN_VALUE;
        int el2= Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(count1==0 && el2 != nums[i]){
                count1++;
                el1=nums[i];
            }
            else if(count2==0 && el1 !=nums[i]){
                count2++;
                el2=nums[i];
            }
            else if(nums[i] == el1){
                count1++;
            }
            else if(nums[i] == el2){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

        count1=0; count2=0;
        for(int i =0;i<n;i++){
            if(nums[i]==el1){
                count1++;
            }
            if(nums[i]==el2){
                count2++;
            }
        }

        List<Integer> result= new ArrayList<>();
        int val = n/3 +1;
        if(count1>=val) result.add(el1);
        if(count2>=val) result.add(el2);
        return result;
    }
}
