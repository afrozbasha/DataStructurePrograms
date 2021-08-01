package com.HashingFunctionToSearch;
import java.util.Scanner;

class BinarySearchTree {
    //Represent a node of binary tree
    public static class Node {
        int key;
        Node left;
        Node right;

        public Node(int x) {
            //Assign data to the new node, set left and right null
            this.key = x;
            this.left = null;
            this.right = null;
        }
    }
    //Represent the root of binary tree
    public Node root;
    public BinarySearchTree(){
        root = null;
    }

    //Counting Nodes by using left and right variables
    int leftNodeCount = 0;
    int rightNodeCount = 0;

    //putData() will add new node to the binary search tree
    public void putData(int x){
        Node node = new Node(x);
        if (root == null){
            root = node;
            return;
        }else {
            Node current = root;
            Node parent = null;
            while (true){
                parent = current;
                if (x <current.key){
                    current = current.left;
                    if (current == null){
                        parent.left = node;
                        return;
                    }
                }else if (x > current.key){
                    current = current.right;
                    if (current == null){
                        parent.right = node;
                        return;
                    }
                }
            }
        }

    }

    //display() will perform inorder traversal on binary search tree
    public void display(Node node){
        if (root == null){
            System.out.println("Linked Tree is Empty");
            return;
        }else {
            if (node.left != null){
                display(node.left);
                leftNodeCount++;
                System.out.println(node.key + " ");
            }
            if (node.right != null){
                rightNodeCount++;
                display(node.right);
            }

        }
    }

    public void size(){
        System.out.println("Size of this Binary Search Tree : "+ (leftNodeCount+rightNodeCount+1));
    }

    //Searching given Node in Tree
    public boolean searchNode(int x, Node node){
        if (node == null)
            return false;
        if (node.key == x)
            return true;
        boolean leftSearch = searchNode(x, node.left);
        if (leftSearch)
            return true;
        boolean rightSearch = searchNode(x, node.right);
        if (rightSearch)
            return true;
        return false;
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter How many num of nodes want to add in tree");
        int n = sc.nextInt();

        //Add nodes to the binary tree
        for (int i=0; i<n; i++){
            tree.putData(sc.nextInt());
        }

        //Displays the binary tree
        tree.display(tree.root);
        System.out.println("Root Center -> node : "+tree.root.key);
        System.out.println("Root Left -> node : "+tree.root.left.key);
        System.out.println("Root Right -> node : "+tree.root.right.key);

        //Displays Size of the binary tree
        tree.size();





    }
}
