package algorithms.leetcode.trie;

public class FivehundardAndFiftySix {
    public static void main(String[] args) {
        FivehundardAndFiftySix fivehundardAndFiftySix = new FivehundardAndFiftySix();
//        int res = fivehundardAndFiftySix.nextGreaterElement(963852);
//        int res = fivehundardAndFiftySix.nextGreaterElement(1234);
//        int res = fivehundardAndFiftySix.nextGreaterElement(2147483486);
        int res = fivehundardAndFiftySix.nextGreaterElement(12222333);
        System.out.println(res);
    }
    public int nextGreaterElement(int n) {
        if(n<10 || n== Integer.MAX_VALUE) {
            return -1;
        }
        String N = Integer.toString(n);
        char[] arr =  N.toCharArray();

        int len = arr.length;
        int exception = -1;
        for(int i=len-1; i>0; i--) {
            if(arr[i-1] >= arr[i]) {
                continue;
            }
            exception = i-1;
            break;
        }
        if( exception == -1) {
            return -1;
        }
        int toSwitch = len-1;
        for(int i=len-1; i>= exception+1; i--) {
            if(arr[i]>arr[exception]) {
                toSwitch = i;
                char tmp = arr[exception];
                arr[exception] = arr[toSwitch];
                arr[toSwitch] = tmp;
                break;
            }
        }
        reverse(arr, exception+1, len-1);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len; i++) {
            sb.append(arr[i]);
        }

        long ans = Long.parseLong(sb.toString());
        if( ans > Integer.MAX_VALUE ){
            return -1;
        }
        return (int)ans == n?-1: (int)ans;
    }

    private void reverse(char[] arr, int left, int right) {
        while (left<= right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
