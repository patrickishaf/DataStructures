package org.example;

import org.example.doublylinkedlist.DoublyLinkedList;
import org.example.doublylinkedlist.DoublyLinkedListNode;
import org.example.linkedlist.LinkedList;
import org.example.linkedlist.LinkedListNode;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedListNode<Integer> node = new DoublyLinkedListNode(4);
        DoublyLinkedListNode<Integer> nextNode = new DoublyLinkedListNode(5);

        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList(1);
        doublyLinkedList.appendValue(2);
        doublyLinkedList.appendValue(3);
        doublyLinkedList.appendNode(node);
        doublyLinkedList.appendNode(nextNode);
        doublyLinkedList.insertValue(0, 0);

        System.out.println(doublyLinkedList.removeValue(5));

        System.out.println(doublyLinkedList.getValues());
    }
}