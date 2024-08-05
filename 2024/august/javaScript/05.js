/**
 * @param {string[]} arr
 * @param {number} k
 * @return {string}
 */
var kthDistinct = function(arr, k) {
        let f = new Map();
        for (const ch of arr){
            if (f.has(ch)){
                f.set(ch, f.get(ch)+1);
            }else {
                f.set(ch , 1);
            }

        }
        for (const cur of arr){
            let cnt = f.get(cur);
            if (cnt == 1) --k;
            if (k == 0) return cur;
        }
        return "";
};
