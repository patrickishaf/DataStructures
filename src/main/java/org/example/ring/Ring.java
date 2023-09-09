package org.example.ring;


public class Ring<T> {
    RingNode<T> head;
    RingNode<T> tail;
    int length = 0;

    public Ring() {}

    public Ring(T initialValue) {
        RingNode<T> newNode = new RingNode(initialValue);
        this.head = newNode;
        this.tail = newNode;
        this.increaseLength();
    }

    public Ring(RingNode<T> initialNode) {
        this.head = initialNode;
        this.tail = initialNode;
        this.increaseLength();
    }

    private void increaseLength() {
        this.length++;
    }

    private void reduceLength() {
        if (this.length == 0) return;
        this.length--;
    }

    public boolean appendNode(RingNode<T> newNode) {
        if (this.length == 0) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
        this.increaseLength();
        return true;
    }

    public boolean appendValue(T value) {
        RingNode<T> newNode = new RingNode(value);
        return this.appendNode(newNode);
    }
}
