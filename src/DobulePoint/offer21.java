package DobulePoint;

/**
 * @ClassName: offer21
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/26
 * @Time: 14:52
 * 奇数放左边 偶数放右边
 */
public class offer21 {

    public void swap(int arr[],int i,int j){
        if (i!=j){
            arr[i]=arr[i]^arr[j];
            arr[j]=arr[i]^arr[j];
            arr[i]=arr[i]^arr[j];
        }
    }

    public int[] exchange(int[] nums) {

        if (nums.length==0||nums.length==1) return nums;
        int left=0,right=nums.length-1;

        while (left<right){

            if (nums[left]%2==0&&nums[right]%2==1){
                //交换两个位置
                swap(nums,left,right);
                left++;
                right--;
            }else if (nums[left]%2==1) {
                left++;
            }else if (nums[right]%2==0)
                right--;
        }

        return nums;

    }

    public static void main(String[] args) {

        int nums[]={1,2,3,4,3,5,1,2,3,1,44,1};
        offer21 offer21=new offer21();
        int[] exchange = offer21.exchange(nums);
        System.out.println();
    }
}
