/**
 * @param {string} s
 * @return {string}
 */
var reverseParentheses = function(s) {
    const sz = s.length;
    let ans = "";

    const reverseAndReplace = function( st , end , ans){
        ++end;
        const before = ans.substring(0 , st);
        let toChange = ans.substring(st , end);
        const after = ans.substring(end);
        toChange = toChange.split('').reverse().join('');
        return before + toChange+ after;
    };
    let pre = [];
    let cnt = 0;
    let st = [];
    for (let i = 0; i < sz; ++i){
        const c = s[i];
        if (c == '('){
            st.push(i);
            pre[i] = ++cnt;
        }else if (c == ')'){
            pre[i] = ++cnt;
            let popedElement = st.pop();
            ans = reverseAndReplace(popedElement-pre[popedElement]+1 , i-pre[i] , ans);
             
        }else{
           ans+= c;
        }
        pre[i] = cnt;
    }
    return ans;
    
};
