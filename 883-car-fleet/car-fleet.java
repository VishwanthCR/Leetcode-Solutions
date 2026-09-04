class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for(int i =0;i<n;i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars,(a,b) -> Double.compare(b[0],a[0]));
        int fleetCount=0;
        double maxTime =0.0;
        for(int i=0;i<n;i++) {
            double curPos = cars[i][0];
            double curSpeed = cars[i][1];
            double targetTime = (target - curPos)/curSpeed;
            if(targetTime>maxTime){
                fleetCount++;
                maxTime = targetTime;
            }
        }
        return fleetCount;
    }
}