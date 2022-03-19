package Sort;

/**
 * @ClassName: FindNumber
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/10
 * @Time: 10:44
 */
public class FindNumber {


    public int[] singleNumbers(int[] arr) {

        //1.先异或一遍
        int eor = 0;
        for (int num : arr) {
            eor ^= num;
        }
        //2.此时eor=a^b 且因为a!=b 所以eor肯定不为0 某一位肯定有一个是1
        // 找到eor从右边开始的第一个1
        int rightOne = eor & (~eor + 1);
        int a = 0;
        for (int num : arr) {
            if (((rightOne & num) == 0))
                a ^= num;
        }

        int b = eor ^ a;
        return new int[]{a, b};

    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5};
        FindNumber findNumber = new FindNumber();
        int[] res = findNumber.singleNumbers(arr);

        for (int i = 0; i < res.length; i++)
            System.out.println(res[i]);


    }


}
