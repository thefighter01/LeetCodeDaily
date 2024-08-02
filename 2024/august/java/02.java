class Solution {
    private int solve(int L , int R , int []ans){
        return ans[R] - (L > 0 ? ans[L-1] : 0);
    }
    public int minSwaps(int[] nums) {
        final int n = nums.length;
        int ones = 0;
        for (int i = 0; i < n; ++i){
            ones+= nums[i];
            nums[i]+= (i > 0 ? nums[i-1] : 0);
        }
        if (ones == 0) return 0;
       
        int ans = 0;
        for (int i = 0; i + ones <= n; ++i){
            ans = Math.max(ans , solve(i , i +ones -1, nums));
        }
        for (int i = 1; i < ones; ++i){
            ans = Math.max(ans , solve(n-i , n-1 , nums)+ solve(0 , ones -i -1 , nums));
        }
        return ones - ans;
        
    }
}
