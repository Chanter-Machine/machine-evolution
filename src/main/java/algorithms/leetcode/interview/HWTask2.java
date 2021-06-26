package algorithms.leetcode.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HWTask2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String input = sc.nextLine();
            input = input.replace("[","");
            input = input.replace("]", "");
            String[] originArr = input.split(",");
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i=0;i<originArr.length;i++) {
                try{
                    int num = Integer.parseInt(originArr[i]);
                    arr.add(num);
                }catch (Exception e){
                    System.out.println(0);
                    break;
                }
            }
            if (arr.size() %2!=0) {
                System.out.println(0);
            }else {
//                [1,1,1,1,2,1,1],[5,2,5,4,5,1,6]
                List<Integer> x =  arr.subList(0, arr.size()/2);
                List<Integer> y =  arr.subList(arr.size()/2, arr.size());
//                System.out.println(x);
//                System.out.println(y);
                if(x.size()!= y.size()) {
                    System.out.println(0);
                }else {
                    int res = calc(x,y);
                    System.out.println(res);
                }

            }


        }
    }

    public static int calc(List<Integer>x, List<Integer>y){
        int size = x.size();
        int maxArea = 0;
        for(int i=0;i<size;i++) {
            int indexLeft = i-1;
            int indexRight = i+1;
            int height = y.get(i);
            int initWidth = x.get(i);
            while (indexLeft>=0) {
                if (y.get(indexLeft)>=height) {
                    initWidth += x.get(indexLeft);
                    indexLeft--;
                }else{
                    break;
                }
            }
            while (indexRight<size) {
                if (y.get(indexRight)>=height) {
                    initWidth += x.get(indexRight);
                    indexRight++;
                }else{
                    break;
                }
            }
            int area = initWidth * height;
            if(maxArea<area) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
