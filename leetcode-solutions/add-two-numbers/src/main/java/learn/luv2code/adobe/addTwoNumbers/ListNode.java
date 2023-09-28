package learn.luv2code.adobe.addTwoNumbers;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
