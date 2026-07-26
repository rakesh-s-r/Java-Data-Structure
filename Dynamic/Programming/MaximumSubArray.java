package Dynamic.Programming;

public class MaximumSubArray {
    public static void main(String[] args) {
        System.out.print(maxSubArray(new int[] {5,4,-1,7,8}));
    }
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur_sum_max = nums[0];

        for(int i=1; i< nums.length; i++) {
            cur_sum_max = Math.max(nums[i], cur_sum_max + nums[i]);
            max = Math.max(max, cur_sum_max);
        }

        return max;
    }
}
