/**
 * @param {number[]} nums
 * @return {number}
 */
var minSwaps = function(nums) {
    function solve(L ,  R , ans){
        return ans[R] - (L > 0 ? ans[L-1] : 0);
    }
   
        const n = nums.length;
        let ones = 0;
        for (let i = 0; i < n; ++i){
            ones+= nums[i];
            nums[i]+= (i > 0 ? nums[i-1] : 0);
        }

        if (ones === 0) return 0;
       
        let ans = 0;
        for (let i = 0; i + ones <= n; ++i){
            ans = Math.max(ans , solve(i , i +ones -1, nums));
        }
         for (let i = 1; i < ones; ++i){
            ans = Math.max(ans , solve(n-i , n-1 , nums)+ solve(0 , ones -i -1 , nums));
        }
        return ones - ans;
};
