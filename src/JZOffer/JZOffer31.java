package JZOffer;

import java.util.Stack;

/**
 * @ClassName: JZOffer31
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/13
 * @Time: 17:02
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5}
 * 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 */
public class JZOffer31 {

    /**
     * 时间复杂度 O(N) ： 其中 N 为列表pushed 的长度；每个元素最多入栈与出栈一次，
     * 即最多共 2N 次出入栈操作。
     * 空间复杂度 O(N) ： 辅助栈 stack 最多同时存储 N 个元素。
     *
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack=new Stack<>();
        int i=0;
        //遍历入栈的元素
        for (int num:pushed){
            stack.add(num);//加入元素

            //当栈中有元素的时候 并且栈顶==当前要出栈的元素
            while (!stack.isEmpty()&&stack.peek()== popped[i]){
                stack.pop();//弹出辅助栈中的元素
                i++;//同时需要模拟的出栈的指针往下移
            }
        }

        //遍历完了之后 如果发现栈为空 说明完全匹配上了出栈的顺序
        return stack.isEmpty();
    }
    public static void main(String[] args) {


        int a[]={1,2,3,4,5};
        int b[]={4,3,5,1,2};

        JZOffer31 t=new JZOffer31();
        boolean res = t.validateStackSequences(a, b);
        System.out.println(res);
    }
}
