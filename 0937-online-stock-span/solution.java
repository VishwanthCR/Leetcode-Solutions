class StockSpanner {
    public Deque<int[]> deq;
    public StockSpanner() {
        deq=new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span=1;
        while(!deq.isEmpty() && deq.peek()[0] <= price) {
            span += deq.pop()[1];
        }
        deq.push(new int[] {price,span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
