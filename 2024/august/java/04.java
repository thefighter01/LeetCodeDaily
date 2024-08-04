class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        var allSums = new int[n * (n+1) / 2];
        int k = 0;
        for (int i = 0; i < n; ++i){
            int curSum = 0;
            for (int j = i; j < n; ++j){
                curSum+= nums[j];
                allSums[k++] = curSum;
            }
        }
        Arrays.sort(allSums);
        int ans = 0;
        assert(k == n * (n+1) / 2);
        final int mod = (int)1e9+7;
        for (int i = --left; i < right ; ++i) {
            ans = (int)((long)ans+ allSums[i]) % mod;
        }
        return ans;
        
    }
}
