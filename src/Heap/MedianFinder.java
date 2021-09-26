package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: MedianFinder
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/26
 * @Time: 9:28
 * offer 41 寻找数据流的中位数
 *
 */
public class MedianFinder {

    /**
     *
     * 解：维护一个小根堆，一个大根堆
     * 1）第一个数放大根堆
     * 2）第二个数与大根堆顶进行比较
     * 	大于大根堆顶，放入小根堆
     * 	小于大根堆顶，放入大根堆
     * 3）判断当前两个堆的数量差是否>=2
     * 	如果大于，将数量多的堆顶元素放到另一个堆中
     * 4）重复2-3
     *
     * 取元素时，如果是偶数，直接各返回堆顶元素相加/2，否则返回数量大的堆顶元素
     */

    private PriorityQueue<Integer> large=null;

    private PriorityQueue<Integer> small=null;
    /** initialize your data structure here. */
    public MedianFinder() {

        large =new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;//降序
            }
        });

        small=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });


    }


    public void addNum(int num) {

        if (large.isEmpty()&&small.isEmpty()){
            large.add(num);
            return;
        }

        if (num>large.peek()){

            //大于大根堆堆顶 则放入小根堆
            small.add(num);
            if (small.size()-large.size()>=2){
                large.add(small.poll());
            }
        }else {
            large.add(num);
            if (large.size()-small.size()>=2){
                small.add(large.poll());
            }
        }

    }

    public double findMedian() {

        int size=large.size()+small.size();
        if (size%2==0) return (large.peek()+small.peek())/2.0;

        return large.size()>small.size()?large.peek():small.peek();

    }


}
