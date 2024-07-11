class Solution {
    private void reverseAndReplace(int st , int end , StringBuilder ans){
        ++end;
        ans.replace(st, end, new StringBuilder(ans.substring(st, end)).reverse().toString());
    }
    public String reverseParentheses(String s) {
        var st = new Stack<Integer>();
        var ans = new StringBuilder();
        int cnt = 0;
        final int sz = s.length();
        var pre = new int [sz];
      
        for (int i = 0; i < sz; ++i){
            char c = s.charAt(i);
            if (c == '('){
                st.push(i);
                pre[i] = ++cnt;
            }else if (c == ')'){
                pre[i] = ++cnt;
                int popedElement = st.pop();
               reverseAndReplace(popedElement-pre[popedElement]+1 , i-pre[i] , ans);
             
            }else{
                ans.append(c);
            }
            pre[i] = cnt;
        }
        return ans.toString();
        
    }
}
