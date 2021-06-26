package algorithms.newcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Disk {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            Integer num = Integer.parseInt(in.nextLine());
            String[] inputs = new String[num];
            for(int i=0;i<num;i++) {
                inputs[i] = in.nextLine();
            }

            ArrayList<Long> sizeList = new ArrayList<>();
            HashMap<Long, ArrayList<String>> mapB = new HashMap<>();
            for(int i=0;i<inputs.length;i++) {
                String input = inputs[i];
                Long size = calc(input);

                if(mapB.keySet().contains(size)) {
                    ArrayList list = mapB.get(size);
                    list.add(input);
                }else {
                    ArrayList list = new ArrayList();
                    list.add(input);
                    mapB.put(size, list);
                    sizeList.add(size);
                }
            }
            Long[] sizeArray = new Long[sizeList.size()];
            for(int i=0;i<sizeList.size();i++) {
                sizeArray[i] = sizeList.get(i);
            }
            Arrays.sort(sizeArray);
            for(int i=0;i<sizeArray.length;i++) {
                ArrayList list = mapB.get(sizeArray[i]);
                for(int j=0;j<list.size();j++) {
                    System.out.println(list.get(j));
                }
            }
        }
    }

    public static long calc(String input) {
        Long sum = 0L;
        char[] arr = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++) {
            if(arr[i] != 'G' && arr[i] != 'T' && arr[i] != 'M') {
                sb.append(arr[i]);
                continue;
            }else {
                Integer size = Integer.parseInt(sb.toString());
                if (arr[i] == 'M') {
                    sum+=size;

                }else if(arr[i] == 'G') {
                    sum += size * 1024L;
                }else if(arr[i] == 'T'){
                    sum += size *1024*1024L;
                }
                sb = new StringBuilder();
            }
        }
        return sum;
    }


}
