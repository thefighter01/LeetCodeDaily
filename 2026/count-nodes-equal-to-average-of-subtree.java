/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int answer ;

    private int [] solve(TreeNode root){
        if (root == null) return new int[] {0 ,0};

        
        int [] left = solve(root.left);
        int [] right = solve(root.right);

        int value = root.val;

        int sum = left[0] + right[0] + value;
        int sz = 1 + left[1] + right [1];


        if (sum  / sz == value) answer++;
        return new int []{sum , sz};
        
    }
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return answer;
        
    }
}