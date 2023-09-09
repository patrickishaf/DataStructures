package org.example.doublylinkedlist;

import java.util.ArrayList;

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

    public ArrayList<T> getValues() {
        ArrayList<T> values = new ArrayList<>();
        if (this.length == 0) return values;
        DoublyLinkedListNode<T> currentNode = this.head;
        do {
            values.add(currentNode.getValue());
            currentNode = currentNode.getNext();
        } while (currentNode != null);
        return values;
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

    public boolean insertFirstNode(DoublyLinkedListNode<T> newNode) {
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setNext(this.head);
            this.head.setPrevious(newNode);
            this.head = newNode;
        }
        this.increaseLength();
        return true;
    }

    public boolean insertFirstValue(T value) {
        DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(value);
        return this.insertFirstNode(newNode);
    }

    public boolean insertNode(DoublyLinkedListNode<T> newNode, int index) {
        if (index == 0) {
            return this.insertFirstNode(newNode);
        }
        DoublyLinkedListNode<T> previousNode = this.head;
        for (int i = 0; i < index; i++) {
            if (i != 0) {
                previousNode = previousNode.getNext();
            }
        }
        newNode.setNext(previousNode.getNext());
        previousNode.getNext().setPrevious(newNode); // Test that the previous value of ths node is correct
        previousNode.setNext(newNode);
        newNode.setPrevious(previousNode); // Test that the previous value of this node is correct
        this.increaseLength();
        return true;
    }

    public boolean insertValue(T value, int index) {
        DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(value);
        return this.insertNode(newNode, index);
    }

    public DoublyLinkedListNode<T> removeFirstNode() {
        if (this.length == 0) return null;
        DoublyLinkedListNode<T> removedNode = this.head;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = removedNode.getNext();
            removedNode.setNext(null);
            this.head.setPrevious(null); // Test that this node's previous value is correct
        }
        this.decreaseLength();
        return removedNode;
    }

    public T removeFirstValue() {
        return this.removeFirstNode().getValue();
    }

    public DoublyLinkedListNode<T> removeLastNode() {
        if (this.length == 0) {
            return null;
        }
        DoublyLinkedListNode<T> removedNode = this.tail;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
            this.decreaseLength();
            return removedNode;
        }
        this.tail = removedNode.getPrevious();
        this.tail.setNext(null);
        removedNode.setPrevious(null);
        decreaseLength();
        return removedNode;
    }

    public T removeLastValue() {
        return this.removeLastNode().getValue();
    }

    public DoublyLinkedListNode<T> removeNode(int index) {
        if (this.length == 0 || index >= this.length) return null;
        if (index == 0) return this.removeFirstNode();
        if (index == this.length - 1) return this.removeLastNode();
        DoublyLinkedListNode<T> currentNode = this.head;
        for (int i = 0; i <= index; i++) {
            if (i != 0) {
                currentNode = currentNode.getNext();
            }
        }
        currentNode.getPrevious().setNext(currentNode.getNext());
        currentNode.getNext().setPrevious(currentNode.getPrevious());
        currentNode.setPrevious(null);
        currentNode.setNext(null);
        this.decreaseLength();
        return currentNode;
    }

    public T removeValue(int index) {
        DoublyLinkedListNode<T> removedNode = this.removeNode(index);
        if (removedNode == null) { // If I don't do this check, this method might throw a NullPointer
            return null;
        }
        return removedNode.getValue();
    }

    public DoublyLinkedList<T> reverse() {
//        TODO: Implement reverse
        return null;
    }
}
