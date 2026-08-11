public class IntersectionOfLL {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode getIntersectionNodeBruteForce(ListNode headA, ListNode headB) {

        ListNode tempA = headA;

        while (tempA != null) {

            ListNode tempB = headB;

            while (tempB != null) {

                if (tempA == tempB) {
                    return tempA;
                }

                tempB = tempB.next;
            }

            tempA = tempA.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next; // Intersection at node with value 8

        ListNode intersectionNode = getIntersectionNodeBruteForce(headA, headB);

        if (intersectionNode != null) {
            System.out.println("Intersection at node with value: " + intersectionNode.val);
        } else {
            System.out.println("No intersection.");
        }
    }
}
