/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {number[]}
 */
var nodesBetweenCriticalPoints = function(head) {
    let ans = [1e5 , 0];
    let last , first; last = first = -1;
    
    function  isOk( a , b , c){
        return b > Math.max(a , c) || b < Math.min(a , c);
    }
    
    function solve( i ,head ,  pre ){
        if (head == null) return;

        if (pre!= -1 && head.next != null){
            if (isOk(pre , head.val , head.next.val)){
                if (last != -1){
                    ans[0] = Math.min(ans[0] , i - last);
                    last = i;
                }
                else last = i;


                if (first != -1){
                    ans[1] = Math.max(ans[1] , i - first);
                } else first = i;
            }
        }
        solve(i+1 , head.next , head.val);

    }
    solve(0 , head , -1);
    if (ans[1] == 0) ans[0] = ans[1] = -1;
    return ans;
    
};
