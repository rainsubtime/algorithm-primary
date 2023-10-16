package class04;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class04
 * @Author: cywork
 * @CreateTime: 2023-10-16  18:28
 * @Description: TODO
 * @Version: 1.0
 */
public class MergeTwoSortedLinkedList {

    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if(head1 == null || head2 == null){
            return head1 == null ? head2 : head1;
        }
        ListNode head = head1.val <= head2.val ? head1 : head2;
        ListNode pre = head;
        ListNode cur1 = head == head1 ? head1.next : head2.next;
        ListNode cur2 = head == head1 ? head2 : head1;
        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                pre.next = cur1;
                cur1 = cur1.next;
            }else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode ans = mergeTwoLists(listNode, listNode2);
        printList(ans);
    }
}
