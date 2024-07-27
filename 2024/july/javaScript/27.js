/**
 * @param {string} source
 * @param {string} target
 * @param {character[]} original
 * @param {character[]} changed
 * @param {number[]} cost
 * @return {number}
 */
var minimumCost = function(source, target, original, changed, cost) {
    let f = new Array(26);
    function floyed(){
       for (let k = 0; k < 26; ++k){
        for (let j = 0; j < 26; ++j){
            for (let i = 0; i < 26; ++i){
                f[i][j] = Math.min(f[i][j] , f[i][k] + f[k][j]);
            }
        }
       }
    };

    const convert = a => a.charCodeAt(0)-97;
   
        for (let i = 0; i < 26; ++i) {
            f[i] = Array.from({length : 26} , (_ , k) => 1e10+5);
         
            f[i][i] = 0;
        }
        let sz = changed.length;
        for (let i = 0; i < sz; ++i){
            let from = convert(original[i]);
            let to = convert(changed[i]);
          
            f[from][to] = Math.min(f[from][to] , cost[i]);
        }
        floyed();
        sz = source.length;
        let ans = 0;
        for (let i = 0; i < sz; ++i){
            let from = convert(source[i]);
            let to = convert(target[i]);
            if (f[from][to] >= 1e10+5) return -1;
          
            ans+= f[from][to];
        }
        return ans;
};
