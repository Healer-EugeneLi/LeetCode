package Greedy;

/**
 * @ClassName: p135
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/18
 * @Time: 11:06
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 */
public class p135 {
    public int candy(int[] ratings) {

        int n=ratings.length;
        //全部一开始先初始化为1
        int numbers[]=new int[n];
        for (int i=0;i<n;i++)
            numbers[i]=1;
        //左规则： 从左往右遍历 如果 ratings[i]>ratings[i-1] 那么右边的孩子个数要比左边的多1
        for (int i=1;i<n;i++){
            if (ratings[i]>ratings[i-1])
                numbers[i]=numbers[i-1]+1;
        }

        //右规则：从右往左遍历 如果ratings[i]>ratings[i+1] 那么左边的孩子要比右边的孩子多1

        //并且对于每个孩子 选择左规则和右规则中糖果的最大值
        for (int i=n-1;i>0;i--){
            //如果此时 左边的孩子分数比右边的孩子高 但是糖果却比较少 那么就是需要重设这个孩子的糖果分配数 使得这个左边孩子的糖果数为右边孩子+1
            if (ratings[i-1]>ratings[i]&&numbers[i-1]<=numbers[i]){
                numbers[i-1]=numbers[i]+1;
            }

        }

        //遍历所有孩子糖果数 求和
        int res=0;
        for (int number:numbers)
            res+=number;
        return res;

        //以 1 0 2 为例
        //从左遍历之后  糖果数为 1 1 2
        //此时从右往左遍历  可以发现第一个孩子得分为1 孩子2得分为0  但是两个都是一样的个数糖果 1个 那么不对 此时设置第一个孩子的糖果为第二个的个数+1  也就是2个
        //最终分配糖果个数为2 1 2 所以结果为5

    }

    public static void main(String[] args) {

        int ratings[]={1,0,2};

        p135 t=new p135();
        int candy = t.candy(ratings);
        System.out.println(candy);
    }
}
