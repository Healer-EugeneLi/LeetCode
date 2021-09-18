package Sort;

/**
 * @ClassName: MergeSort
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/11
 * @Time: 20:25
 */



public class MergeSort {

    //合并过程 left mid right分别都是索引
    private static void merge(int[] arr, int left, int mid, int right) {

        int[] help=new int[right-left+1];//临时空间

        int i=0;
        int p1=left,p2=mid+1;
        while (p1<=mid&&p2<=right){
            help[i++]=arr[p1]<=arr[p2]?arr[p1++]:arr[p2++];

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

    }

    //递归处理过程
    public static void process(int arr[],int left,int right){

        if(left==right) return;

        //取中点
        int mid=left+((right-left)>>1);

        process(arr,left,mid);//左侧
        process(arr,mid+1,right);
        merge(arr,left,mid,right);//对[left,mid] 左侧 还有[mid+1,right] 进行合并
    }



    public static void main(String[] args) {

        int[] num={2,3,4,1,2,4,5,6,3,4};
        process(num,0,num.length-1);
        for (int a:num)
            System.out.print(a+" ");

    }


}
