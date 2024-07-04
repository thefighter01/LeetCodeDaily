/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private static int sum = 0;
    private ListNode solve(ListNode head){
        if (head == null) return null;

        ListNode cur = solve(head.next);
        sum+= head.val;
        if (head.val == 0 && head.next != null){
            ListNode ret = new ListNode(sum);
            ret.next = cur;
            sum = 0;
            return ret;
        }
        return cur;
    }
    public ListNode mergeNodes(ListNode head) {

        return solve(head);
    }
}
