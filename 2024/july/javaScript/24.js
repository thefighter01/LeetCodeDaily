/**
 * @param {number[]} mapping
 * @param {number[]} nums
 * @return {number[]}
 */
var sortJumbled = function(mp, nums) {
     function convert(mp ,  a){
        let ans = 0;
        var cur = String(a);
        let sz = cur.length;
        for (let i = 0; i < sz; ++i){
            ans = ans * 10 + mp[(cur.charAt(i)-'0')];
        }
        return ans;

    }
   
        // non-decreasing
        let n = nums.length;
        var f = new Array(n).fill(0);
        for (let i = 0; i < n; ++i) f[i] = nums[i];

        f.sort(( a ,  b)=>{
                let idA = convert(mp ,a);
                let idB = convert(mp , b);
                return idA - idB;
        });
        for (let i = 0; i < n; ++i) nums[i] = f[i];
        return nums;
        
};
