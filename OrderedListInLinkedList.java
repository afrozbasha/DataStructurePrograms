package com.DataStructurePrograms;

public class OrderedListInLinkedList {
    //Represent a node of the singly linked list
    public static class Node {
        private int data;
        private Node next;

        public Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

    //Represent the head and tail of the singly linked list
    private Node head = null;
    private Node tail = null;

    //Add nodes to the list at End
    public void addToEnd(int x) {
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

    public Node getHead(){
        return head;
    }

    //Remove nodes to the Given pos
    public void remNodeAtPos(int pos, int target, Node head){
        Node temp = head;
        Node prev = head;
        if (temp != null && temp.data == target){
            temp = temp.next;
            return;
        }
        while (temp != null && temp.data != target){
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        if (temp == null)
            return;
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

    public boolean findNode(int x){
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
        System.out.println("\b");

    }

    //Sorting using bubble sort
    public void sort(){
        for (Node i = head; i.next != null; i = i.next){
            for (Node j = head; j.next != null; j = j.next){
                if (j.data > i.next.data){
                    int temp = j.data;
                    j.data = j.next.data;
                    j.next.data = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        OrderedListInLinkedList slList = new OrderedListInLinkedList();

        slList.addToEnd(10);
        slList.addToEnd(20);
        slList.addToEnd(30);
        slList.addToEnd(40);

        System.out.println("After adding some nodes in LinkedList :");
        slList.displayList();

        int arr[] = {11, 22, 33, 44};

        for (int i=0; i<arr.length; i++){
            if (slList.findNode(arr[i])){
                continue;
            } else {
                slList.addToEnd(arr[i]);
            }
        }
        System.out.println("After adding some Given Array nodes in LinkedList :");
        slList.displayList();
        System.out.println("Before Ordered nodes in LinkedList :");
        slList.sort();
        System.out.println("After Ordered nodes in LinkedList :");
        slList.displayList();

    }
}
