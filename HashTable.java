package com.HashingFunctionToSearch;

public class HashTable {
    private HashNode Array[];
    private int noOfArrays;
    private int size;

    //Create HashTable custom array Constructor
    public HashTable(int x) {
        this.noOfArrays = x;
        this.Array = new HashNode[noOfArrays];
        this.size = 0;
    }

    public HashTable() {
        this(11);
    }

    //Create HashNode like Linked list one link and two data types
    public class HashNode {
        private Integer key;
        private int value;
        private HashNode next;

        //Create HashNode like Linked list Constructor
        public HashNode(Integer key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //Fix the index depending on the key value for reducing the no of searching iterations
    public int getArrayIndex(Integer key) {
        int index = key % noOfArrays;
        return index;
    }

    //Put data in Hash Table using linked Node
    public void putData(Integer key, int value) {
        if (key == null || value == 0) {
            System.out.println("key or value are null");
        }
        int arrayIndex = getArrayIndex(key);
        HashNode head;
        size++;
        head = Array[arrayIndex];
        HashNode node = new HashNode(key, value);
        node.next = head;
        Array[arrayIndex] = node;

    }

    public void remOrAddInt(int x) {
        HashNode node ;//= Array[i];
        node = Array[x%11];
        if (node.value == x){
            node.value = 0;
            System.out.println("Successfully " + x + " Node is removed");
        }else if (node.value != x){
            node.value = x;
            System.out.println("Successfully " + x + " Node is Added");
        }

    }

    //Checking the values of the key
    public int getIndexValue(int x){
        int ind=0 ;
        HashNode node ;
        while (ind<12) {
            node = Array[ind];
            if (node.value == x) {
                System.out.println(x+" Node in this index "+ind);
                return ind;
            }else
                node = Array[ind++];
        }
        return 0;
    }


    public static void main(String[] args) {
        HashTable hash = new HashTable();

        for (int i=0; i<12; i++){
            hash.putData(i, 0);
        }

        hash.putData(77, 77);
        hash.remOrAddInt(77);
        hash.remOrAddInt(56);
        hash.getIndexValue(56);



    }
}
