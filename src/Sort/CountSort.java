package Sort;/**
*@ClassName: CountSort
*@Description:
*@Author EugeneLi
*@Date: 2021/9/26
*@Time: 10:32
*/
public class CountSort {

    public static void sort(int[] arr){

        if (arr==null||arr.length<2)return;

        int max=Integer.MIN_VALUE;

        for (int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }

        int bucket[]=new int[max+1];

        for (int i=0;i<arr.length;i++){
            bucket[arr[i]]++;//取出i这个数 值为arr[i] 以arr[i]为下标在bucket这个数组中更新出现的次数
        }

        //重新排序
        int i=0;
        for (int j=0;j<bucket.length;j++){

            while (bucket[j]-->0){
                arr[i++]=j;
            }
        }
    }

    public static void main(String[] args) {


        int a=1092;

        int res=0;

        while (a!=0){
            a/=10;
            res++;
        }
        System.out.println(res);
    }
}
