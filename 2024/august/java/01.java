class Solution {
    
    private int solve(String s){
        int age = 0;
        for (int i = 11; i <= 12; ++i){
            age = age * 10 + (s.charAt(i)-'0');
        }
        return age > 60 ? 1 : 0;
    }
    public int countSeniors(String[] details) {
        int ans = 0;
        for (var cur : details){
            ans+= solve(cur);
        }
        return ans;
    }
}
