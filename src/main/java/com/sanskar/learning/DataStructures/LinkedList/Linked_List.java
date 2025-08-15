package com.sanskar.learning.DataStructures.LinkedList;

import com.sanskar.learning.DataStructures.Nodes.Node;

public class Linked_List {
    Node head;

    public Linked_List(int data) {
        head = new Node(data);
    }

    public boolean checkEmpty() {
        return head == null;
    }

    public void insertFirst(int data) {
        if (checkEmpty()) {
            head = new Node(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void insertLast(int data) {
        if (checkEmpty()) {
            insertFirst(data);
        }
        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        Node newNode = new Node(data);
        temp.setNext(newNode);
    }

    public void deleteFirst() {
        if (checkEmpty()) {
            System.out.println("Empty List");
            return;
        }
        head = head.getNext();
    }

    public void deleteLast() {
        if (checkEmpty()) {
            System.out.println("Empty List");
            return;
        }
        Node temp = head;
        while (temp.getNext().getNext() != null) {
            temp.setNext(temp.getNext());
        }
        temp.setNext(null);
    }

    public void printList() {
        Node temp = head;
        while (temp.getNext() != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}
