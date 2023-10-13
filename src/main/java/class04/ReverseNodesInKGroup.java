package class04;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class04
 * @Author: cywork
 * @CreateTime: 2023-10-01  15:58
 * @Description: TODO
 * @Version: 1.0
 */
public class ReverseNodesInKGroup {

    public static class Node{
        public Node next;
        public int value;
    }

    //return Kth node
    public Node kth(int k, Node start){
        while(k != 0 && start != null){
            start = start.next;
        }
        return start;
    }

    //reverse group
    public void reverseGroup(Node start,Node end){
        end = end.next;
        Node pre = end;
        Node next = null;
        while(next != end){
            next = start.next;
            start.next = pre;
            pre = start;
            start = next;
        }
    }
    //reverse Kgroup

    public Node reversKGroup(Node head, int k){
        Node end = kth(k, head);
        Node start = head;
        if(end == null){
            return head;
        }
        //第一组有了
        reverseGroup(head,end);
        Node lastEnd = head;
        head = end;
        //开始循环处理
        //end初值
        start = lastEnd.next;
        end = kth(k,start);
        while(end != null){
            reverseGroup(start,end);
            lastEnd.next = end;
            start = start.next;
            end = kth(k,start);
        }
        return head;
    }
    //main

}
