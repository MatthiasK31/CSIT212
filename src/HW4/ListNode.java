/*
Matthias Kim
HW4 - Queue/Stack/LinkedList
3/3/23
 */

package HW4;

public class ListNode {
    public int key;
    public ListNode prev;
    public ListNode next;

    public ListNode () {
        prev = next = null;
    }

    public ListNode (int _key) {
        key = _key;
        prev = next = null;
    }
}
