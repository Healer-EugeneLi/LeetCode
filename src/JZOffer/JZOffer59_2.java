package JZOffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: JZOffer59_2
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/16
 * @Time: 11:40
 */
public class JZOffer59_2 {


    class MaxQueue {

        public Queue<Integer> queue;
        public Deque<Integer> deque;

        public MaxQueue() {

            queue = new LinkedList<>();//存放数据进出
            deque = new LinkedList<>();//辅助队列 维持一个非单调递减的队列
        }

        //双端队列 1 2 2 3 4 5 6 此时的6这里是队首 1是队尾 非单调递减 也是递增序列 求最大 辅助栈是递增形式的
        public int max_value() {

            if (deque.isEmpty()) return -1;
            return deque.getFirst();

        }

        public void push_back(int value) {

            //存值的队列内也需要插入值
            queue.add(value);
            //当非单调递减的队列 队尾的值小于value 不断的往后弹出 因此此时已经压入了一个比前面都大的数 那么求最大的时候肯定大于等于value 所以前面那些小于的可以弹出
            while (!deque.isEmpty() && deque.peekLast() < value) {//从队尾开始判断 因为队尾是最小的
                deque.pollLast();
            }
            deque.addLast(value);//最后将插入的值添加到队尾


        }

        public int pop_front() {

            if (queue.isEmpty()) return -1;
            //辅助队列的队首==存值队列的队尾  两个一起弹出 也就是将此时当前的最大值弹出去
            if (deque.peekFirst().equals(queue.peek()))
                deque.pollFirst();
            return queue.poll();

        }
    }
}
