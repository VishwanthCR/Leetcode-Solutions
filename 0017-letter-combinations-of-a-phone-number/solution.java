class Solution {
    public final String[] map;
    public Solution(){
        this.map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0) return res;
        helper(digits,0,res,"");
        return res;
    }
    public void helper(String digits,int index,List<String>res,String curr){
        if(index==digits.length()){
            res.add(curr);
            return;
        }
        String s=map[digits.charAt(index) - '0'];
        for(int i=0;i<s.length();i++){
            helper(digits,index+1,res,curr+s.charAt(i));
        }
    }
}
