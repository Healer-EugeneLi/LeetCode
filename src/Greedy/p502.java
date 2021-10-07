package Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: p502
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/2
 * @Time: 22:32
 * IPO
 */
public class p502 {
    static class IPO{
        public int p;//利润
        public int c;//成本

        public IPO(int p,int c){
            this.p=p;
            this.c=c;

        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        //准备一个成本小根堆
        PriorityQueue<IPO> minCost=new PriorityQueue<>(new Comparator<IPO>() {
            @Override
            public int compare(IPO o1, IPO o2) {
                return o1.c- o2.c;
            }
        });

        //准备一个利润大根堆
        PriorityQueue<IPO> largeProfit=new PriorityQueue<>(new Comparator<IPO>() {
            @Override
            public int compare(IPO o1, IPO o2) {
                return o2.p-o1.p;
            }
        });

        //先把所有的数据加入到成本堆里
        for (int i=0;i<profits.length;i++){
            minCost.add(new IPO(profits[i],capital[i]));
        }


        for (int i=0;i<k;i++){

            while (!minCost.isEmpty()&&minCost.peek().c<=w){
                //当成本堆里不为空 而且有满足条件的 就一直加进去
                largeProfit.add(minCost.poll());
            }
            if (largeProfit.isEmpty())
                return w;//已经没有满足条件的在大根堆里了 提前返回
            w+=largeProfit.poll().p;//满足的就加上最大利润的那个


        }
        return w;

    }
}
