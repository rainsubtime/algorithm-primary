package class04;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class04
 * @Author: cywork
 * @CreateTime: 2023-10-01  14:31
 * @Description: TODO
 * @Version: 1.0
 */
public class LinkedListToDoubleQueue {

    //1. Create Double Node
    public class DoubleNode<V>{
        public DoubleNode<V> next;
        public DoubleNode<V> last;
        public V value;

        public DoubleNode(){}
        public DoubleNode(V value){
            this.value = value;
        }
    }


    public class MyDoubleQueue<V>{
        DoubleNode<V> head;
        DoubleNode<V> tail;
        int size;

        //2. isEmpty？
        public boolean isEmpty(){
            return size == 0;
        }

        //3. size
        public int getSize(){
            return size;
        }

        //4. pushHead
        public void pushHead(V value){
            DoubleNode<V> node = new DoubleNode<>(value);
            if(head == null) {
                head = node;
                tail = node;
            }else {
                head.next = node;
                node.last = head;
                head = node;
            }
            size ++;
        }

        //5. pushTail
        public void pushTail(V value){
            DoubleNode<V> node = new DoubleNode<>(value);
            if(tail == null){
                head = node;
                tail = node;
            }else {
                tail.next = node;
                tail = node;
                node.next = tail;
            }
            size ++;
        }

        //6. pullHead
        public V pullHead(){
            V ans = null;
            if(head == null){
                return ans;
            }
            size --;
            if(head == tail){
                ans = head.value;
                head = null;
                tail = null;
            }else{
                ans = head.value;
                head = head.last;
                head.next = null;
            }
            return ans;
        }
        //7. pullTail

        //8. peekHead

        //9. peekTail
    }

    public static void main(String[] args) {
    }

    //
}
