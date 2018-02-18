package com.saturn.level.BinSerch;

public class Binsearcher {

    public <T extends Comparable<T>> T find(T[] A, T key)
    {
     return find(A,key,0,A.length-1);
    }

    public <T extends Comparable<T>> T find(T[] A, T key, int begin, int end) {



        if(begin<=end) {

            //分割集合为 x... pivot-1,pivot,pivot+1 ... x
            int pivot = (begin+end)/2;

            if (A[pivot].compareTo(key) == 0) {
                return A[pivot];
            } else if (A[pivot].compareTo(key) > 0) {
                return find(A, key, begin, pivot - 1);
            } else {
                return find(A, key, pivot + 1, end);
            }

        }

        return null;
    }

}
