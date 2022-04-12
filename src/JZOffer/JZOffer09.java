package JZOffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName: JZOffer09
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/12
 * @Time: 11:42
 * 两个栈实现一个队列
 */
class CQueue {

    public Stack<Integer> stackA;
    public Stack<Integer> stackB;
    public CQueue() {
        stackA=new Stack();
        stackB=new Stack();
    }

    /**
     * 添加元素直接加到队列A
     * @param value
     */
    public void appendTail(int value) {
        stackA.add(value);
    }

    /**
     * 删除元素的时候
     * 首先判断B栈中是否有元素 如果有 直接返回栈顶元素
     *
     * 如果B栈中没有元素 那么判断A栈中是否有元素
     *      如果A栈中有，那么不断弹出A中的元素到B中，知道A为空，返回B栈顶元素
     *      如果A栈中也没有 返回-1
     *
     * @return
     */
    public int deleteHead() {

        if (!stackB.isEmpty()){
            return stackB.pop();
        }else {
            //A中不为空
            if (!stackA.isEmpty()){

                while (!stackA.isEmpty()){
                    stackB.push(stackA.pop());
                }
                //返回b中的栈顶元素
                return stackB.pop();
            }else {
                return -1;
            }
        }

    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
