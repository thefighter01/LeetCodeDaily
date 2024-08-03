/**
 * @param {number[]} target
 * @param {number[]} arr
 * @return {boolean}
 */
var canBeEqual = function(target, arr) {
    const mx = arr.reduce((p , cur)=> cur > p ? cur : p , 0);
    const fa = Array.from({length : mx+1} , ()=> 0);
    const fb = Array.from({length : mx+1} , ()=>0);
    for (const ch of arr) fa[ch]++;
    for (const ch of target) if (ch <= mx) fb[ch]++;

    for (let i = 0; i <= mx; ++i) if (fa[i] != fb[i]) return false;
    return true;
};
