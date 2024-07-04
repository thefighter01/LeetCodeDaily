/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var mergeNodes = function(head) {
    let  sum = 0;
    function solve(head){
        if (head == null) return null;

        let cur = solve(head.next);
        sum+= head.val;
        if (head.val == 0 && head.next != null){
            let ret = new ListNode(sum);
            ret.next = cur;
            sum = 0;
            return ret;
        }
        return cur;
    }
    return solve(head);
    
};
