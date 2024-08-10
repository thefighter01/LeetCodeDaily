/**
 * @param {number} rows
 * @param {number} cols
 * @param {number} rStart
 * @param {number} cStart
 * @return {number[][]}
 */
var spiralMatrixIII = function(rows, cols, rSt, cSt) {
    let  dx = [0 , 1, 0 , -1];
    let  dy = [1 , 0 , -1 , 0];

   
        // 0 east
        // 1 south
        // 2 west
        // 3 north

        let ans = Array.from({ length: rows * cols }, () => Array.from({length : 2} , ()=> 0));

        

        let sz = 0;
        let dir = 0;
        for (let state = 1; sz < rows * cols; ++state){
            for (let k = 0; k < 2; ++k){
                for (let i = 0; i < state; ++i){
                    
                    if (rSt >= 0 && cSt >= 0 && rSt < rows && cSt < cols){
                        ans[sz][0] = rSt;
                        ans[sz][1] = cSt;
                        ++sz;

                    }
                    rSt+=dx[dir];
                    cSt+=dy[dir];
                   
                }
                dir = (dir + 1) % 4;
           
            }
        }
        return ans;
};
