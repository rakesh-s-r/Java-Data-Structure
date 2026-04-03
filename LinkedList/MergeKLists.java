package LinkedList;

import java.util.*;

public class MergeKLists {
    public static void main(String[] args) {
        System.out.println("Executing programming...");
        ListNode[] listNodes = new ListNode[] {new ListNode(1), new ListNode(2), new ListNode(3)};
        System.out.println(MergeKLists(listNodes).val);
    }

    public static ListNode MergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        while (lists.length > 1) {
            List<ListNode> mergeList = new ArrayList<>();

            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1) < lists.length ? lists[i + 1] : null;
                mergeList.add(mergeList(l1, l2));
            }
            System.out.println(mergeList);
            lists = mergeList.toArray(new ListNode[mergeList.size()]);
        }
        return lists[0];
    }

    public static ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null) {
            cur.next = l1;
        }
        if(l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }
}
