package algorithms.leetcode.string;

import java.util.HashMap;

public class ThreehundardAndEightyThree {
    public static void main(String[] args) {
        String randsomNote = "dehifb";
        String magazine  = "hhjdgjbhahaagihhhhhajjibjffhijehda";
        ThreehundardAndEightyThree threehundardAndEightyThree = new ThreehundardAndEightyThree();
        threehundardAndEightyThree.canConstruct(randsomNote, magazine);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) {
            return false;
        }

        char[] ranArray = ransomNote.toCharArray();
        char[] magazineArray = magazine.toCharArray();

        HashMap<Character, Integer> ranMap = new HashMap<>();
        HashMap<Character, Integer> magazineMap = new HashMap<>();

        for(int i=0; i<magazineArray.length; i++) {
            int count = magazineMap.getOrDefault(magazineArray[i], 0);
            magazineMap.put(magazineArray[i], count+1);
        }

        for(int i=0; i<ranArray.length; i++) {
            int count = magazineMap.getOrDefault(ranArray[i], 0);
            if(count == 0) {
                return false;
            }
            magazineMap.put(ranArray[i], count-1);
        }
        return true;
    }
}
