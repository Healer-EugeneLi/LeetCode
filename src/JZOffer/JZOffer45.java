package JZOffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: JZOffer45
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/27
 * @Time: 21:44
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
public class JZOffer45 {

    public String minNumber(int[] nums) {

        String strs[]=new String[nums.length];

        //先将数组里面的数字转成字符串 放到字符串数组
        for (int i=0;i<nums.length;i++){
            strs[i]=String.valueOf(nums[i]);
        }

        //自定义排序 30 3 <3 30 所以30排在前面
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        StringBuilder res=new StringBuilder();
        //最后对字符串数组进行拼接
        for (String cur:strs)
            res.append(cur);
        return res.toString();

    }
}
