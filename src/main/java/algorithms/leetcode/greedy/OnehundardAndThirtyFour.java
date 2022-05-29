package algorithms.leetcode.greedy;

public class OnehundardAndThirtyFour {
    public static void main(String[] args) {
        int[] gas = new int[]{2,3,4};
        int[] cost = new int[]{3,4,3};

        int[] gas2  = new int[]{4,5,2,6,5,3};
        int[] cost2 = new int[]{3,2,7,3,2,9};
        OnehundardAndThirtyFour onehundardAndThirtyFour = new OnehundardAndThirtyFour();
        onehundardAndThirtyFour.canCompleteCircuit(gas2, cost2);
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for(int i=0; i<len; ) {
            int add = gas[i] - cost[i];
            if(add < 0 ) {
                i++;
                continue;
            }
            int count = 1;
            int sum = add;
            int j = i;
            while (count<gas.length && sum>=0) {
//                System.out.println(j);
                j = j+1==gas.length?0:j+1;
                count++;
                sum += gas[j]-cost[j];
            }
            if(sum<0) {
                i = j+1>i?j+1:len;
            }else {
                return i;
            }
        }

        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        for(int i=0; i<len; i++) {
            int gasSum = 0;
            int index = i;
            while (gasSum + gas[index]- cost[index] >=0) {
                gasSum += gas[index] - cost[index];
                index = (index+1) % len;

                if(index == i) {
                    return i;
                }
            }
            if(index <i) {
                return -1;
            }
            i = index;
        }
        return -1;
    }

}
