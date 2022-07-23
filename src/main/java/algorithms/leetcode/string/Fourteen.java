package algorithms.leetcode.string;

public class Fourteen {
    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if( len == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for(int j=1; j<len; j++) {
                if(strs[j].length() == i) {
                    return sb.toString();
                }
                if(c != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
