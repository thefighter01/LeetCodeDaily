/**
 * @param {number[][]} books
 * @param {number} shelfWidth
 * @return {number}
 */
var minHeightShelves = function(books, shelfWidth) {
        const n = books.length;
        const dp = new Array(n+1).fill(1e7);
        dp[n] = 0;
        for (let i = n-1; i >= 0; --i){
            let curSum =0;
            let mx = 0;
            for (let k = i; k < n && curSum+ books[k][0] <= shelfWidth ; ++k){
                mx = Math.max(mx , books[k][1]);
                curSum+=books[k][0];
                dp[i] = Math.min(dp[i] , mx + dp[k+1]);
            }
        }
        return dp[0];
};
