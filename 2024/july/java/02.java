class Solution {
    private static int SZ;
    private int solveOneStep(int [] uniq){
        return Math.min(uniq[SZ-1]- uniq[1] , uniq[SZ-2] - uniq[0]);
    } 

    private int solveTwoSteps(int [] uniq){
        return Math.min(Math.min(uniq[SZ-3]-uniq[0] , uniq[SZ-1] - uniq[2]) , uniq[SZ-2] - uniq[1]);
    }

    private int solveThreeSteps(int [] uniq){
        return Math.min(Math.min(uniq[SZ-2]-uniq[2] , uniq[SZ-3]-uniq[1]) , Math.min(uniq[SZ-1]-uniq[3] , uniq[SZ-4]-uniq[0]));
    }
    public int minDifference(int[] a) {
        Arrays.sort(a);
        SZ = a.length;
        if (SZ <= 4) return 0;
        return Math.min(solveOneStep(a) , Math.min(solveTwoSteps(a) , solveThreeSteps(a)));
    }
}
