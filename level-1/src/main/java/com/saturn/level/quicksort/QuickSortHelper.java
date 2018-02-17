package com.saturn.level.quicksort;

public class QuickSortHelper {

    static int count=0;

    public static  <T extends Comparable> void quickSort(T[] A, int p, int r) {

        if (p < r) {
            int q = partition(A, p, r);
            count++;
            System.out.println(String.format("第%s轮:",count));
            print(A);

            //System.out.println(p+" "+ String.valueOf(q-1));
            quickSort(A, p, q - 1);

            //System.out.println( String.valueOf(q+1)+" "+r);
            quickSort(A, q + 1, r);

        }

    }

    public static  <T extends Comparable> int partition(T A[], int p, int r) {
        T x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j].compareTo(x) == 0 || A[j].compareTo(x) < 0) {
                i = i + 1;
                T temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }

        }

        T temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;

        int result=i+1;
        System.out.println("partition:"+result);
        return result;
    }

//    public static  <T extends Comparable> int partition1(T A[], int p, int r) {
//        T x = A[0];
//        int i = r;
//        for (int j = p; j < r; j++) {
//            if (A[j].compareTo(x) == 0 || A[j].compareTo(x) < 0) {
//                i = i + 1;
//                T temp = A[i];
//                A[i] = A[j];
//                A[j] = temp;
//            }
//
//        }
//
//        T temp = A[i + 1];
//        A[i + 1] = A[r];
//        A[r] = temp;
//
//        int result=i+1;
//        System.out.println("partition:"+result);
//        return result;
//    }

    public static <T extends Comparable> void print ( T A[] )
    {
        if(A==null)
        {
            return;
        }

        for(T item: A)
        {
            System.out.print(item+" ");
        }

        System.out.println();
    }
}