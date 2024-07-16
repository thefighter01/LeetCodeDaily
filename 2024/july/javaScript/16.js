/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} startValue
 * @param {number} destValue
 * @return {string}
 */
var getDirections = function(root, startValue, destValue) {

    function solve(root ,target , ans){
        if (root == null) return false;
        if (root.val == target){
            return true;
        }
        ans.push('L');
        let ch = solve(root.left , target, ans);
        if (ch){
            return true;
        }
        ans.pop();
        ans.push('R');
        ch = solve(root.right , target , ans);
        if (ch){
            return true;
        }
        ans.pop();
         
        return false;
    }
        let destPath = [];
        let startPath = [];
        solve(root , startValue , startPath);
        solve(root , destValue , destPath);
        let ans = "";
        let common = 0;
        const sz1 = destPath.length;
        const sz0 = startPath.length;
        while(common < sz0 && common < sz1 && startPath.at(common) == destPath.at(common) ) ++common;

        for (let i = 0; i < sz0 - common; ++i) ans+='U';
        for (let i = common; i < sz1; ++i)ans+=destPath.at(i);
        return ans;
    
};
