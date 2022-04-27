package JZOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: JZOffer40
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/20
 * @Time: 11:42
 * 找最小的k个数
 */
public class JZOffer40 {

    public int[] getLeastNumbers(int[] arr, int k) {

        if(k==0) return new int[0];

        //创建一个大根堆
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int a:arr){


            //此时最大堆中没有满 那么压入元素
            if (queue.size()<k){
                queue.add(a);
            }else if (queue.peek()>a){
                queue.poll();//弹出此时的堆顶
                queue.add(a);//加入更小的元素
            }
        }

        int res[]=new int[k];
        int i=0;
        while (!queue.isEmpty()){
            res[i++]=queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[]={3,2,1};
        int k=2;

        JZOffer40 t=new JZOffer40();
        int[] res = t.getLeastNumbers(arr, k);

    }
}
