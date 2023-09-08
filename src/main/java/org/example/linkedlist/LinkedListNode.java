package org.example.linkedlist;

public class LinkedListNode<T> {
    private final T value;
    private LinkedListNode next;

    public LinkedListNode(T value) {
        this.value = value;
    }

    public LinkedListNode(T value, LinkedListNode next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public LinkedListNode getNext() {
        return this.next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}
