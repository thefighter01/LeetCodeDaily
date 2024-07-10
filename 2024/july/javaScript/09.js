/**
 * @param {string[]} logs
 * @return {number}
 */
var minOperations = function(logs) {
        let cnt = 0;
        for (const item of logs){
            let dots = 0;
            for (const ch of item){
                dots+=(ch == '.');
            }
            cnt += (dots == 2 ? -1 : (dots == 1) ? 0 : 1);
            cnt = Math.max(0 , cnt);
        }
        return cnt;
};
