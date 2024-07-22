class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        var ans = new String[n];
        var id = new Integer[n];
        for (int i = 0; i < n; ++i) id[i] = i;

        Arrays.sort(id , new Comparator<Integer>(){
            @Override
            public int compare(Integer a , Integer b){
                return heights[b] - heights[a];
            }
        });
        for (int i = 0; i < n; ++i) ans[i] = names[id[i]];
        return ans;

    }
}
