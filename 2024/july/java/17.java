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
    private List<TreeNode> ans;
    private boolean isExists(int [] f , int v){
        int L = 0 , R = f.length-1;
        while(L <= R){
            int md = (L + R) >> 1;
            if (f[md] == v) return true;
            else if (f[md] > v) R = md -1;
            else L = md + 1;
        }
        return false;
    }
    private boolean isNull (TreeNode root){
        return root == null;
    }
    private TreeNode solve(TreeNode root , int [] f){
        if (isNull(root)) return null;
        root.left = solve(root.left , f );
        root.right = solve(root.right , f );
        if (isExists(f, root.val)){
            if (!isNull(root.left)) ans.add(root.left);
            if (!isNull(root.right)) ans.add(root.right);
           return null;
        }
        return root;

    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<TreeNode>();
        Arrays.sort(to_delete);
        
        if(!isNull(solve(root , to_delete ))) ans.add(root);
        return ans;
        
    }
}
