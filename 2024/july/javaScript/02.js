/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function(a, b) {
    const sz1 = a.length;
    const sz2 = b.length;
    const f1  = [];
    const f2 = [];
    for (let i = 0; i<= 1000; ++i) f1[i] = f2[i] = 0;
    for (let i = 0; i < sz1; ++i) f1[a[i]]++;
    for(let i = 0; i < sz2; ++i) f2[b[i]]++;

    const ans = [];
    for (let i = 0; i <= 1000; ++i){
        const cur = Math.min(f1[i] , f2[i]);
        for(let k = 0; k < cur; ++k) ans.push(i);
    }


    return ans;
    
    
};
