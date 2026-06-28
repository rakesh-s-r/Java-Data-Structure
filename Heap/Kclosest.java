package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Kclosest {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> x[0] - y[0]);

        for (int[] pts : points) {
            int val = (pts[0] * pts[0]) + (pts[1] * pts[1]);
            heap.add(new int[] { val, pts[0], pts[1] });
        }

        int[][] res = new int[k][2];
        while (k - 1 >= 0) {
            int[] heapVal = heap.poll();
            res[k - 1][0] = heapVal[1];
            res[k - 1][1] = heapVal[2];
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        Kclosest kc = new Kclosest();
        int[][] p1 = { { 0, 2 }, { 2, 0 }, { 2, 2 } };
        System.out.println(Arrays.deepToString(kc.kClosest(p1, 2)));

        int[][] p2 = { { 1, 3 }, { -2, 2 } };
        System.out.println(Arrays.deepToString(kc.kClosest(p2, 1)));
    }
}
