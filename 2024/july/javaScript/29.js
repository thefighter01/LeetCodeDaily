/**
 * @param {number[]} rating
 * @return {number}
 */
var numTeams = function(rating) {
     
    let t;
    const n = rating.length;
    const mx = n+5;
    const cloned = rating.map((ele , i)=> [i , ele] ).sort((a , b)=> a[1]-b[1]);
    for (let i = 0; i < n; ++i){
        rating[cloned[i][0]] = i;
    }

    const init = function(){
       t = new Array(n+6).fill(0);
    }
    

    function upd(i , v){
        ++i;
        while(i <= n){
            t[i]+=v
            i+= i & -i;
        }
    }
    const get = function(i){
        ++i;
        let ans = 0;
        while(i>0){
            ans+= t[i];
            i-= i & -i;
        }
        return ans;
    }
   

    const solve = function(a){
        let ans = 0;
         init();
        for (let i = 0; i < n; ++i){
           let less = get(a[i]);
           let great = n - a[i] -1 - (i - less);
           ans+= less * great;
           upd(a[i] , 1);
        }
        return ans;
    }
    
    
    
    let ans = solve(rating);
    rating.reverse();
    ans+= solve(rating);
    return ans;   
};
