package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName: p739
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/12
 * @Time: 21:56
 * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指在第 i 天之后，才会有更高的温度。
 * 如果气温在这之后都不会升高，请在该位置用0 来代替。
 *


 */
public class p739 {

//    public int[] dailyTemperatures(int[] temperatures) {
//
//        //使用一个单调栈来保存元素的下标值 栈中控制 所有的元素是单调递减的
//        //当要压入的元素的下标 curIndex 大于当前的栈顶 topIndex，
//        // 那么就弹出栈顶中的下标topIndex，该下标对应的要存放的值就是 还需要几天才能升温 即 当前要curIndex-topIndex天才能升温
//        int res[]=new int[temperatures.length];//存放最终的对应关系
//
//        Stack<Integer> stack=new Stack<>();
//        for (int i=0;i<temperatures.length;i++){
//
//            //栈 为空 直接压入当前元素的下标
//            if (stack.isEmpty()){
//                stack.add(i);
//            }else {
//                //栈中不为空 判断当前元素是否大于栈顶 如果是小于 则直接压入
//                int cur=temperatures[i];
//
//                //取出栈顶的索引 同时获取对应的值
//                if (cur<temperatures[stack.peek()]){
//                    stack.add(i);//压入下标
//                }else {
//                    //栈不为空 且当前元素大于 栈顶
//                    while (!stack.isEmpty()&&cur>temperatures[stack.peek()]){
//
//                        Integer topIndex = stack.pop();//弹出栈顶元素 即下标
//                        res[topIndex]=i-topIndex;//计算还需要几天升温
//                    }
//                    //此时如果为空 或者已经当前的值小于栈顶下标所对应的值
//                    stack.add(i);
//                }
//            }
//        }
//        return res;
//    }

    public int[] dailyTemperatures(int[] temperatures) {

        int res[]=new int[temperatures.length];//存放最终的对应关系

        Stack<Integer> stack=new Stack<>();

        for (int i=0;i<temperatures.length;i++){

            //不为空 而且当前元素大于 栈顶下标所代表的元素
            while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){

                Integer topIndex = stack.pop();
                res[topIndex]=i-topIndex;//计算距离
            }
            stack.add(i);
        }
        return res;

    }
}
