package org.example.ring;

public class RingNode<T> {
    final T value;
    RingNode next;

    public RingNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public RingNode<T> getNext() {
        return next;
    }

    public void setNext(RingNode<T> next) {
        this.next = next;
    }
}
