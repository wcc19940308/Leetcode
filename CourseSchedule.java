package LeetCode100;

import sun.java2d.windows.GDIRenderer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDgree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int len = prerequisites.length;
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < len; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
            inDgree[prerequisites[i][1]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDgree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            Integer top = queue.poll();
            for (Integer index : graph[top]) {
                inDgree[index]--;
                if(inDgree[index] == 0) queue.offer(index);
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if(inDgree[i] != 0) return false;
        }
        return true;
    }

    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] visited = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int len = prerequisites.length;
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < numCourses; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if(!DFS(graph,visited,i)) return false;
        }
        return true;

    }

    public boolean DFS(List<Integer>[] graph, int[] visited, int i) {
        if(visited[i] == -1) return false;
        if(visited[i] == 1) return true;
        visited[i] = -1;
        for (Integer index : graph[i]) {
            if(!DFS(graph, visited, i)) return false;
        }
        visited[i] = 1;
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0}};
        System.out.println(canFinishBFS(2,arr));
    }
}
