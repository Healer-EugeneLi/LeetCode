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

            queue=new LinkedList<>();//存放数据进出
            deque=new LinkedList<>();//辅助队列 维持一个非单调递减的队列
        }

        public int max_value() {

            if (deque.isEmpty()) return -1;
            return deque.getFirst();

        }

        public void push_back(int value) {

            //存值的队列内也需要插入值
            queue.add(value);
            //当非单调递减的队列 队尾的值小于value 不断的往后弹出
            while (!deque.isEmpty()&&deque.peekLast()<value){
                deque.pollLast();
            }
            deque.addLast(value);


        }

        public int pop_front() {

            if (queue.isEmpty()) return -1;
            //辅助队列的队尾==存值队列的队尾  两个一起弹出
            if (deque.peekFirst().equals(queue.peek()))
                deque.pollFirst();
            return queue.poll();

        }
    }
}
