package JZOffer;

/**
 * @ClassName: JZOffer56_1
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/14
 * @Time: 23:12
 * 只出现1次的数找出来
 *
 *
 */
public class JZOffer56_1 {

    public int[] singleNumbers(int[] nums) {

        int a=0;
        int m=1;
        int x=0,y=0;
        //最后x是两个不相同的数异或的结果 假设为a^b=x
        for (int num:nums){
            a^=num;
        }

        //找到两个不同数中 二进制位为1 的那个位置
        while ((a&m)==0){
            m<<=1;
        }

        //遍历nums进行分组
        for (int num:nums){

            if ((num&m)!=0) x^=num;
            else y^=num;
        }

        return new int[]{x,y};

    }
}
