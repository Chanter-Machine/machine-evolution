package algorithms.leetcode.string;

import java.util.ArrayList;
import java.util.LinkedList;

public class FifteeNinetyTwo {

    public static void main(String[] args) {
        FifteeNinetyTwo fifteeNinetyTwo = new FifteeNinetyTwo();
        String res = fifteeNinetyTwo.reorderSpaces(" book");
        System.out.println(res);
    }

    public String reorderSpaces(String text) {
        int len = text.length();

        int spaces = 0;
        LinkedList<String> list = new LinkedList<>();
        for(int i=0; i<len ;) {
            if(text.charAt(i) == ' ') {
                spaces++;
                i++;
                continue;
            }
            StringBuilder tmpBuilder = new StringBuilder();
            while (i<len && text.charAt(i) != ' ') {
                tmpBuilder.append(text.charAt(i));
                i++;
            }
            list.add(tmpBuilder.toString());
        }
        StringBuilder sb = new StringBuilder();
        if(list.size() == 1) {
            sb.append(list.get(0));
            for(int j=0; j<spaces; j++) {
                sb.append(' ');
            }
            return sb.toString();
        }
        int spaceLen = spaces/(list.size()-1);
        int mod = spaces%(list.size()-1);



        for(int i=0; i<list.size(); i++) {
            sb.append(list.get(i));
            if( i != list.size()-1) {
                for(int j=0; j<spaceLen; j++) {
                    sb.append(' ');
                }
            }else {
                for(int j=0; j<mod; j++) {
                    sb.append(' ');
                }
            }
        }

        return sb.toString();
    }
}
