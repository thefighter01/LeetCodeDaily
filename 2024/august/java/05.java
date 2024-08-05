class Solution {
    public String kthDistinct(String[] arr, int k) {
        var f = new HashMap<String , Integer> ();
        for (var cur : arr){
            f.put(cur , f.getOrDefault(cur , 0)+1);
        }
        for (var cur : arr){
            int cnt = f.get(cur);
            if (cnt == 1) --k;
            if (k == 0) return cur;
        }
        assert(k > 0);
        return "";
    }
}
