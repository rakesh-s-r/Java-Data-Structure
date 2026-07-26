package Greedy;

public class CanJumpTwo {
    public static void main(String[] args) {
        System.out.println(jump(new int[] {2,3,1,1,4}));
    }

    public static int jump(int[] nums) {
        int jumps = 0;
        int coverage =0, end = 0;
        if(nums.length <= 1) {
            return jumps;
        }

        for(int i=0; i< nums.length; i++) {
            coverage= Math.max(coverage, i + nums[i]);
            if(i == end) {
                end = coverage;
                jumps++;
                if(coverage >= nums.length-1) {
                    return jumps;
                }
            }
        }
        return jumps;
    }
}
