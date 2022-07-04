package algorithms.leetcode.sliding_window;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Thirty {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};

        String s2 = "barfoofoobarthefoobarman";
        String[] words2 = new String[]{"foo","bar", "the"};

        String s3 = "wordgoodgoodgoodbestword";
        String[] words3= new String[]{"word","good","best","good"};

        String s4 = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words4= new String[]{"fooo","barr","wing","ding","wing"};

        String s5 = "a";
        String[] words5= new String[]{"a"};
        Thirty thirty = new Thirty();
        List<Integer> res = thirty.findSubstring(s5, words5);
        System.out.println(res);
    }
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        int winSize = words.length;
        int wordsNum = s.length() / wordLen;
        HashMap<String, Integer> wordsMap = new HashMap<>(winSize);
        for(int i=0; i<winSize; i++) {
            int count = wordsMap.getOrDefault(words[i], 0);
            wordsMap.put(words[i], count+1);
        }

        List<Integer> list = new LinkedList<>();

        HashMap<String, Integer> tmpMap;
        for(int i=0; i<s.length(); ) {
            tmpMap = new HashMap<>(winSize);
            int j = i;
            boolean isSuccess = true;
            int wordNum = 0;
            while (j+wordLen-1<s.length() && wordNum<winSize) {
                String word = s.substring(j, j+wordLen);
                int count = wordsMap.getOrDefault(word, 0);
                int tmpCount = tmpMap.getOrDefault(word, 0);

                if( count == 0 || count<tmpCount) {
                    isSuccess = false;
                    break;
                }
                tmpMap.put(word, tmpCount+1);
                j+=wordLen;
                wordNum++;
            }
            if(!isSuccess || tmpMap.size() != wordsMap.size()) {
                i+=1;
                continue;
            }
            for(Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
                if(!entry.getValue().equals(tmpMap.getOrDefault(entry.getKey(), 0))){
                    isSuccess = false;
                    break;
                }
            }
            if(!isSuccess) {
                i+=1;
                continue;
            }

            list.add(i);
            i+=1;
        }


        return list;
    }
}
