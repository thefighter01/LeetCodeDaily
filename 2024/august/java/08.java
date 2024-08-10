class Solution {
    private static int [] dx = {0 , 1, 0 , -1};
    private static int [] dy = {1 , 0 , -1 , 0};

    public int[][] spiralMatrixIII(int rows, int cols, int rSt, int cSt) {
        // 0 east
        // 1 south
        // 2 west
        // 3 north

        var ans = new int[rows * cols][2];
        

        int sz = 0;
        int dir = 0;
        for (int state = 1; sz < rows * cols; ++state){
            for (int k = 0; k < 2; ++k){
                for (int i = 0; i < state; ++i){
                    
                    if (rSt >= 0 && cSt >= 0 && rSt < rows && cSt < cols){
                        ans[sz][0] = rSt;
                        ans[sz][1] = cSt;
                        ++sz;

                    }
                    rSt+=dx[dir];
                    cSt+=dy[dir];
                   
                }
                dir = (dir + 1) % 4;
           
            }
        }
        return ans;
    }
}
