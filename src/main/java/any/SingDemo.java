package any;

import java.util.Arrays;

public class SingDemo {



    public static void main(String[] args) {

    }



    public int[] mergeSort(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length+arr2.length];

        for(int i=0;i<arr1.length;i++) {
            result[i]= arr1[i];
        }
        for(int i=0;i<arr2.length;i++) {
            result[i+arr1.length] = arr2[i];
        }
        Arrays.sort(result);
        return result;
    }

    public static volatile Object obj ;

    public Object getASing(){

        if(obj == null) {
            synchronized (SingDemo.class) {
                if(obj==null) {
                    obj = new Object();
                    return obj;
                }
            }

        }
        return obj;
    }
}
