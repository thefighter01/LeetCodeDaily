/**
 * @param {string[]} names
 * @param {number[]} heights
 * @return {string[]}
 */
var sortPeople = function(names, heights) {
        let n = names.length;
        let ans = [];
        let id = Array.from({length : n} , (_ , i)=> i);
        id.sort((a , b)=> heights[b]-heights[a]);
        for (let i = 0; i < n; ++i) ans.push(names[id[i]]);
        return ans;

};
