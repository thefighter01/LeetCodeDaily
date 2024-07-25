class Solution {

    private int convert(int []mp , int a){
        int ans = 0;
        var cur = String.valueOf(a);
        final int sz = cur.length();
        for (int i = 0; i < sz; ++i){
            ans = ans * 10 + mp[(cur.charAt(i)-'0')];
        }
        return ans;

    }
    public int[] sortJumbled(int[] mp, int[] nums) {
        // non-decreasing
        final int n = nums.length;
        var f = new Integer[n];
        for (int i = 0; i < n; ++i) f[i] = nums[i];

        Arrays.sort(f , new Comparator<Integer>(){
            public int compare(Integer a , Integer b){
                int idA = convert(mp ,a);
                int idB = convert(mp , b);
                return idA - idB;
            }
        });
        for (int i = 0; i < n; ++i) nums[i] = f[i];
        return nums;
        
    }
} 
