package algorithms.leetcode.sort;

import java.util.Arrays;

public class EighthundardAndTwentyFive {
    public static void main(String[] args) {
        int[] arr = new int[] {108,115,5,24,82};
//        int[] arr = new int[] {16,16};
        EighthundardAndTwentyFive eighthundardAndTwentyFive = new EighthundardAndTwentyFive();
        eighthundardAndTwentyFive.numFriendRequests(arr);
    }

    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int count = 0;
        int left = 0, right = 0;
        for(int i=0; i<ages.length; i++) {
            if (ages[i] < 15) {
                // 这一步不可减少，
                continue;
            }
            while (ages[left]<=0.5*ages[i]+7) {
                left++;
            }
            while (right+1<ages.length && ages[right+1]<=ages[i]) {
                right++;
            }
            count += right-left;
        }
        return count;
    }

}
