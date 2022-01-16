package algorithms.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;

public class EighthundardAndFiftyOne {
    public static void main(String[] args) {
        int[][] richer = new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = new int[] {3,2,5,4,6,1,7,0};
        EighthundardAndFiftyOne eighthundardAndFiftyOne = new EighthundardAndFiftyOne();
        int[] res = eighthundardAndFiftyOne.loudAndRich(richer, quiet);
    }
    HashMap<Integer, ComplexTreeNode> nodeMapping;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] ans = new int[quiet.length];
        if(richer.length == 0) {
            for(int i=0; i<ans.length; i++) {
                ans[i] = i;
            }
            return ans;
        }


        nodeMapping = new HashMap<>();
        for(int i=0; i<richer.length; i++) {
            ComplexTreeNode curNode = nodeMapping.getOrDefault(richer[i][0], null);
            if(curNode == null) {
                curNode = new ComplexTreeNode(richer[i][0], quiet[richer[i][0]]);
                nodeMapping.put(richer[i][0], curNode);
            }
            ComplexTreeNode nextNode = nodeMapping.getOrDefault(richer[i][1], null);
            if( nextNode == null) {
                nextNode = new ComplexTreeNode(richer[i][1], quiet[richer[i][1]]);
                nodeMapping.put(richer[i][1], nextNode);
            }
            curNode.nexts.add(nextNode);
            nextNode.previous.add(curNode);
        }

        int[] result = new int[quiet.length];
        for(int i=0;i<result.length; i++) {
            result[i] = nodeMapping.get(i).getQuietness();
        }
        return result;
    }



    class ComplexTreeNode {
        Integer val;
        ArrayList<ComplexTreeNode> nexts, previous;
        boolean IsFinalQuietness;
        Integer quietness;
        ComplexTreeNode(Integer val, Integer quietness) {
            this.val = val;
            this.nexts = new ArrayList<>();
            this.previous = new ArrayList<>();
            this.IsFinalQuietness = false;
            this.quietness = quietness;
        }

        private int getQuietness() {
            if(this.previous.size() == 0 || this.IsFinalQuietness) {
                this.IsFinalQuietness = true;
//                System.out.println(this.val +"  "+ this.quietness);
                return this.val;
            }

            for(int i=0; i<this.previous.size(); i++) {
                int person = this.previous.get(i).getQuietness();
                if(this.quietness > nodeMapping.get(person).quietness) {
                    this.quietness = nodeMapping.get(person).quietness;
                    this.val = person;
                }
            }
            this.IsFinalQuietness = true;
//            System.out.println(this.val +"  "+ this.quietness);

            return this.val;
        }
    }
}
