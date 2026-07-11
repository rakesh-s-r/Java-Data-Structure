package Heap;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] ch = {'A', 'A', 'A', 'B', 'C'};
        TaskScheduler ts = new TaskScheduler();
        Logger.info(ts.leastInterval(ch, 3));
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i: map.values()) {
            heap.offer(i);
        }

        Queue<int[]> q = new ArrayDeque<>();
        int time = 0;
        while(!q.isEmpty() || !heap.isEmpty()) {
            time++;
            if(!heap.isEmpty()) {
                int val = heap.poll()-1;
                if(val > 0) {
                    q.offer(new int[] {val, time+n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time) {
                heap.offer(q.poll()[0]);
            }
        }
        return time;
    }
}
