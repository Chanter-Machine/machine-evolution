package algorithms.leetcode.string;

public class ElevenEIghtyNine {
    public int maxNumberOfBalloons(String text) {

        int b = 0;
        int a = 0;
        int l = 0;
        int o = 0;
        int n = 0;
        for(int i = 0; i<text.length(); i++) {
            if(text.charAt(i) == 'b'){
                b++;
            } else if(text.charAt(i) == 'a'){
                a++;
            } else if(text.charAt(i) == 'l'){
                l++;
            }else if(text.charAt(i) == 'o'){
                o++;
            } else if (text.charAt(i) == 'n') {
                n++;
            }
        }
        l /=2;
        o /=2;
        return Math.min(n, Math.min(Math.min(b,a), Math.min(l, o)));
    }
}
