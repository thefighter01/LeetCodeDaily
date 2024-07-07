/**
 * @param {number} numBottles
 * @param {number} numExchange
 * @return {number}
 */
var numWaterBottles = function(numBottles, numExchange) {
    function solve(n ,  d ,  rem){
        let extra = Math.trunc((rem + n) / d);
        if (extra == 0) return 0;
        return extra + solve( extra , d ,(n + rem) % d);
    }
    
    return numBottles + solve(numBottles , numExchange , 0);
};
