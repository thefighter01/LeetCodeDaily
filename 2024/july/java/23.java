class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int cur : nums){
            f.put(cur , f.getOrDefault(cur , 0)+1);
        }
        var id = new Integer[201];
        for (int i = 0, k = -100; i < 201; ++i , ++k){
            id[i] = k;
        }

        Arrays.sort(id , new Comparator<Integer>(){
            public int compare(Integer a , Integer b){
                int fA = f.getOrDefault(a , 0);
                int fB = f.getOrDefault(b , 0);
                if (fA == fB) return b -a;
                return fA - fB;
            }
        });
        int k = 0;
        int n = nums.length;
        var ans = new int[n];
        for (int a : id){
            int sz = f.getOrDefault(a , 0);
            for (int i = 0; i < sz; ++i){
                ans[k++] = a;
            }
        }
        return ans;
    }
}
