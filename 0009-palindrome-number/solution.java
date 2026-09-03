class Solution {
    public boolean isPalindrome(int x) {
       int original = x;
       int rev=0;
       if(x<0){
        return false;
       }
       while(x!=0){
        int temp = x%10;
        x=x/10;
        rev = rev*10+temp;
       }
       return original == rev;
    }
}
