package DobulePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: p15
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/8
 * @Time: 10:08
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 找到a+b+c=0 三个数的和为0
 */
public class p15 {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);//先对数组进行排序

        //每一次固定一个数字 设置为a 然后后面的数字使用双指针进行查找b c使得b+c=0-a
        List<List<Integer>> res=new ArrayList<>();
        int left=0,right=0;
        int target=0;
        int sum=0;//左右指针的和
        for (int i=0;i<nums.length-2;i++){

            //当前要指定的a这个数==前面一个 那当前这个数也没有必要去算了
            if (i>0&&nums[i]==nums[i-1]) continue;//去重

            if (nums[i]>0) break;//已经超过0了 因为一开始已经排序过了 所以后面的数肯定都是比0大的

            //设置a=nums[i]  所以需要找的另外两数的和为0-a
            target=0-nums[i];

            left=i+1;//left从当前数下一个开始找
            right=nums.length-1;//从最后一个开始往前找
            while (left<right){

                sum=nums[left]+nums[right];//当前两个数的和
                //如果等于目标值
                if (sum==target){
                    //加入一组符合的数据
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //过滤重复
                    while (left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while (left<right&&nums[right]==nums[right-1]){
                        right--;
                    }

                    //找到一组之后并且也是过滤了重复的之后 就可以直接将两个指针移动
                    left++;
                    right--;

                }else if (sum>target){
                    //和过大了 超过target 那么right左移 来使得加上的值小一点
                    right--;
                }else{
                    //和过小了 不足以达到target 那么就将left指针往右移 使得加上的值大一点
                    left++;
                }

            }

        }
        return res;

    }
}
