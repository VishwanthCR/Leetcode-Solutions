class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();
        for(int[] num : intervals){
            if(result.isEmpty() || result.get(result.size()-1)[1] < num[0]){
                result.add(num);
            }
            else{
                int[] last = result.get(result.size()-1);
                last[1] = Math.max(last[1],num[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
