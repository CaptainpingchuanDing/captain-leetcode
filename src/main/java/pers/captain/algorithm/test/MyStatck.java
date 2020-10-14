package pers.captain.algorithm.test;

public class MyStatck {


    private Node head;

    public Object pop() {
        if (head != null) {
            Node temp = head;
            head = head.next;
            return temp.item;
        } else {
            return null;
        }

    }

    public void push(int item) {
        if (head == null) {
            head = new Node(item);
        } else {
            Node val = new Node(item);
            val.next = head;
            head = val;
        }
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        Node temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }


    public static void main(String[] args) {
        MyStatck myStatck = new MyStatck();
        System.out.println(myStatck.pop());
        myStatck.push(2);
        myStatck.push(3);
        System.out.println(myStatck.size());
        System.out.println(myStatck.pop());
        System.out.println(myStatck.pop());

    }
}

class Node {
    int item;
    Node next;

    public Node(int item) {
        this.item = item;
    }
}
