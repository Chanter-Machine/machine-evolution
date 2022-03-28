package algorithms.practice.binary_search;

/**
 * 找到目标元素的左边界
 */
public class FindBound {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,3,4,5,6,7};
        FindBound findLeftBound = new FindBound();
        System.out.println(findLeftBound.findLeftBound(arr, 3));
        System.out.println(findLeftBound.findRightBound(arr, 3));
    }

    public int findLeftBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        while (left< right) {
            mid = left + ((right-left)>>1);
            if(mid<target) {
                left = mid+1;
            }else{
                right = mid;
            }
        }

        if(arr[left] != target) {
            return -1;
        }
        return left;
    }

    public int findRightBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        while (left < right) {
            mid =  (left + right + 1) >>1;
            if(arr[mid] <=target) {
                left = mid;
            }else {
                right = mid -1;
            }
        }
        if(arr[left] != target) {
            return -1;
        }
        return left;
    }
}
