/*
 * program name: ListStack.java
 * author: Xin Li
 * email: xinli2@email.arizona.edu
 */

public class ListStack<E> implements StackInterface<E> {
    /*
     * This program is to Implementation of a stack backed by a
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
    private Node<E> cur;

    public ListStack() {
        cur = null;
        size = 0;
    }

    public ListStack(ListStack<E> copy) {
        cur = copy.cur;
        size = copy.size;
    }

    public void push(E value) {
        Node<E> node = new Node<E>(value);
        if (cur == null) {
            cur = node;
        } else {
            node.next = cur;
            cur = node;
        }
        size++;
    }

    public E pop() {
        E result = cur.val;
        cur = cur.next;
        size--;
        return result;
    }

    public E peek() {
        return cur.val;
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
        cur = null;
        size = 0;
    }

    public String toString() {
        if (cur == null) {
            return "{}";
        }
        Node<E> temp = cur;
        String result = "";
        result += temp.val;
        for (int i = 0; i < size - 1; i++) {
            temp = temp.next;
            result = temp.val + "," + result;
        }
        return "{" + result + "}";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ListStack)) {
            return false;
        }
        ListStack<E> temp = (ListStack<E>) obj;
        if (size != temp.size) {
            return false;
        }
        Node<E> tempNode = cur;
        for (int i = 0; i < size; i++) {
            if (tempNode.val != temp.cur.val) {
                return false;
            }
            tempNode = tempNode.next;
            temp.cur = temp.cur.next;
        }
        return true;
    }

}
