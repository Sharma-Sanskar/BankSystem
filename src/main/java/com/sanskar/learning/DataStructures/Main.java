package com.sanskar.learning.DataStructures;

import com.sanskar.learning.DataStructures.LinkedList.Linked_List;


public class Main {
    public static void main(String[] args) {
        Linked_List l1 = new Linked_List(1);
        l1.insertFirst(2);
        l1.insertFirst(3);
        l1.insertFirst(4);
        l1.insertFirst(5);
        l1.printList();
    }
}
