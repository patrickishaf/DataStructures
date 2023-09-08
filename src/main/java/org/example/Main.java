package org.example;

import org.example.linkedlist.LinkedList;
import org.example.linkedlist.LinkedListNode;

public class Main {
    public static void main(String[] args) {
        LinkedListNode node = new LinkedListNode(4);
        LinkedListNode nextNode = new LinkedListNode(5);

        LinkedList<Integer> linkedList = new LinkedList(1);
        linkedList.appendValue(2);
        linkedList.appendValue(3);
        linkedList.appendNode(node);
        linkedList.appendNode(nextNode);

        linkedList.insert(6, 5);
        linkedList.insert(7, 6);
        linkedList.insert(8, 7);
        linkedList.insert(0, 0);
        System.out.println(linkedList.getValues());
        LinkedListNode removedNode = linkedList.removeLastNode();
        System.out.println(removedNode.getValue());
        System.out.println(linkedList.getValues());
    }
}