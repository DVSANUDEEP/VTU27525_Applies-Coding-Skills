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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the linked list using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        ListNode secondHalfHead = reverseList(slow);
        ListNode copySecondHalf = secondHalfHead; // Keep a reference to restore later if needed

        // Step 3: Compare the first half and the reversed second half
        ListNode firstHalfHead = head;
        boolean isPalin = true;
        while (secondHalfHead != null) {
            if (firstHalfHead.val != secondHalfHead.val) {
                isPalin = false;
                break;
            }
            firstHalfHead = firstHalfHead.next;
            secondHalfHead = secondHalfHead.next;
        }

        // Optional Step 4: Restore the list (good practice)
        reverseList(copySecondHalf);

        return isPalin;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}