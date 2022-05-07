package JZOffer;

/**
 * @ClassName: JZOffer66
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/14
 * @Time: 11:04
 */
public class JZOffer66 {

    /**
     * 构建两个数组 left[i] right[i]
     *
     * left[i]: a[i]左边所有元素的乘积和 不包括a[i]
     * right[i]:a[i]右边所有的元素的乘积和 不包括a[i]
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {

        if (a.length==0) return new int[]{};
        int left[]=new int[a.length];
        int right[]=new int[a.length];
        int res[]=new int[a.length];


        //先计算left数组
        left[0]=1;
        for (int i=1;i<a.length;i++){

           left[i]=left[i-1]*a[i-1];//前一个元素乘上 其前一个元素的所有左边元素乘积和
        }

        //计算right数组
        right[a.length-1]=1;
        for (int i=a.length-2;i>=0;i--){
             right[i]=right[i+1]*a[i+1];
        }

        //再遍历整个数组 去构建乘积和
        for (int i=0;i<a.length;i++){
            res[i]=left[i]*right[i];
        }
        return res;

    }

//    /**
//     * 优化上一个解法
//     *
//     * @param a
//     * @return
//     */
//    public int[] constructArr(int[] a) {
//
//        if (a.length == 0) return new int[]{};
//        int res[] = new int[a.length];
//
//        res[0] = 1;
//
//        //构建left数组
//        for (int i = 1; i < a.length; i++) {
//            res[i] = res[i - 1] * a[i - 1];
//        }
//        int temp = 1;
//        //构建right数组
//        for (int i = a.length - 2; i >= 0; i--) {
//            temp *= a[i + 1];//临时的右边数据乘积
//            res[i] *= temp;
//        }
//
//        return res;
//    }
}
