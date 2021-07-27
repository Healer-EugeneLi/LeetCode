package Sort;

import java.util.*;

/**
 * @ClassName: Sort.MedianSortedArrays
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/5/14
 * @Time: 18:07
 */


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> list=new ArrayList<>();
        for(int num:nums1){
            list.add(num);
        }
        for(int num:nums2){
            list.add(num);
        }

        Collections.sort(list);

        int len=list.size();
        if(len%2==0) {
            int left = list.get(len / 2 - 1);
            int right = list.get(len / 2);
            double res = (left + right) / 2.0;
            return res;
        }else {
            return list.get((len-1)/2);
        }

    }
}
public class MedianSortedArrays {

    public static void main(String[] args) {

        Solution s=new Solution();
        int a[]={1,2};
        int b[]={3,4};

        double res = s.findMedianSortedArrays(a, b);
        System.out.println(res);

    }

}



