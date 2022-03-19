package PrefixSum;

/**
 * @ClassName: p1442
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/19
 * @Time: 13:57
 */
public class p1442 {

    /**
     * a的取值是[i..j-1]
     * b的取值是[j..k]
     * 如果a==b 那么arr[i]^arr[i+1]^....arr[j]^....arr[k]=0
     * 转化成在arr数组中找到一些连续的元素 他们的异或结果等于0
     *
     * 因为i<j 且j可以等于k 那么这个k不需要管 所以至少需要两个元素 也就是说从数组arr中找到至少2个元素以上的连续元素 异或结果是0 可以组成(i,j,k)
     *
     * 比如数组[1,2,5,6]的异或结果为0  可能的组合是
     * a=1 b=2^3^4  (i,j,k)的取值是(0,1,3)
     * a=1^2 b=3^4  (i,j,k)的取值是(0,2,3)
     * a=1^2^3 b=4  (i,j,k)的取值是(0,3,3)
     * 所以对于n个元素的异或结果为0  那么可能的组合有n-1种
     *
     * @param arr
     * @return
     */
    public int countTriplets(int[] arr) {


        int curXOR=0;
        int total=0;

        for (int i=0;i<arr.length-1;i++){

            curXOR=arr[i];
            for (int j=i+1;j<arr.length;j++){

                curXOR^=arr[j];
                if (curXOR==0){

                    total+=j-i;
                }
            }

        }

        return total;

    }

    /**
     * a=arr[i] ~ arr[j−1]
     * b = arr[j] ~ arr[k]  连续不重叠
     * @param arr
     * @return
     */

//    public int countTriplets(int[] arr) {
//
//        int xor[]=new int[arr.length+1];
//
//        //xor[i]表示前i个数的异或和  比如xor[2] 表示xor[0]^xor[1]
//        for (int i=0;i<arr.length;i++)
//            xor[i+1]=xor[i]^arr[i];
//
//        int ans=0;
//        for (int i=1;i<=arr.length;i++){
//
//            for (int j=i+1;j<=arr.length;j++){
//
//                for (int k=j;k<=arr.length;k++){
//
//                    int a=xor[i-1]^xor[j-1];
//                    int b=xor[j-1]^xor[k];
//                    ans+=(a==b?1:0);
//                }
//            }
//
//        }
//        return ans;
//    }
}
