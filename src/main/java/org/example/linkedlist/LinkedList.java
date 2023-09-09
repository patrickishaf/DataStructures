package org.example.linkedlist;

import java.util.ArrayList;

public class LinkedList<T> {
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int length = 0;

    public LinkedList() {}

    public LinkedList(T initialValue) {
        LinkedListNode<T> newNode = new LinkedListNode(initialValue);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public LinkedList(LinkedListNode<T> initialNode) {
        this.head = initialNode;
        this.tail = initialNode;
        this.length = 1;
    }

    public LinkedListNode<T> getHead() {
        return this.head;
    }

    public LinkedListNode<T> getTail() {
        return this.tail;
    }

    private void increaseLength() {
        this.length++;
    }

    private void decreaseLength() {
        if (this.length == 0) return;
        this.length--;
    }

    public int getLength() {
        return this.length;
    }

    public ArrayList<T> getValues() {
        ArrayList<T> values = new ArrayList();
        if (this.length == 0) return values;

        LinkedListNode<T> currentNode = this.head;
        do {
            values.add(currentNode.getValue());
            currentNode = currentNode.getNext();
        } while (currentNode != null);
        return values;
    }

    public void appendNode(LinkedListNode<T> newNode) {
        if (this.length == 0) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
        increaseLength();
    }

    public void appendValue(T value) {
        LinkedListNode<T> newNode = new LinkedListNode(value);
        this.appendNode(newNode);
    }

    public LinkedListNode<T> popNode() {
        LinkedListNode<T> currentNode = this.head;
        if (this.length == 0) {
            return this.tail;
        }
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
            decreaseLength();
            return currentNode;
        }
        for (int i = 1; i < this.length - 1; i++) {
            currentNode = currentNode.getNext();
        }
        LinkedListNode poppedNode = currentNode.getNext();
        currentNode.setNext(null);
        this.tail = currentNode;
        return poppedNode;
    }

    public T popValue() {
        return this.popNode().getValue();
    }

    public LinkedListNode<T> removeFirstNode() {
        if (this.length == 0) {
            return null;
        }
        LinkedListNode<T> removedNode = this.head;
        this.head = this.head.getNext();
        decreaseLength();
        return removedNode;
    }

    public T removeFirst() {
        return this.removeFirstNode().getValue();
    }

    public LinkedListNode<T> removeNode(int index) {
        if (index >= this.length || index < 0) {
            return null;
        }
        if (index == 0) {
            return this.removeFirstNode();
        }
        LinkedListNode<T> previousNode = this.head;
        LinkedListNode<T> currentNode;
        for (int i = 0; i < index; i++) {
            if (i != 0) {
                previousNode = previousNode.getNext();
            }
        }
        currentNode = previousNode.getNext();
        LinkedListNode<T> removedNode = currentNode;
        if (currentNode.getNext() == null) {
            previousNode.setNext(null);
            this.tail = previousNode;
        } else {
            previousNode.setNext(currentNode.getNext());
        }
        decreaseLength();
        return removedNode;
    }

    public T remove(int index) {
        return this.removeNode(index).getValue();
    }

    public LinkedListNode<T> removeLastNode() {
        return this.removeNode(this.length - 1);
    }

    public T removeLast() {
        return this.removeLastNode().getValue();
    }

    public void insertFirstNode(LinkedListNode<T> newNode) {
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else if (this.length == 1) {
            this.head = newNode;
            this.head.setNext(this.tail);
        } else {
            newNode.setNext(this.head);
            this.head = newNode;
        }
        increaseLength();
    }

    public void insertFirst(T value) {
        this.insertFirstNode(new LinkedListNode<T>(value));
    }

    public boolean insertNode(LinkedListNode<T> newNode, int index) {
        if (index > this.length) return false;
        if (index == 0) {
            this.insertFirstNode(newNode);
            return true;
        }
        LinkedListNode<T> previousNode = this.head;
        LinkedListNode<T> nextNode;
        for (int i = 0; i < index; i++) {
            if (i != 0) {
                previousNode = previousNode.getNext();
            }
        }
        nextNode = previousNode.getNext();
        previousNode.setNext(newNode);
        previousNode.getNext().setNext(nextNode);
        increaseLength();
        return true;
    }

    public boolean insert(T value, int index) {
        return this.insertNode(new LinkedListNode<T>(value), index);
    }

    public LinkedList<T> reverse() {
//        TODO: Implement reverse
        return null;
    }
}
