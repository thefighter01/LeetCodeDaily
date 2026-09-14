class Solution {

    private boolean can(int [] r1 , int [] r2){
        int x12 = r1[2];
        int x21 = r2[0];



        int y12 = r1[3];
        int y21 = r2[1];


        return x21 >= x12 || y21 >= y12;
    }
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
       if (can(rec1 , rec2) || can(rec2 , rec1)) return false;
       return true;
    }
}