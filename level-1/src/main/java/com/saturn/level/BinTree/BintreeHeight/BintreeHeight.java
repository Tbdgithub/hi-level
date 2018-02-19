package com.saturn.level.BinTree.BintreeHeight;

public class BintreeHeight {

    public static void main(String[] args) {
        BintreeHeight worker = new BintreeHeight();

        BintreeNode head = null;

        head = new BintreeNode();

        BintreeNode n11 = new BintreeNode();
        head.setLeft(n11);

        BintreeNode n21 = new BintreeNode();
        n11.setLeft(n21);


        BintreeNode n22 = new BintreeNode();
        n11.setRight(n22);

        BintreeNode n31 = new BintreeNode();
        n21.setLeft(n31);



        //right
        BintreeNode n12 = new BintreeNode();
        head.setRight(n12);

        BintreeNode n23 = new BintreeNode();
        n12.setLeft(n23);

        BintreeNode n24 = new BintreeNode();
        n12.setRight(n24);

        int height = worker.getHeight(head);

        System.out.println("Height:" + height);


    }


    public int getHeight(BintreeNode head) {

        if (head == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(head.left), getHeight(head.right));

    }

    static class BintreeNode {
        private int data;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        private BintreeNode left;

        private BintreeNode right;

        public BintreeNode getLeft() {
            return left;
        }

        public void setLeft(BintreeNode left) {
            this.left = left;
        }

        public BintreeNode getRight() {
            return right;
        }

        public void setRight(BintreeNode right) {
            this.right = right;
        }
    }
}
