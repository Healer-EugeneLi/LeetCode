package JZOffer;

/**
 * @ClassName: JZOffer61
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/1/18
 * @Time: 17:00
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 */
public class JZOffer61 {
    /**
     * 统计5张牌中的最大值与 除0外的最小值
     *
     * 并记录牌中0的个数 当0的个数为5个或者4个时 直接返回true
     *
     * 若0数小于4个 统计5张牌中最小值到最大值之间没有数的个数 每遇到一个不存在 在num中的数时 zero-- 使用0来替换
     * 当zero>=0 返回true
     *
     * 否则返回false
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {

        //max为最大值 min为除0外的最小值 zero为0的个数
        int max = -1, min = 15, zero = 0;
        int pos[] = new int[15];
        for (int num : nums) {
            if (num >= max)
                max = num;
            if (num <= min && num != 0)
                min = num;
            if (num == 0)
                zero += 1;
            //记录不是0的数 其出现的次数
            if (num != 0)
                pos[num] += 1;
        }
        if (zero >= 4) return true;//全为0
        for (int i = min; i <= max; i++) {
            //如果该数出现了两次以上 那肯定是不符合顺子
            if (pos[i] >= 2) return false;
            if (pos[i] == 0)//相当于这个数不存在 然后使用0来替换它
                zero--;
        }

        if (zero >= 0) return true;//对于[9,11,0,0,0] 只需要0的个数为1个在中间 其他放两边 所以是可以的
        else return false;


    }


}
