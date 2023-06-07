package com.company;

public class PostingList {
    Node head;

    public PostingList(Node head){
        this.head=head;
    }

    public void add(Node new_node){
        new_node.next=head;
        head=new_node;
    }

    public boolean contain(String s){
        Node n=head;

        while(n!=null){
            if(n.word==s)
            {
                return true;
            }
            n=n.next;
        }
        return false;
    }

    public void display() {
        Node n=head;
        while(n!=null)
        {
            System.out.println(n.word);
            n=n.next;
        }
    }
}
