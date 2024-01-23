package org.example;

import org.example.linkedlist.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(0);
        for (int i = 1; i <= 5; i++) {
            linkedList.appendValue(i);
        }
        System.out.println(linkedList.reverse());
    }
}