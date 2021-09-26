package DobulePoint;

/**
 * @ClassName: p26
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/20
 * @Time: 20:05
 */
public class p26 {

    public int removeDuplicates(int[] nums) {

        int length=nums.length;
        if (length==0||length==1) return length;

        int left=0;//指向当前已满足条件的数的指针

        //i用于寻找下一个与left所指向的结点不一样的 如果该节点在left的下一个 则直接left++ i++ 如果该节点不在left的下一个 那么与其交换 left++ i++
        for (int i=1;i<length;i++){


            if (nums[i]==nums[left]) continue;
            else if (nums[i]!=nums[left]&&i==left+1){
                //说明是前后而已
                left++;
            }else {
                //num[i]该节点与left下一个结点交换
                int temp=nums[i];
                nums[i]=nums[left+1];
                nums[left+1]=temp;
                left++;
            }
        }
        return left+1;//left是下标索引 个数应该等于索引+1

    }

    public static void main(String[] args) {
        int arr[]={1,1,2};
        p26 p26=new p26();
        int res = p26.removeDuplicates(arr);

    }
}
