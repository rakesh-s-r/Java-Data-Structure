package Tree;

import java.util.HashMap;

public class BuildTree {
    HashMap<Integer, Integer> map = new HashMap<>();
    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(0, preorder.length - 1, preorder, inorder);
    }

    public TreeNode dfs(int left, int right, int[] p, int[] i) {
        if (left > right) {
            return null;
        }
        int val = p[idx];
        idx++;
        TreeNode root = new TreeNode(val);
        int mid = map.get(val);

        root.left = dfs(left, mid - 1, p, i);
        root.right = dfs(mid + 1, right, p, i);
        return root;
    }

    public static void main(String[] args) {
        BuildTree bt = new BuildTree();

        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        TreeNode root = bt.buildTree(preorder, inorder);
        System.out.println(root.val);
    }
}
