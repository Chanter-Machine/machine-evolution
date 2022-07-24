package algorithms.leetcode.simulator;

public class ElevenEightyFour {
    public static void main(String[] args) {
        ElevenEightyFour elevenEightyFour = new ElevenEightyFour();
//        int[] distance = new int[] {1,2,3,4};
//        int start = 0;
//        int desination = 3;

        int[] distance = new int[] {7,10,1,12,11,14,5,0};
        int start = 2;
        int desination = 0;

        int res = elevenEightyFour.distanceBetweenBusStops(distance, start, desination);
        System.out.println(res);
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start>destination) {
            int tmp = destination;
            destination = start;
            start = tmp;
        }

        int clockwise = 0;
        int counterClickwise = 0;
        for(int i=start; i<destination; i++) {
            clockwise += distance[i];
        }
        for(int i=0; i<start; i++) {
            counterClickwise += distance[i];
        }
        for(int i=destination; i<distance.length;i++) {
            counterClickwise+= distance[i];
        }

        return Math.min(counterClickwise, clockwise);
    }

}
