/**
 * @param {number} n
 * @param {number} time
 * @return {number}
 */
var passThePillow = function(n, time) {
    const times = Math.floor(time / (n-1));
    const rem = time % (n-1);

    return (times & 1)  > 0 ? n- rem : rem+1 ;
    
};
