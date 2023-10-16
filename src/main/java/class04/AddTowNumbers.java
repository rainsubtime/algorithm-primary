package class04;

// 测试链接：https://leetcode.com/problems/add-two-numbers/
public class AddTowNumbers {

    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        int len1 = listLength(head1);
        int len2 = listLength(head2);
        ListNode l = len1 >= len2 ? head1 : head2;
        ListNode s = l == head1 ? head2 : head1;
        ListNode curL = l;
        ListNode curS = s;
        ListNode last = l;
        int carry = 0;
        int curNum = 0;
        while( curL != null && curS != null) {
            curNum = (curL.val + curS.val + carry) % 10;
            carry = (int)(curL.val + curS.val + carry) / 10;
            curL.val = curNum;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        while( curL != null && curS == null){
            curNum = (curL.val + carry) % 10;
            carry = (int)(curL.val + carry) / 10;
            curL.val = curNum;
            last = curL;
            curL = curL.next;
        }
        if (curL == null && curS == null){
            last.next = carry != 0 ? new ListNode(1) : null;
        }
        return l;
    }

    // 求链表长度
    public static int listLength(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum++;
            head = head.next;
        }
        return sum;
    }

    //打印链表
    public static void printListNode(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode ans = addTwoNumbers(listNode, listNode2);
        printListNode(ans);
    }
}