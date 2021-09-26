package Sort;

/**
 * @ClassName: RadisSort
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/26
 * @Time: 11:24
 */
public class RadixSort {


    //函数入口 基数排序
    public static void radixSort(int[] arr){
        if (arr==null||arr.length<2)
            return;
        radixSort(arr,0,arr.length-1,maxbits(arr));
    }

    /**
     * 求出x的第d位上的数 d=1就是个位数
     * @param x
     * @param d
     * @return
     */
    public static int getDigit(int x,int d){

        return (x/(int)Math.pow(10,d-1))%10;

    }

    /**
     * 求解数组中最大数有几位 比如100 就是3位
     * @param arr
     * @return
     */
    public static int maxbits(int[] arr){

        int max=Integer.MIN_VALUE;

        for (int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        int res=0;
        while (max!=0){
            res++;
            max/=10;
        }
        return res;
    }

    /**
     * arr begin-end这个区间 排序 digit是最大的位数
     * @param arr
     * @param begin
     * @param end
     * @param digit
     */
    public static void radixSort(int[] arr,int begin,int end,int digit){

        final int radix=10;//10进制
        int i=0,j=0;

        int[] bucket=new int[end-begin+1];//临时数组（桶）
        for (int d=1;d<=digit;d++){//按照个十百千循环
            int count[]=new int[radix];//记录这一位上出现了几个数
            for ( i=begin;i<=end;i++){

                j=getDigit(arr[i],d);
                count[j]++;
            }

            //转换成前缀和数组 该位上 小于下标i的数有count[i]个
            count[i]=count[i]+count[i-1];

            //收桶
            for (i=end;i>=begin;i--){//从右往左遍历
                j=getDigit(arr[i],d);//求出该数字在d位上的数字j
                bucket[count[j]-1]=arr[i];//所有的数字在d位上小于等于j的一共有count[j]个
                count[j]--;
            }

            for (i=begin,j=0;i<=end;i++,j++){
                //拷贝回原数组 反复使用桶
                arr[i]=bucket[j];
            }

        }
    }
}
