package MoveWindow;

/**
 * @ClassName: p1052
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/10
 * @Time: 22:03
 * <p>
 * <p>
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
 * 输出：16
 * 解释：书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16
 * <p>
 * 爱生气的老板
 */
public class p1052 {

    /**
     * 由于技巧只会将生气变为不生气 不生气仍然是不生气
     * 1.先将原本满意的客户加入答案 同时将对应的customers[i]变为0
     * 2.之后的问题转化为：在customers中找到连续一段长度为minutes的子数组，使得其综合最大。这部分是我们应用技巧得到的客户
     *
     * @param customers
     * @param grumpy
     * @param minutes
     * @return
     */
//    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
//
//
//        //先将原先那些本就不会生气而满意的顾客留下来 同时将该分钟满意的顾客数归0
//
//        int res=0;
//
//        for (int i=0;i<customers.length;i++){
//
//            if (grumpy[i]==0){
//                res+=customers[i];//i分钟的时候 因为老板不生气而留下来的顾客数
//                customers[i]=0;//同时设置这i分钟 满意的顾客数为0  接下来再使用滑动窗口 来进行滑动的时候就不用重复计算 不必考虑这些顾客
//            }
//        }
//
//        int temp=0;
//        for (int i=0;i<minutes;i++)
//            temp+=customers[i];
//        int max=temp;
//
//        for (int i=minutes;i<customers.length;i++){
//
//            temp=temp+customers[i]-customers[i-minutes];//滑动窗口 右边界右移 该元素进来 左边界右移 该元素出去
//            max=Math.max(max,temp);//保留 minutes分钟内最多的顾客数
//        }
//        return res+max;
//
//    }
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {


        int res = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
                customers[i] = 0;
            }
        }

        //找到连续minutes最大子数组和
        int cur = 0;
        int temp = 0;
        for (int i = 0; i < customers.length; i++) {

            cur += customers[i];

            if (i >= minutes) {
                cur -= customers[i - minutes];
            }

            temp = Math.max(temp, cur);
        }

        return res + temp;
    }
}
