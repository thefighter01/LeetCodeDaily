/**
 * @param {number[]} nums
 * @return {number}
 */
var minDifference = function(a) {
    
     a.sort((aa, bb) => aa - bb);
    const SZ = a.length;
    function solveOneStep(uniq){
        return Math.min(uniq[SZ-1]- uniq[1] , uniq[SZ-2] - uniq[0]);
    } 

    function solveTwoSteps(uniq){
        return Math.min(Math.min(uniq[SZ-3]-uniq[0] , uniq[SZ-1] - uniq[2]) , uniq[SZ-2] - uniq[1]);
    }

    function solveThreeSteps( uniq){
        return Math.min(Math.min(uniq[SZ-2]-uniq[2] , uniq[SZ-3]-uniq[1]) , Math.min(uniq[SZ-1]-uniq[3] , uniq[SZ-4]-uniq[0]));
    }
    if (SZ <= 4) return 0;
    
    return Math.min(solveOneStep(a) , Math.min(solveTwoSteps(a) , solveThreeSteps(a)));
};
