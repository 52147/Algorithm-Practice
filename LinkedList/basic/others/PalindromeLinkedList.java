import LinkedList.basic.creation
import LinkedList.basic.creation-deletion.ListNode;
import LinkedList.basic.creation-deletion.ListNode;-deletion.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        // Move fast pointer by 2 steps and slow pointer by 1 step to find the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reset fast to the head of the list
        slow = reverse(slow);
        fast = head;
        // Compare the first half and the reversed second half
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp;
        }

        return prev;
    }
}
