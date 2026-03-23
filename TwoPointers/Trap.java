package TwoPointers;

// 42. Trapping Rain Water
public class Trap {
    public static void main(String[] args) {
        System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }

    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0, maxL = height[left], maxR = height[right];
        while (left <= right) {
            if (maxL < maxR) {
                maxL = Math.max(maxL, height[left]);
                res += maxL - height[left];
                left++;
            } else {
                maxR = Math.max(maxR, height[right]);
                res += maxR - height[right];
                right--;
            }
        }
        return res;
    }
}
