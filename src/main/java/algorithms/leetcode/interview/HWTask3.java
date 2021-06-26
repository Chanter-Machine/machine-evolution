package algorithms.leetcode.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**


 5
 5
 cloxy 3 0
 cxmnu 1 1
 kcotd 2 1
 apqud 2 0
 bldwz 1 1
 */

public class HWTask3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int numOfWord = Integer.parseInt(sc.nextLine());
            int numOfGuess = Integer.parseInt(sc.nextLine());
            ArrayList<String> finalWord= new ArrayList<>(numOfWord);
            ArrayList<HashMap<String, Integer>> stat = new ArrayList<>();
            for(int i=0;i<numOfWord;i++) {
                stat.add(new HashMap<>());
            }
            int rightCount = 0;
            System.out.println(finalWord);
            for(int i=0;i<numOfGuess;i++){
                String input = sc.nextLine();
                String[] arr = input.split(" ");
                String word = arr[0];
                String right = arr[1];
                String wrong = arr[2];

                rightCount += Integer.parseInt(right);
                for(int j=0;j<numOfWord;j++) {
                    HashMap<String, Integer> aMap = stat.get(j);
                    String character = word.charAt(j)+"";
                    if (aMap.get(character) == null) {
                        aMap.put(character, 1);
                    }else {
                        aMap.put(character, aMap.get(character)+1);
                    }

                }
            }
            int round = rightCount % numOfWord;
            for(int i=0;i< numOfWord;i++) {
                HashMap<String, Integer> aMap = stat.get(i);
                for(String key: aMap.keySet()){
                    if (aMap.get(key) == round) {
                        finalWord.set(i, key);
                        break;
                    }
                }
            }

            System.out.println(stat);

        }
    }
}
