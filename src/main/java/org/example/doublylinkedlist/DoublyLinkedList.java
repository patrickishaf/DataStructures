package org.example.doublylinkedlist;

public class DoublyLinkedList<T> {
    DoublyLinkedListNode<T> head;
    DoublyLinkedListNode<T> tail;
    int length = 0;

    public DoublyLinkedList() {}

    public DoublyLinkedList(T initialValue) {
        DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode(initialValue);
        this.head = newNode;
        this.tail = newNode;
        this.increaseLength();
    }

    public DoublyLinkedList(DoublyLinkedListNode<T> initialNode) {
        this.head = initialNode;
        this.tail = initialNode;
        this.increaseLength();
    }

    private void increaseLength() {
        this.length++;
    }

    private void decreaseLength() {
        if (this.length == 0) {
            return;
        }
        this.length--;
    }

    public boolean appendNode(DoublyLinkedListNode<T> newNode) {
        if (this.length == 0) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
            newNode.setPrevious(this.tail);
        }
        this.tail = newNode;
        this.increaseLength();
        return true;
    }

    public boolean appendValue(T value) {
        return this.appendNode(new DoublyLinkedListNode<T>(value));
    }
}
