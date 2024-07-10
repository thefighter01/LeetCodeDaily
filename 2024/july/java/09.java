class Solution {
    public int minOperations(String[] logs) {
        int cnt = 0;
        for (String cur : logs){
            int dots = 0;
            final int sz = cur.length();
            for (int i = 0; i < sz; ++i) {
                if (cur.charAt(i) == '.') dots++;
            }
            cnt += (dots == 2 ? -1 : (dots == 1) ? 0 : 1);
            cnt = Math.max(0 , cnt);
        }
        return cnt;
        
    }
}
