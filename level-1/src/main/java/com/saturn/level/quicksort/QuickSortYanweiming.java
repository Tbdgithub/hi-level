package com.saturn.level.quicksort;

/**
 * 严版算法
 * 分为三个集合 x<=pivot ,pivot,x>=pivot
 * left: x<=pivot
 * middle:x ;left +1 为 pivot .
 * pivot+1 >=pivot; pivot-1<=pivot
 * right:x>=pivot
 *
 * 证明:
 * 1.初始条件;low ==0,high= N-1; 此时 low-1 侧集合为空, high+1 侧集合为空。A[low]=pivot ; 左右中间部分有N个
 * 2.从high向left 扫描,遇到大的，向左，遇到小的停下来;
 *   从low 向right 扫描，遇到小的，向右，遇到大的停下来;
 *   结果low-1 侧集合小于等于 pivot; high +1 侧集合大于等于pivot
 * 3. 终止条件 :low=high ,中间部分有1个.为A[low]
 *     此时,左侧
 * 0 ... low-1 ,共low-1 个,
 * 右侧
 * high+1 ... N-1 ,共 N-high -1 个,
 * 左，右侧
 * 相加为N-1 +(low-high) 个,
 * 当low == high 时, 为N-1 个;N-1 +1=N 。所以扫描了所有的集合.
 * A[low] 取pivot ，则曲剧满足不变式.
 */
public class QuickSortYanweiming {

    static int count=0;

   public <T extends Comparable<T>> int Partition(T[] A,int low,int high)
   {

       T pivotkey;

       //(*L).r[0]=(*L).r[low]; /* 用子表的第一个记录作枢轴记录 */
      // A[0]=A[low];

       // /* 枢轴记录关键字 */
       pivotkey=A[low];


       while(low< high)
       {
           /* 从表的两端交替地向中间扫描 */


           while ((low<high) && A[high].compareTo(pivotkey)>=0)
           {
               --high;
           }

//           if(low==high)
//           {
//               System.out.println("low==high:"+low);
//           }

           if(low>high)
           {
               System.out.println("impossible,low:"+low+" high:"+high );
           }

           // /* 将比枢轴记录小的记录移到低端 */
           A[low]=A[high]; //当low=high 时,A[low]=a[high] 值未定

           // 将比枢轴记录大的记录移到高端 */

           while ((low <high) && A[low].compareTo(pivotkey)<=0)
           {
               ++low;
           }



           if(low>high)
           {
               System.out.println("impossible,low:"+low+" high:"+high );
           }

           A[high]=A[low];//当low=high 时,A[low]=a[high] 值未定

       }

       //最终low 都 会等于high
       if(low==high)
       {
           System.out.println("low==high:"+low);
       }
       // /* 枢轴记录到位 */
       A[low]= pivotkey;
       //当low=high 时, 修正A[low]=a[high] 值为pivot值

       return low; /* 返回枢轴位置 */
   }



   public  <T extends Comparable<T>> void QuickSort(T[] A)
    {
        /* 对顺序表L作快速排序。算法10.8 */
        QSort(A,0,A.length-1);
    }

    public <T extends Comparable<T>>  void   QSort(T[] A,int low,int high)

    {
        /* 对顺序表L中的子序列L.r[low..high]作快速排序。算法10.7 */

        int pivotloc;

        if(low<high)
        { /* 长度大于1 */
            pivotloc=Partition(A,low,high); /* 将L.r[low..high]一分为二 */
            count++;
            System.out.println(String.format("第%s轮:",count));
            // print(*L,1);
            System.out.println("pivot index:"+pivotloc+" value:"+A[pivotloc]);
            print(A);

            QSort(A,low,pivotloc-1); /* 对低子表递归排序，pivotloc是枢轴位置 */
            QSort(A,pivotloc+1,high); /* 对高子表递归排序 */
        }
        else
        {
           // System.out.println("do nothing !!!");
        }


    }

    public <T extends Comparable<T>> void print(T[] A)
    {
        for(T item :A)
        {
            System.out.print(item+" ");
        }

        System.out.println();
    }

}
