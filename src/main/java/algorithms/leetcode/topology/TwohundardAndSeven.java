package algorithms.leetcode.topology;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TwohundardAndSeven {

    // BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        for(int i=0; i<numCourses; i++ ){
            if(indegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for(int cur:adjacency.get(pre)) {
                if(--indegrees[cur] == 0) {
                    queue.add(cur);
                }
            }
        }

        return numCourses == 0;
    }

    //DFS
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] indegress = new int[numCourses];
        List<List<Integer>> adjecency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjecency.add(new ArrayList<>());
        }
        int[] flags = new int[numCourses];
        for(int[] cp : prerequisites) {
            adjecency.get(cp[1]).add(cp[0]);
        }
        for(int i=0; i<numCourses; i++) {
            if(!dfs(adjecency, flags, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjecency, int[] flags, int i) {
        if(flags[i] == 1) {
            return false;
        }
        if(flags[i] == -1) {
            return true;
        }
        flags[i] = 1;
        for(int next : adjecency.get(i)) {
            if(!dfs(adjecency, flags, next)) {
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }
}
