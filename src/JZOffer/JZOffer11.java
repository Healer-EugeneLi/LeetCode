package JZOffer;

/**
 * @ClassName: JZOffer11
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/22
 * @Time: 22:32
 */
public class JZOffer11 {

    public int minArray(int[] numbers) {

        int left=0,right=numbers.length-1;

        while (left<right){

            int middle=left+((right-left)>>1);

            if (numbers[middle]>numbers[right]){
                //中间比右指针的值大 说明最小值在右侧
                left=middle+1;
            }else if (numbers[middle]<numbers[right]){
                //最小值在左侧 或者中间
                right=middle;
            }else
                right--;

        }
        return numbers[left];
    }
}
