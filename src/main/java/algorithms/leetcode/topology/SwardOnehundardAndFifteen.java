package algorithms.leetcode.topology;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class SwardOnehundardAndFifteen {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        int[] indegrees = new int[n + 1];
        Set<Integer>[] graph = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<Integer>();
        }
        for (int[] sequence : sequences) {
            int size = sequence.length;
            for (int i = 1; i < size; i++) {
                int prev = sequence[i - 1];
                int next = sequence[i];
                if (graph[prev].add(next)) {
                    indegrees[next]++;
                }
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int num = queue.poll();
            Set<Integer> set = graph[num];
            for (int next : set) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return true;
    }

    public boolean sequenceReconstruction3(int[]nums, int[][] sequences) {
        int n = nums.length;
        int[] indegrees = new int[n + 1];
        Set<Integer>[] graph = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<Integer>();
        }
        for (int[] sequence : sequences) {
            int size = sequence.length;
            for (int i = 1; i < size; i++) {
                int prev = sequence[i - 1], next = sequence[i];
                if (graph[prev].add(next)) {
                    indegrees[next]++;
                }
            }
        }
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int num = queue.poll();
            Set<Integer> set = graph[num];
            for (int next : set) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return true;
    }

    public boolean sequenceReconstruction2(int[]nums, int[][] sequences) {
        int len = nums.length;
        int[] indegrees = new int[len+1];
        Set<Integer>[] graphs = new Set[len+1];
        for(int i=0; i<=sequences.length; i++) {
            graphs[i] = new HashSet<Integer>();
        }
        for(int[] sequence: sequences) {
            int size = sequence.length;
            for(int i=1; i<size; i++) {
                int prev = sequence[i-1];
                int cur = sequence[i];
                if(graphs[prev].add(cur)) {
                    indegrees[cur]++;
                }
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1; i<indegrees.length; i++) {
            if(indegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            if(queue.size() >1) {
                return false;
            }
            int num = queue.poll();
            Set<Integer> set = graphs[num];
            for(Integer next : set) {
                indegrees[next]--;
            }
        }

        return true;
    }

}