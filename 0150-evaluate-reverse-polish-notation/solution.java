class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for(String token : tokens) {
            if(token.equals("+")) st.push(st.pop() + st.pop());
            else if(token.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b-a);
            }
            else if(token.equals("*")) st.push(st.pop()*st.pop());
            else if(token.equals("/")) {
                int a = st.pop();
                int b=st.pop();
                st.push(b/a);
            }
            else st.push(Integer.parseInt(token));
        }
        return st.pop();
    }
}
