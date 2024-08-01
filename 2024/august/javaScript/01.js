/**
 * @param {string[]} details
 * @return {number}
 */
var countSeniors = function(details) {
    const solve = function(s){
        let age = 0;
        for (let i = 11; i <= 12; ++i){
            age = age * 10 + (s[i]-'0');
        }
        return age > 60 ? 1 : 0;
    };
   
        let ans = 0;
        for (const cur of details){
            ans+= solve(cur);
        }
        return ans;
};
