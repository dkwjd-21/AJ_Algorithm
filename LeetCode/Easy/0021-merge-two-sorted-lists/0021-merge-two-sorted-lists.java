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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 이동하면서 저장할 값
        ListNode answer = new ListNode();
        // 가장 첫번째 헤드
        ListNode head = answer;

        if(list1 == null && list2 == null) return null;

        while(list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;

            if(val1 < val2) {
                answer.val = val1;
                list1 = list1.next;
            } else {
                answer.val = val2;
                list2 = list2.next;
            }

            answer.next = new ListNode();
            answer = answer.next;
        }

        if(list1 != null) {
            while(list1 != null) {
                answer.val = list1.val;
                
                list1 = list1.next;
                
                if (list1 != null) {
                    answer.next = new ListNode();
                    answer = answer.next;
                }
            }
        } else if(list2 != null) {
            while(list2 != null) {
                answer.val = list2.val;

                list2 = list2.next;

                if (list2 != null) {
                    answer.next = new ListNode();
                    answer = answer.next;
                }
            }
        }

        return head;

    }
}