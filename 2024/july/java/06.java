class Solution {
    private int solve(int n , int d , int rem){
        int extra = (rem + n) / d;
        if (extra == 0) return 0;
        return extra + solve( extra , d ,(n + rem) % d);
    }
    public int numWaterBottles(int numBottles, int numExchange) {
        return numBottles + solve(numBottles , numExchange , 0);
    }
}
