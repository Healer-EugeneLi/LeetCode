package Recursion;

import java.util.Stack;

/**
 * @ClassName: StackReverse
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/3
 * @Time: 20:57
 * 使用递归来实现栈逆序
 */
public class StackReverse {


    /**
     * 返回栈底的数据 比如栈中是
     * 1
     * 2
     * 3 最后返回的是3  同时栈里的数据是
     * 1
     * 2
     * @param stack
     * @return
     */
    public static int getBottom(Stack<Integer> stack){

        int result=stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            int last=getBottom(stack);
            stack.push(result);
            return last;
        }
    }



    public static void reverse(Stack<Integer> stack){

        if (stack.isEmpty())return;

        int bottom=getBottom(stack);
        reverse(stack);
        stack.push(bottom);
    }
}
