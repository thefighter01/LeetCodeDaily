**
 * @param {number[]} arr
 * @return {boolean}
 */
var threeConsecutiveOdds = function(a) {
    let sz = a.length;
    let count = 0;
    for (let i = 0; i < sz; ++i){
        if (a[i] & 1) count++;
        if (count >= 3) return true;
        if (!(a[i] & 1)) count = 0;
    }
    return false;
    
};
