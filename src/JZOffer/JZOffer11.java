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

        int left = 0, right = numbers.length - 1;

        while (left < right) {

            int middle = left + ((right - left) >> 1);

            if (numbers[middle] > numbers[right]) {
                //中间比右指针的值大 说明最小值在右侧
                left = middle + 1;
            } else if (numbers[middle] < numbers[right]) {
                //最小值在左侧 或者中间
                right = middle;
            } else
                right--;//当相等的时候不能确定是哪一个 要选择缩小范围

        }
        return numbers[left];
    }

//    public int minArray(int[] numbers) {
//
//      for (int i=0;i<numbers.length-1;i++){
//          if (numbers[i]>numbers[i+1])
//              return numbers[i+1];
//      }
//      return numbers[0];
//    }
    public static void main(String[] args) {
        int numbers[]={ 3,4,5,1,2};
        JZOffer11 t=new JZOffer11();
        int res = t.minArray(numbers);

        System.out.println(res);
    }
}
