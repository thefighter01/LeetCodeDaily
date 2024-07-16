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
    private boolean solve(TreeNode root , int target ,StringBuilder ans){
        if (root == null) return false;
        if (root.val == target){
            return true;
        }
        ans.append('L');
        boolean ch = solve(root.left , target, ans);
        if (ch){
            return true;
        }
        ans.deleteCharAt(ans.length() - 1);
        ans.append('R');
        ch = solve(root.right , target , ans);
        if (ch){
            return true;
        }
        ans.deleteCharAt(ans.length() - 1);
         
        return false;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder destPath = new StringBuilder();
        StringBuilder startPath = new StringBuilder();
        solve(root , startValue , startPath);
        solve(root , destValue , destPath);
        StringBuilder ans = new StringBuilder();
        int common = 0;
        int sz1 = destPath.length();
        int sz0 = startPath.length();
        while(common < sz0 && common < sz1 && startPath.charAt(common) == destPath.charAt(common) ) ++common;

        for (int i = 0; i < sz0 - common; ++i) ans.append('U');
        for (int i = common; i < sz1; ++i)ans.append(destPath.charAt(i));
        return ans.toString();
       
        
    }
}
