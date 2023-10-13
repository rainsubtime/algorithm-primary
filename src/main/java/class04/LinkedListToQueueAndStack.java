package class04;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class04
 * @Author: cywork
 * @CreateTime: 2023-09-27  13:53
 * @Description: TODO
 * @Version: 1.0
 */
public class LinkedListToQueueAndStack {

    public static class Node<V> {
        public Node next;
        public V value;
        Node(V value){
            this.value = value;
            this.next = null;
        }
    }

    public class MyQueue<V>{

        int size;
        private Node<V> head;
        private Node<V> tail;

        public MyQueue(){
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void offer(V value){
            Node<V> cur = new Node<>(value);
            if(head == null){
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = tail.next;
            }
            size ++;
        }

        public V poll(){
            V ans = null;
            if(head == null){
                tail = null;
            }
            if(head != null){
                ans = head.value;
                head = head.next;
                size --;
            }
            return ans;
        }
    }

    public class MyStuck<V>{
        private int size;
        private Node<V> head;

        MyStuck(){}

        public boolean isEmpty(){
            return size == 0;
        }

        public int size(){
            return size;
        }

        public void offer(V value){
            Node<V> node = new Node<>(value);
            if(head == null){
                head = node;
            }else {
                node.next = head;
                head = node;
            }
            size ++;
        }

        public V poll(){
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size --;
            }
            return ans;
        }

    }
    public static void main(String[] args) {

    }


}
