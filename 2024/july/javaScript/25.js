/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArray = function(nums) {
    let mx = 5e4;
    let f = new Array(2 * mx + 1).fill(0);
    for (const cur of  nums) f[cur + mx]++;
    const n = nums.length;
    const ans = new Array(n).fill(0);
    let k = 0;
    for (let i = -mx; i <= mx; ++i){
        const sz = f[mx + i];
        for (let j = 0; j < sz; ++j) ans[k++] = i;
    }
    return ans; 
};
