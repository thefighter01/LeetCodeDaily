/**
 * @param {number[]} nums
 * @param {number} n
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
var rangeSum = function(nums, n, left, right) {
        const allSums = Array.from({length : Math.floor(n * (n+1) / 2)} , ()=> 9);
        let k = 0;
        for (let i = 0; i < n; ++i){
            let curSum = 0;
            for (let j = i; j < n; ++j){
                curSum+= nums[j];
                allSums[k++] = curSum;
            }
        }
        allSums.sort((a , b)=> a-b);
        let ans = 0;
        const mod = 1e9+7;
        for (let i = --left; i < right ; ++i) {
            ans = (ans+ allSums[i]) % mod;
        }
        return ans;
};
