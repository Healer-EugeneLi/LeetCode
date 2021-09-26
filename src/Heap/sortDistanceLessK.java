package Heap;

import java.util.PriorityQueue;

/**
 * @ClassName: sortDistanceLessK
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/25
 * @Time: 22:58
 */
public class sortDistanceLessK {


    public void sortedArrDistanceLessK(int arr[],int k){

        //默认小根堆
        PriorityQueue<Integer> heap=new PriorityQueue<>();

        int index=0;
        for (;index<=Math.min(arr.length,k);index++){
            heap.add(arr[index]);
        }

        int i=0;
        for (;index<arr.length;i++,index++){
            heap.add(arr[index]);
            arr[i]=heap.poll();
        }

        while (!heap.isEmpty()){
            arr[i++]=heap.poll();
        }
    }
}
