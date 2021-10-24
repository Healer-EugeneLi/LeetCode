package Stack;

import java.util.Stack;

/**
 * @ClassName: p1475
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/15
 * @Time: 9:45
 * 输入：prices = [8,4,6,2,3]
 * 输出：[4,2,4,2,3]
 * 解释：
 * 商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
 * 商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
 * 商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
 * 商品 3 和 4 都没有折扣。
 *
 */
public class p1475 {
    public int[] finalPrices(int[] prices) {

        //维护一个从栈低到栈顶是递增的栈 遇到比栈顶大的元素直接加入
        //遇到比栈顶小的 说明就是这个栈顶右边第一个比他小的元素 要减去这个折扣 栈中存放的是索引
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i< prices.length;i++){

            while (!stack.isEmpty()&&prices[stack.peek()]>=prices[i]){
                //如果栈不为空  并且栈顶元素大于当前这个遍历到的元素

                int index=stack.pop();//栈顶元素
                prices[index]-=prices[i];
            }

            stack.push(i);
        }

      return prices;
    }


}
