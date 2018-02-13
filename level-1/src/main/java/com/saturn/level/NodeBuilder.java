package com.saturn.level;

public class NodeBuilder {

    public Node buildSortedList(int[] array) {

        Node head = null;
        for (int item : array) {
            //head = addSorted(head, item);
            head = addSortedEnhance(head, item);
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
        //三段论
        //1. head 判断
        //2. 遍历节点判断
        //3. 节点结束判断

        //小于head, 特殊
        if (newNode.data < head.data) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        Node before = current;

        //找遍节点
        while (current != null
                ) {

            if (newNode.data >= current.data) {
                before = current;
                current = current.next;
                continue;
            } else {
                // new node >=current
                //insert
                //新节点数据小于当前节点,inset 到 [当前节点之前，当前节点] 之间
                before.next = newNode;
                newNode.next = current;
                break;
            }

        }


        //找遍了列表，所有节点均小于等于新节点，insert 到尾部
        if (current == null) {

            //尾
            before.next = newNode;
            newNode.next = current;
        }

        return head;


    }


    public Node addSortedEnhance(Node head, int data) {
        if (head == null) {
            head = new Node(data);
            return head;
        }

        Node newNode = new Node(data);

        Node current = head;

        //newNode 小于head 时，就不用找了.
        boolean needGoAhead = true;
        if (newNode.data < current.data) {
            needGoAhead = false;
        }

        Node before = current;

        //找遍节点
        while (current != null && needGoAhead) {

            if (newNode.data >= current.data) {

                before = current;
                current = current.next;
            } else {
                //找到大于newNode 的节点，或者链表到尾部
                break;
            }
        }

        if (current == head) {
            //第一个特别，head 为newNode
            newNode.next = head;
            head = newNode;
        } else {
            //找到大于newNode 的节点current,或者没找到current 为null;统一放newNode 到before 和current 之间(没找到时,before 和null之间)
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

        Node head=null;

        if(head0==null && head1==null)
        {
            return null;
        }

        if(head0==null)
        {
            return head1;
        }

        if(head1==null)
        {
            return head0;
        }

        if(head0.data<head1.data)
        {
            head=head0;
            head.next=mergeList(head0.next,head1);
        }
        else
        {
            head=head1;
            head.next=mergeList(head1.next,head0);
        }

        return head;

    }

    public static void main(String[] args) {

        NodeBuilder builder = new NodeBuilder();
        Node node0 = builder.buildSortedList(new int[]{1, 3, 2});
        builder.printNodeList(node0);


        Node node1 = builder.buildSortedList(new int[]{6, 7, 4, 5});


        builder.printNodeList(node1);

        Node head = builder.mergeList(node0, node1);
        builder.printNodeList(head);


    }

}
