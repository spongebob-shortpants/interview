package ca.bytetube._03_stackAndQueue;

/**
 * https://leetcode.com/problems/maximum-binary-tree/
 * @author dal
 */
public class Maximum_Binary_Tree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;

            return findRoot(nums,0,nums.length);
    }
    //找出[l,r)范围内的根节点
    private TreeNode findRoot(int[] nums, int l, int r){
        if (l == r)  return null;
        int maxIndex = l;
        for (int i = l+1 ; i < r; i++) {
            if (nums[i] > nums[maxIndex])  maxIndex = i;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);

        //tail recursion
        root.left = findRoot(nums,l,maxIndex);
        root.right = findRoot(nums,maxIndex+1,r);
        return root;
    }




    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
