package com.saturn.level;

public class NodeBuilder {

    public Node buildSortedList(int[] array) {

        Node head = null;
        for (int item : array) {
            head = addSorted(head, item);
        }

        return head;

    }

    public Node addSorted(Node head, int data) {
        if (head == null) {

            head = new Node(data);
            return head;
        }


        Node newNode = new Node(data);

        Node current = head;

        if (newNode.data < head.data) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        Node before = current;

        while (current != null
                ) {

            if (newNode.data >= current.data) {
                before = current;
                current = current.next;
                continue;
            } else {
                // new node >=current
                //insert
                before.next = newNode;
                newNode.next = current;
                break;
            }

        }


        if (current == null) {

            //尾
            before.next = newNode;
            newNode.next = current;
        }

        return head;


    }

    public void printNodeList(Node head) {
        if (head == null) {
            System.out.println("head is null");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();

    }

    public Node mergeList(Node head0, Node head1) {
        return null;

    }

    public static void main(String[] args) {

        NodeBuilder builder = new NodeBuilder();
        Node node0 = builder.buildSortedList(new int[]{1,3,2,5,4});
        builder.printNodeList(node0);


        Node node1 = builder.buildSortedList(new int[]{6,7,3, 4, 5});


        builder.printNodeList(node1);

        Node head = builder.mergeList(node0, node1);
        builder.printNodeList(head);


    }

}
