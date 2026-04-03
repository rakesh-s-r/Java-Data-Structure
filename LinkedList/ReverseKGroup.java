package LinkedList;

public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode l = reverseKGroup(list, 3);
        while (l != null) {
            System.out.println(l.val + " -> ");
            l = l.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while(true) {
            ListNode kthNode = getKthNode(groupPrev, k);
            System.out.println(kthNode);
            if(kthNode == null) {
                break;
            }
            ListNode groupNext = kthNode.next;

            ListNode prev = groupNext;
            ListNode cur = groupPrev.next;
            while(cur != groupNext) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }

            ListNode temp = groupPrev.next;
            groupPrev.next = kthNode;
            groupPrev = temp;
        }
        return dummy.next;
    }

    public  static ListNode getKthNode(ListNode node, int k) {
        ListNode cur = node;
        while(cur != null && k > 0) {
            System.out.println("loop " + cur.val);
            cur = cur.next;
            k-=1;
            System.out.println(k);
        }
        return cur;
    }
}
