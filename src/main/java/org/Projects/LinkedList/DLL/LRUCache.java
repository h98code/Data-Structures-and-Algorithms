package org.Projects.LinkedList.DLL;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private class Node<T> {
        T key;
        T val;
        Node<T> next;
        Node<T> prev;

        Node(T key, T val){
            this.key = key;
            this.val = val;
        }
    }

    Node<Integer> head = new Node(-1, -1);
    Node<Integer> tail = head;
    Map<Integer, Node<Integer>> hmp = new HashMap<>();
    int size;
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        if(hmp.containsKey(key)) {
            Node<Integer> curr = hmp.get(key);
            moveNodeToEnd(curr);
            return curr.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(hmp.containsKey(key)) { // updating the existing key
            Node<Integer> curr = hmp.get(key);
            curr.val = value;
            moveNodeToEnd(curr);
        } else {
            Node<Integer> nn = new Node(key, value);

            hmp.put(key, nn); // adding the node to the hashmap
            appendNodeToEnd(nn);

            if(size == cap) {
                hmp.remove(head.next.key); // remove the node from the hashmap
                deleteFirstNode();
            }

            if(size < cap) size++;
        }
    }

    private void moveNodeToEnd(Node<Integer> curr) {

        if(curr.next != null) {
            //extract the node from the list
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            curr.next = null;
            curr.prev = null;

            appendNodeToEnd(curr);
        }
    }

    private void appendNodeToEnd(Node<Integer> curr) {
        tail.next = curr;
        curr.prev = tail;
        tail = curr;
    }

    private void deleteFirstNode() {
        head.next = head.next.next;
        head.next.prev = head;
    }
}
