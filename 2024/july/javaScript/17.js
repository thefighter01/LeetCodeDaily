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
 * @param {number[]} to_delete
 * @return {TreeNode[]}
 */
var delNodes = function(root, to_delete) {
    
    const ans = [];
    function isExists( f ,  v){
        let L = 0 , R = f.length-1;
        while(L <= R){
            let md = Math.floor((L + R) >> 1);
            if (f[md] == v) return true;
            else if (f[md] > v) R = md -1;
            else L = md + 1;
        }
        return false;
    }
    function isNull (root){
        return root == null;
    }
    function solve(root , f){
        if (isNull(root)) return null;
        root.left = solve(root.left , f);
        root.right = solve(root.right , f);
        if (isExists(f, root.val)){
            if (!isNull(root.left)) ans.push(root.left);
            if (!isNull(root.right)) ans.push(root.right);
           return null;
        }
        return root;

    }
  
    to_delete.sort((a , b) => a- b);
    if(!isNull(solve(root , to_delete ))) ans.push(root);
    return ans;
        
 };
