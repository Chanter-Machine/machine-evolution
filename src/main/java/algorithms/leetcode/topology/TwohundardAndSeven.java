package algorithms.leetcode.topology;

import java.util.*;

public class TwohundardAndSeven {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        int[] degree = new int[numCourses];
        HashSet<Integer>[] preCouses = new HashSet[numCourses];
        for(int i=0; i<numCourses; i++) {
            preCouses[i] = new HashSet<>();
        }
        for(int i=0; i<prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            preCouses[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(degree[i] == 0) {
                queue.add(i);
            }
        }

        int studied = 0;
        while (!queue.isEmpty()) {
            int course  = queue.poll();
            studied++;
            for(int laterCourse : preCouses[course]) {
                if(--degree[laterCourse]==0) {
                    queue.add(laterCourse);
                }
            }
        }

        return studied==numCourses;

    }
}
