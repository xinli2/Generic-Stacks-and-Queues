/*
 * program name: ListQueue.java
 * author: Xin Li
 * email: xinli2@email.arizona.edu
 */

public class ListQueue<E> implements QueueInterface<E> {
    /*
     * This program is to implementation of a queue backed by a
     * linked list and make these implementations generic.
     */

    private class Node<E> {

        private E val;
        private Node<E> next;

        Node(E value) {
            val = value;
            next = null;
        }

    }

    private int size;
    private Node<E> prevNode;
    private Node<E> nextNode;

    public ListQueue() {
        size = 0;
        prevNode = null;
        nextNode = null;
    }

    public ListQueue(ListQueue<E> copy) {
        size = copy.size;
        prevNode = copy.prevNode;
        nextNode = copy.nextNode;
    }

    public void enqueue(E value) {
        Node<E> node = new Node<E>(value);
        if (nextNode == null) {
            prevNode = node;
            nextNode = node;
        } else {
            nextNode.next = node;
            nextNode = node;
        }
        size++;
    }

    public E dequeue() {
        E result = prevNode.val;
        prevNode = prevNode.next;
        size--;
        return result;
    }

    public E peek() {
        return prevNode.val;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        prevNode = null;
        nextNode = null;
    }

    public String toString() {
        if (prevNode == null) {
            return "{}";
        }
        Node<E> temp = prevNode;
        String result = "";
        for (int i = 0; i < size - 1; i++) {
            result += temp.val + ",";
            temp = temp.next;
        }
        result += temp.val;
        return "{" + result + "}";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ListQueue)) {
            return false;
        }
        ListQueue<E> temp = (ListQueue<E>) obj;
        if (size != temp.size) {
            return false;
        }
        Node<E> tempNode = prevNode;
        for (int i = 0; i < size; i++) {
            if (tempNode.val != temp.prevNode.val) {
                return false;
            }
            tempNode = tempNode.next;
            temp.prevNode = temp.prevNode.next;
        }
        return true;
    }

}
