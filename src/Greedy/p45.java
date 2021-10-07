package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: p45
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/2
 * @Time: 21:10
 */
public class p45 {



    public class MyComparator implements Comparator<String>{


        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }
    }

    public String minNumber(int[] nums) {

        String strs[]=new String[nums.length];
        for (int i=0;i<nums.length;i++){
            strs[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(strs,new MyComparator());

        String res="";
        for (int i=0;i<strs.length;i++){
            res+=strs[i];
        }
        return res;

    }
}
