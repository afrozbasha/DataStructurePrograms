package com.DataStructurePrograms;

public class BalancedParenthesesInStack {
    //Represent a node of the singly linked list
    public static class Node {
        private int data;
        private Node next;

        //Parameter and Default Constructors
        public Node(int x) {
            this.data = x;
            this.next = null;
        }
        public Node(){
        }
    }
    //Represent the 'Stack Pointer' like top as of the singly linked list
    private Node top = null;

    /// Method to push int element in the stack
    public void push(int x){
        Node node = new Node(x);
        if (node == null){
            System.out.println("Stack is Under flow");
            node.next = null;
        }else {
            node.next = top;
        }
        top = node;
        //System.out.println("Successfully pushed " + x);
    }
    //Method to display the stack Pop value
    public int pop(){
        if (top == null)
            System.out.println("Stack is underflow");
        else{
            //System.out.println("Stack Pooped value is : " + top.data);
            return top.data;
        }
        return 0;

    }
    public boolean peek(){
        if (top == null){
            System.out.println("Stack is underflow");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BalancedParenthesesInStack stk = new BalancedParenthesesInStack();
        char exp[] = {'(', '5','+','6',')','∗','(','7','+','8',')','/','(','4','+','3',')','(','5','+','6',')','∗','(','7','+','8',')','/','(','4','+','3',')'};
        for (int i=0; i<exp.length; i++){
            char c = exp[i];
            if (c == '('){
                stk.push(i);
            }else if (c == ')'){
                try {
                    int p = stk.pop()+1;
                    System.out.println("Matched Parentheses");
                    break;
                } catch (Exception e) {
                    System.out.println("Unmatched Parentheses");
                    break;
                }
            }
        }
        while (stk.peek()){
            System.out.println("is unmatched");
            break;
        }


    }
}
