package algorithms.leetcode.string;

public class Six {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        Six six = new Six();
        six.convert(s, numRows);
    }
    public String convert(String s, int numRows) {
        if( numRows == 1) {
            return s;
        }
        int len = s.length();
        int mod = 2*numRows -2;
        int group = len/mod;
        group = len%mod==0?group:group+1;
        int[][] indexRange = new int[numRows][2];
        indexRange[0] = new int[]{0,-1};
        indexRange[numRows-1] = new int[]{numRows-1, -1};
        for(int i=1; i<numRows-1; i++) {
            indexRange[i] = new int[]{i, mod-i};
        }

        StringBuilder sb = new StringBuilder(s.length());
        for(int i=0; i<indexRange.length; i++) {
            for(int j=0; j<group; j++) {
                if(indexRange[i][0] != -1) {
                    int index1 = (mod*j)+ indexRange[i][0];
                    if(index1 <len){
                        sb.append(s.charAt(index1));
                    }

                }

                if(indexRange[i][1] != -1) {
                    int index2 = (mod*j)+ indexRange[i][1];
                    if(index2 <len){
                        sb.append(s.charAt(index2));
                    }
                }
            }
        }

        return sb.toString();
    }
}
