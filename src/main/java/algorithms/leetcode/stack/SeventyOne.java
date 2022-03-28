package algorithms.leetcode.stack;

import java.util.Stack;

public class SeventyOne {

    public String simplifyPath(String path) {

        String[] arr = path.split("/");
        Stack<String> directory = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals("") || arr[i].equals(".")) {
                continue;
            }
            if(arr[i].equals("..") ) {
                if( !directory.isEmpty()) {
                    directory.pop();
                    continue;
                }
                continue;
            }
            directory.push(arr[i]);

        }
        Stack<String> reverseStack = new Stack<>();
        while (!directory.isEmpty()) {
            reverseStack.push(directory.pop());
        }
        StringBuilder builder = new StringBuilder();
        while (!reverseStack.isEmpty()) {
            builder.append("/").append(reverseStack.pop());
        }
        String dirc = builder.toString();
        if(dirc.length() == 0) {
            return "/";
        }
        return dirc;
    }
}
