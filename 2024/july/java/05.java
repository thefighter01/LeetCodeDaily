class Solution {
    public int passThePillow(int n, int time) {
        int times = time / (n-1);
        int rem = time % (n-1);

        return (times & 1)  > 0 ? n- rem : rem+1 ;
        
    }
}
