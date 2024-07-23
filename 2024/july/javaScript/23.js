/**
 * @param {number[]} nums
 * @return {number[]}
 */
var frequencySort = function(nums) {
        let f = new Map();
        for (const cur of nums){
            if (f.has(cur)) f.set(cur , f.get(cur)+1);
            else f.set(cur , 1);
        }
        const id = Array.from({length : 201} , (_ , i) => i - 100);
        for (let i = -100; i <= 100; ++i) if (!f.has(i)) f.set(i , 0);
       
 
        id.sort((a , b) => {
            let fA = f.get(a , 0);
            let fB = f.get(b , 0);
            if (fA == fB) return b -a;
            return fA - fB;
        });

      
        let n = nums.length;
        let ans = [];
        for (const a of  id){
            if (!f.has(a)) continue;
            let sz = f.get(a);
            for (let i = 0; i < sz; ++i){
               ans.push(a);
            }
        }
        return ans;
};
