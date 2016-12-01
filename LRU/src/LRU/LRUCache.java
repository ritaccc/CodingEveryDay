package LRU;

import java.util.HashMap;

/**
 * Created by feideng on 6/22/16.
 */
public class LRUCache {

    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
    }
    public void addToHead(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next = node;
        node.next.pre = node;
    }
    public void deleteNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    public int get(int key) {
        if(map.get(key) != null) {
            Node tmp = map.get(key);
            int result = tmp.value;
            deleteNode(tmp);
            addToHead(tmp);
            return result;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }else {
            Node node = new Node(key, value);
            map.put(key, node);
            if(map.size() - 1 < capacity) {
                addToHead(node);
            }else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }
}
