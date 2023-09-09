package org.example.doublylinkedlist;

public class DoublyLinkedListNode<T> {
    final T value;
    DoublyLinkedListNode<T> previous;
    DoublyLinkedListNode<T> next;

    public DoublyLinkedListNode(T initialValue) {
        this.value = initialValue;
    }

    public T getValue() {
        return value;
    }

    public DoublyLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListNode<T> next) {
        this.next = next;
    }

    public DoublyLinkedListNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLinkedListNode<T> previous) {
        this.previous = previous;
    }
}
