class Solution {
    public int myAtoi(String s) {
        int i=0;
        while(i<s.length() && s.charAt(i) == ' ') i++;
        int sign =1;
        if(i<s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = (s.charAt(i)== '-') ? -1 : 1;
            i++;
        }
        return helper(s,i,0L,sign);
    }
    public int helper(String s,int i,long num,int sign){
        while(i>=s.length() || !Character.isDigit(s.charAt(i))){
            return (int)(sign*num);
        }
        num = num*10 + (s.charAt(i) - '0');
        if(sign*num <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if(sign*num >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return helper(s,i+1,num,sign);
    }
}
