package Greedy;

public class CanJump {
    public static void main(String[] args) {
        System.out.println(canJump(new int[] {3,1,1,4}));
    }

    public static boolean canJump(int[] nums) {
        int dest = nums.length-1;

        for(int i = nums.length-2; i>=0 ; i--) {
            if(i + nums[i] >= dest) {
                dest = i;
            }
        }
        return dest == 0;
    }
}
