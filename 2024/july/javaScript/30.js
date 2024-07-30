/**
 * @param {string} s
 * @return {number}
 */
var minimumDeletions = function(s) {
    let bCount = 0;
    const n = s.length;
    const dp = Array.from({length : n+1} , ()=> 0);
    
   
    for (let i = 0; i < n; ++i){
        if (s[i] === 'a'){
            dp[i+1] = Math.min(dp[i]+1 , bCount);
        }else {
            dp[i+1] = dp[i];
            bCount++;
        }
    }
    return dp[n];
    
};
