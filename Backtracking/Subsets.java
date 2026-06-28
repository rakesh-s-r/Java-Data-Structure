package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }

    public void dfs(int i, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(i + 1, nums);

        subset.remove(subset.size() - 1);
        dfs(i + 1, nums);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        Subsets ss = new Subsets();
        System.out.println(ss.subsets(nums));
    }
}
