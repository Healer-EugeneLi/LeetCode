package JZOffer;

/**
 * @ClassName: JZOffer56_1
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/14
 * @Time: 23:12
 * 只出现1次的数找出来
 */
public class JZOffer56_1 {

    /**
     * 根据异或特性：
     * 相同数异或结果为0 a^a=0
     * 任何数与0异或结果为任何数 a^0=a
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {

        int a = 0;
        int m = 1;
        int x = 0, y = 0;

        //遍历数组 将所有数进行异或 可以得到随求最后两个不同的数异或的结果 假设最后求出来的结果是x y 那么此时a=x^y
        for (int num : nums) {
            a ^= num;
        }

        //找到两个不同数中 在二进制位不相同的那个位置  因为两个不同的数肯定会在某一个位置上是不同的 所以异或出来的结果肯定是1
        while ((a & m) == 0) {
            m <<= 1;
        }

        //利用m遍历nums进行分组 分别是在某个位置不为1 和某个位置为1
        for (int num : nums) {

            if ((num & m) != 0) x ^= num;
            else y ^= num;
        }

        return new int[]{x, y};

    }
}
