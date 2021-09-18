package Sort;

/**
 * @ClassName: SmallSum
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/11
 * @Time: 21:50
 */
public class SmallSum {


    public static int smallSum(int arr[],int left,int right){

        if (left==right) return 0;

        int mid=left+((right-left)>>1);


        return smallSum(arr,left,mid)+
                smallSum(arr,mid+1,right)+
                merge(arr,left,mid,right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {

        int[] help=new int[right-left+1];//临时空间

        int res=0;
        int i=0;
        int p1=left,p2=mid+1;
        while (p1<=mid&&p2<=right){
            //如果左边的数 小于右边的某一个数 那么右边的这个数的后面肯定也比这个数大 直接计算个数
            res+=arr[p1]<arr[p2]?(right-p2+1)*arr[p1]:0;
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];//这边要严格小于才行 arr[p1]<ar[p2] 当等于的时候先拷贝右边

        }

        while (p1<=mid){
            //左边还有没放完的元素
            help[i++]=arr[p1++];
        }
        while (p2<=right){
            help[i++]=arr[p2++];
        }
        for (int j=0;j<help.length;j++){
            arr[left+j]=help[j];
        }
        return res;
    }

    public static void main(String[] args) {

        int arr[]={1,3,4,2,5};

        System.out.println(smallSum(arr,0,arr.length-1));
    }
}
