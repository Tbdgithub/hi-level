package com.saturn.level;

import com.google.gson.Gson;
import com.saturn.level.quicksort.QuickSortHelper;
import com.saturn.level.quicksort.QuickSortYanweiming;
import com.saturn.level.quicksort.QuickSorter;
import org.junit.Test;

public class QuickSorter_test {

    @Test
    public void test1()
    {
        try {
            QuickSorter<Integer> worker = new QuickSorter();

            Integer[] A = {2, 8, 7, 1, 3, 5, 6, 4};

            System.out.println(new Gson().toJson(A));
            worker.quickSort(A, 0, A.length - 1);
            System.out.println(new Gson().toJson(A));
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    @Test
    public void test2()
    {
        try {


           // Integer[] A = {2, 8, 7, 1, 3, 5, 6, 4};
            Integer[] A = {5,2,6,3,8};
           // Integer[] A = {8,3,6,2,5};
            System.out.println(new Gson().toJson(A));
            QuickSortHelper.quickSort(A, 0, A.length - 1);
            System.out.println(new Gson().toJson(A));
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    @Test
    public void test3()
    {
        try {


            // Integer[] A = {2, 8, 7, 1, 3, 5, 6, 4};
            //Integer[] A = {5,2,6,3,8};

            //Integer[] A = {5,8,7,1,3,6,4,2};
            Integer[] A = {3,3,4,4,2,2};
            //Integer[] A = {1,2};
          //  Integer[] A = {1};
            QuickSortYanweiming worker=new QuickSortYanweiming() ;
            System.out.println(new Gson().toJson(A));

            worker.QuickSort(A);

           // System.out.println(new Gson().toJson(A));
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
}