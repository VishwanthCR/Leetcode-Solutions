class Solution {
    public int maxDepth(String s) {
        int para=0;
        int result=0;
        for(char ch : s.toCharArray()){
            if(ch == '(') para++;
            else if(ch == ')') para--;
            result= Math.max(result,para);
        }
        return result;
    }
}
