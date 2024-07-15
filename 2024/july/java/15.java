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
    private static int sz = (int)1e5+1;
    private int [] deg;
    private ArrayList<Integer> g[];
    private void work(int x){
        if (g[x] == null) g[x] = new ArrayList<Integer>();
      
    }

    private void solve(int p , TreeNode head){
        if (g[p] == null) return;
        for (int ch : g[p]){
            if (ch < 0){
                head.left = new TreeNode(-ch);
                solve(-ch , head.left);
            }else {
                head.right = new TreeNode(ch);
                solve(ch , head.right);
            }
        }
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        int [] nums = new int [2 * descriptions.length + 5];
        deg = new int [sz];
        g = new ArrayList[sz];
        int k = 0;
        for (int [] e : descriptions){
            deg[e[1]]++;
            work(e[0]);
            g[e[0]].add(e[1] * (e[2] == 1 ? -1 : 1));
            nums[k++] = e[0];
            nums[k++] = e[1];
        }
        int p = -1;
        for (int i = 0; i < k ; ++i){
            if (deg[nums[i]] == 0){
                p = nums[i];
                break;
            }
        }
        assert(p != -1);
        TreeNode ans = new TreeNode(p);
        solve(p , ans);
        return ans;
        
    }
}
