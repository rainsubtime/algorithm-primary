package class04;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class04
 * @Author: cywork
 * @CreateTime: 2023-09-27  10:29
 * @Description: TODO
 * @Version: 1.0
 */
public class ReverseLinkList {

    public static class Node {
        public Node next;
        public int value;
        Node(int value){
            this.value = value;
            this.next = null;
        }
    }

    private static class DoubleNode {
        DoubleNode next;
        DoubleNode pre;
        int value;
        DoubleNode(int value){
            this.value = value;
        }
    }
    public static void main(String[] args) {
        int maxLen = 10;
        int maxValue = 10;
        //Node node = randomValueRandomLen(maxLen, maxValue);
        //pringLinkList(node);
        //Node reverse = reverse(node);
        //System.out.println();
        //pringLinkList(reverse);

    }




    public static void pringLinkList(Node head){
        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public static Node randomValueRandomLen(int maxLen,int maxValue){
        Node head = new Node((int)(Math.random() * maxValue));
        Node node = head;
        int len = (int)(Math.random() * maxLen + 1);
        for (int i = 0;i < len;i ++){
            int value = (int)(Math.random() * maxValue);
            node.next = new Node(value);
            node = node.next;
        }
        return head;
    }

    private static Node reverse(Node head){
        Node temp = null;
        Node pre = null;
        while(head != null){
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    private static DoubleNode reverse(DoubleNode head){
        DoubleNode next = null;
        DoubleNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }



}
