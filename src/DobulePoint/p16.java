package DobulePoint;

import java.util.Arrays;

/**
 * @ClassName: p16
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/20
 * @Time: 20:37
 * 最接近的三数之和
 */
public class p16 {
//    public int threeSumClosest(int[] nums, int target) {
//
//        int length=nums.length;
//        Arrays.sort(nums);//先排序
//        int left=0,right=0;
//        int nearTarget=0,distance=Integer.MAX_VALUE;
//        for (int i=0;i<length-2;i++){
//
//            for (left=i+1;left<length-1;left++){
//                right=nums.length-1;
//                while (left<right){
//
//                    int sum=nums[i]+nums[left]+nums[right];
//                    if (Math.abs(sum-target)<distance){
//                        //如果两个更近
//                        distance=Math.abs(sum-target);
//                        nearTarget=sum;
//
//                    }
//                    right--;
//                }
//            }
//
//
//        }
//        return nearTarget;
//
//    }

    public int threeSumClosest(int[] nums, int target) {

        int length=nums.length;
        Arrays.sort(nums);//先排序
        int left=0,right=0;
        int nearTarget=nums[0]+nums[1]+nums[2];
        for (int i=0;i<length-2;i++){

            left=i+1;
            right=nums.length-1;
            while (left<right){

                int sum=nums[i]+nums[left]+nums[right];
                if (Math.abs(sum-target)<Math.abs(nearTarget-target)){
                    nearTarget=sum;
                }
                if (sum==target) return sum;
                else if (sum>target){
                    right--;
                }else left++;
            }

        }
        return nearTarget;

    }

    public static void main(String[] args) {
        int arr[]={0,1,2,-3};

        p16 p16=new p16();
        int res = p16.threeSumClosest(arr, 1);
    }
}
