class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double [][] cars = new double[n][2];

        for(int i=0; i < n; i++){
            //Mark positions of cars
            cars[i][0] = position[i];
            //How much time any single car take to reach to the destination 
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        //sort the given cars based on current position of given cars
        Arrays.sort(cars, (a, b) -> Double.compare(b[0] , a[0]));

        //To keep track of fleet
        int count = 0;
        double prevTime = 0;

        for(double[] car : cars){
            //fleet created so increase the count
            if(car[1] > prevTime){
                count++;
                prevTime = car[1];
            }
        }

        return count;
    }
}