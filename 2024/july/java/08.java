class Solution {
    public double averageWaitingTime(int[][] customers) {
        double ans = 0;
        final int sz = customers.length;

        long st = 0;
        for (int []ch : customers){
            st = Math.max(st , ch[0]);
            long end = st + ch[1];
            ans+= end - ch[0];
            st = end;
        }

        return ans / sz;
        
    }
}
