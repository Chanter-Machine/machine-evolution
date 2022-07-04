package algorithms.leetcode.topology;

import java.util.HashSet;
import java.util.PriorityQueue;

public class TwohundardAndTen {
    public static void main(String[] args) {
        int n = 2;
        int[][] prerequisites = new int[][]{{1,0}};

        TwohundardAndTen twohundardAndTen = new TwohundardAndTen();
        twohundardAndTen.findOrder(n, prerequisites);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        int[] courses = new int[numCourses];
        HashSet<Integer>[] after = new HashSet[numCourses];
        for(int i=0; i<numCourses; i++) {
            after[i] = new HashSet<>();
        }
        for(int i=0; i<len; i++) {
            courses[prerequisites[i][0]]++;
            after[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<numCourses; i++) {
            if(courses[i] == 0) {
                queue.add(i);
            }
        }

        int[] order = new int[numCourses];
        int p = 0;
        while (!queue.isEmpty()) {
            int toStudyCourse = queue.poll();
            order[p++] = toStudyCourse;
            for(Integer afterStudy : after[toStudyCourse]) {
                if(--courses[afterStudy] == 0) {
                    queue.add(afterStudy);
                }
            }
        }

        if(p == numCourses) {
            return order;
        }
        return new int[0];
    }
}
