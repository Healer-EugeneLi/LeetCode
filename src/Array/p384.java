package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @ClassName: p384
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/22
 * @Time: 19:25
 */
public class p384 {

//    class Solution {
//
//        public int old[];
//        public int arr[];
//        public Solution(int[] nums) {
//
//
//            old=new int[nums.length];
//            arr=new int[nums.length];
//            for (int i=0;i<nums.length;i++){
//                old[i]=nums[i];
//                arr[i]=nums[i];
//            }
//
//        }
//
//        public int[] reset() {
//
//            return old;
//        }
//
//        public int[] shuffle() {
//
//            List<Integer> list=new ArrayList<>();
//            for (int a:arr)
//                list.add(a);
//            Collections.shuffle(list);
//            for (int i=0;i<list.size();i++)
//                arr[i]=list.get(i);
//            return arr;
//        }
//    }

    class Solution {

        public int n;//长度
        public int arr[];
        Random random=new Random();
        public Solution(int[] nums) {
            arr=nums;
            n=nums.length;

        }

        public int[] reset() {
            return arr;
        }

        public int[] shuffle() {

            int [] res=arr.clone();//复制一份数组
            for (int i=0;i<n;i++){
                //对i这个索引位置 随机从[i,n-1)这个索引范围里寻找
                //对于 random.nextInt(5) 随机范围在0~4
                int j=i+ random.nextInt(n-i);
                swap(res,i,j);
            }
            return res;

        }

        public void swap(int arr[],int i,int j){

            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }


    public static void main(String[] args) {
        Random random=new Random();
        int i = random.nextInt(5);
        System.out.println(i);
    }
}
