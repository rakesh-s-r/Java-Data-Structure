package Graphs;

import java.util.*;

// 207. Course Schedule
public class CanFinish {
    static Set<Integer> set = new HashSet<>();
    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][] { { 1, 0 } }));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] pts : prerequisites) {
            map.get(pts[0]).add(pts[1]);
        }
        System.out.println(map);
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean dfs(int i) {
        if (set.contains(i)) {
            return false;
        }
        if (map.get(i).isEmpty()) {
            return true;
        }
        set.add(i);
        for (int n : map.get(i)) {
            if (!dfs(n)) {
                return false;
            }
        }
        set.remove(i);
        map.get(i).clear();
        return true;
    }
}
