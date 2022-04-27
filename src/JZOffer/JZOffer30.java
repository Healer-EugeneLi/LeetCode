package JZOffer;

import java.util.Stack;

/**
 * @ClassName: JZOffer30
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/20
 * @Time: 11:09
 */
public class JZOffer30 {

    class MinStack {


        Stack<Integer> dataStack=new Stack<>();//存放数据的正常栈
        Stack<Integer> minStack=new Stack<>();
        //维护一个递减栈 当要压入的元素小于此栈的栈顶 那么压入该元素 当dataStack弹出数据的时候 与minStack栈顶元素一致 则同时弹出minStack栈顶
        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {

            dataStack.push(x);
            //minStack为空时 直接压入
            if (minStack.isEmpty())
                minStack.push(x);
            else if (minStack.peek()>=x)
                minStack.push(x);//如果栈顶大于要压入的元素 那么同时在minStack栈中压入x
        }

        public void pop() {

            int x=dataStack.peek();
            dataStack.pop();

            //弹出元素的时候 注意比较minStack中的元素是否等于所弹出的元素 相等则弹出
            if (x==minStack.peek())
                minStack.pop();
        }


        public int top() {
            return dataStack.peek();

        }

        public int min() {
            return minStack.peek();
        }
    }
}
