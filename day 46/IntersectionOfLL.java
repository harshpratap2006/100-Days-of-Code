public class IntersectionOfLL {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // detecting cycle method 
    public static ListNode findstartingPointofCycle(ListNode head){
        if(head == null || head.next == null) return null;

        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(slow != fast && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow != fast) return null;

        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // detecting cycle method
        if(headA == null || headB == null) return null;

        ListNode temp = headA;

        while(temp.next != null){
            temp = temp.next;
        }

        // temp is at tail
        temp.next = headB;
        ListNode ans = findstartingPointofCycle(headA);

        // fixing the LL again
        temp.next = null;

        return ans;
    }

    public static void main(String[] args) {

        // Common part of both linked lists
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // List A
        // 4 → 1 → 8 → 4 → 5
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // List B
        // 5 → 6 → 1 → 8 → 4 → 5
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        // Find intersection
        ListNode intersection = getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection at node: " + intersection.val);
        } else {
            System.out.println("No intersection");
        }
    }

}
