package algorithms.leetcode.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EighthundardAndEightyFour {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[]arr2 = s2.split(" ");
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for(String str: arr1) {
            int count =  map1.getOrDefault(str, 0);
            map1.put(str, count+1);
        }
        for(String str : arr2) {
            int count =  map2.getOrDefault(str, 0);
            map2.put(str, count+1);
        }
        for(Map.Entry<String, Integer> entry: map1.entrySet()) {
            if(entry.getValue() != 1) {
                continue;
            }

            String key = entry.getKey();
            int count = map2.getOrDefault(key, 0);
            if(count==0) {
                list.add(key);
            }
        }

        for(Map.Entry<String, Integer> entry: map2.entrySet()) {
            if(entry.getValue() != 1) {
                continue;
            }
            String key = entry.getKey();
            int count = map1.getOrDefault(key, 0);
            if(count==0) {
                list.add(key);
            }
        }

        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
     }
}
