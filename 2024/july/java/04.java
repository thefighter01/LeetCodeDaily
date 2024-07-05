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
    private static int [] ans ;
    private static int last;
    private static int first;
    private boolean isOk(int a , int b , int c){
        return b > Math.max(a , c) || b < Math.min(a , c);
    }
    Solution(){
        ans = new int [2];
        ans[0] = (int)1e5+5;
        ans[1] = 0;
        last = first = -1;
    }
    private void solve(int i , ListNode head , int pre ){
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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        solve(0 , head , -1);
        if (ans[1] == 0) ans[0] = ans[1] = -1;
        return ans;
        
    }
}
