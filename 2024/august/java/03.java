class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
    final int mx = Arrays.stream(arr).max().getAsInt();
    int [] fa = new int[mx+1];
    int [] fb = new int[mx+1];
    for (var ch : arr) fa[ch]++;
    for (var ch : target) {
        if (ch <= mx) fb[ch]++;
    }

    for (int i = 0; i <= mx; ++i) if (fa[i] != fb[i]) return false;
    return true;
}
}
