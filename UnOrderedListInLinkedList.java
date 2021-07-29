package com.DataStructurePrograms;

public class UnOrderedListInLinkedList {
    //Represent a node of the singly linked list
    public static class Node {
        private String data;
        private Node next;

        public Node(String x) {
            this.data = x;
            this.next = null;
        }
    }

    //Represent the head and tail of the singly linked list
    private Node head = null;
    private Node tail = null;

    //Add nodes to the list at End
    public void addToEnd(String x) {
        Node node = new Node(x);
        if (head == null) {
            this.head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    //Nodes size
    public int size(){
        Node temp = head;
        int i = 0;
        while (temp != null){
            i++;
            temp = temp.next;
        }
        return i;
    }

    public boolean findNode(String x){
        Node temp = head;
        while (temp != null){
            if (temp.data == x){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    //displayList() will display all the nodes
    public void displayList() {
        Node temp = head;
        if (head == null) {
            System.out.println("Singly Linked List is Empty");
        }
        System.out.println("Node's of Singly Linked List :");
        while (temp != null) {
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
        System.out.print("\b");

    }

    public static void main(String[] args) {
        UnOrderedListInLinkedList list = new UnOrderedListInLinkedList();

        list.addToEnd("'Hello'");
        list.addToEnd("'To'");
        System.out.println("After adding some nodes in LinkedList :");
        list.displayList();


        String arr[] = {"'Afroz'", "'Sameer'", "'Ram'", "'Srikanth'"};
        for (int i=0; i<arr.length; i++){
            if (list.findNode(arr[i])){
                continue;
            } else {
                list.addToEnd(arr[i]);
            }
        }
        System.out.println("After UnOrdered nodes in LinkedList :");
        list.displayList();

    }
}
