/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[][]} descriptions
 * @return {TreeNode}
 */
var createBinaryTree = function(descriptions) {
    const sz = 1e5+1;
    let deg = new Array(sz).fill(0);
    let g = new Array(sz);

    const work = function (x){
        if (!g[x]) g[x] = [];
    }
    function solve(p ,  head){
        work(p);
        for (const ch of g[p]){
            if (ch < 0){
                head.left = new TreeNode(-ch);
                solve(-ch , head.left);
            }else {
                head.right = new TreeNode(ch);
                solve(ch , head.right);
            }
        }
    }
   
    let nums = [];
       
        for (const [a , b , c] of  descriptions){
            deg[b]++;
            work(a);
            g[a].push(b * (c == 1 ? -1 : 1));
            nums.push(a);
            nums.push(b);
          //  console.log(a , b , c);
        }
        let p = -1;
        for (let i = 0; i < nums.length ; ++i){
            if (deg[nums[i]] == 0){
                p = nums[i];
                break;
            }
        }
      
        let ans = new TreeNode(p);
        solve(p , ans);
        return ans;
        
};
    
