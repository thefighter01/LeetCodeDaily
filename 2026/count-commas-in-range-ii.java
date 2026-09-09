class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long base = (int)1e3;

        long x = base;
        long limit = (long)1e15;
        while(x <= limit){
            ans+= Math.max(0L , n - x +1);
            x*= base;

        }
        return ans;
    }
}