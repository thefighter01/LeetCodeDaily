/**
 * @param {string} word
 * @return {number}
 */
var minimumPushes = function(word) {
      let f = Array.from({length: 26} , ()=>0);

        const value =function (a){
          return a.charCodeAt(0)-97;
        };
        for (const ch of word){
          f[value(ch)]++;
        }

        const id = Array.from({length : 26} , (_ , i)=> i);
      id.sort((a, b) => f[b]-f[a]);
      let k = 0;
      let current = 1;
      let ans = 0;
      for (const cur of id){
        ++k;
        if (k == 9){
            ++current;
            k = 1;
        }
        ans+= f[cur] * current;
      }
      return ans;
};
