package algorithms.leetcode.greedy;

import java.util.ArrayList;

public class FourteenFourteen {
    public static void main(String[] args) {
        FourteenFourteen fourteenFourteen = new FourteenFourteen();
        fourteenFourteen.findMinFibonacciNumbers(7);
    }

    public int findMinFibonacciNumbers(int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        int one = 1;
        int two = 1;
        arr.add(one);
        arr.add(two);
        while (true) {
            int tmp = one + two;
            if(tmp>k) {
                break;
            }
            arr.add(tmp);
            one = two;
            two = tmp;
        }

        int count = 0;
        int right = arr.size()-1;
        while (k>0) {
            int index = findRightBound(arr, 0, right, k);
            if(index == -1) {
                return -1;
            }
            count++;
            k -= arr.get(index);
            right = index;
        }
        return count;
    }

    private int findRightBound(ArrayList<Integer> arr, int left, int right, int target) {
        int mid = 0;
        while (left<right) {
            mid = (left+right +1)/2;
            if(arr.get(mid)> target) {
                right = mid-1;
            }else {
                left = mid;
            }
        }
        if (arr.get(left) > target) {
            return -1;
        }
        return left;
    }
}
