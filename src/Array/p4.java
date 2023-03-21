package Array;

import java.util.*;

/**
 * @ClassName: p4
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/8
 * @Time: 11:13
 */
public class p4 {


    /**
     * 合并两个有序数组的中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //让upLen 指向上面的数组的长度 并且保证上面的长度是小于下面的长度 通过递归保证
        int upLen=nums1.length;
        int lowLen= nums2.length;
        if(upLen>lowLen){
            return findMedianSortedArrays(nums2,nums1);//保证上面数组长度小于下面的数组长度
        }

        int iMin=0,iMax=upLen;
        while (iMin<=iMax){

            int i=iMin+((iMax-iMin)>>1);
            int j=(upLen+lowLen+1)/2-i;//由i确定j 同时也确保了最后这个位置就是分割出来可以求出中位数的位置

            //交叉比较 来判断i是大的还是小的 符合的条件是 左上<右下 左下<右上
            //出现了左下>右上的情况 此时i小了  需要往右区间查找
            if(j!=0&&i!=upLen&&nums2[j-1]>nums1[i]){
                iMin=i+1;
            }else if (i!=0&&j!=lowLen&&nums1[i-1]>nums2[j]){
                //出现了左上>右下的情况 此时i大了 需要减小 往左区间查找
                iMax=i-1;

            }else {

                //达到要求了  此时需要将边界条件单独拿出来考虑
                int maxLeft=0;
                if (i==0) maxLeft=nums2[j-1];//只有左下角
                else if (j==0) maxLeft=nums1[i-1];//只有左上角
                else
                    maxLeft=Math.max(nums1[i-1],nums2[j-1]);

                if ((upLen+lowLen)%2==1) return maxLeft;//如果是奇数 不用考虑右边部分

                //如果是偶数的长度的话 再求右边的最小值
                int minRight=0;
                if (i==upLen)
                    minRight=nums2[j];//没有右上 只有右下
                else if (j==lowLen)
                    minRight=nums1[i];//没有右下 只有右上
                else
                    minRight=Math.min(nums1[i],nums2[j]);

                return (maxLeft+minRight)/2.0;
            }
        }
        return 0;

    }


    class Demo{
        private final int arr[]={1,2,3,4};

        public void set(){
            this.arr[1]=4444;
        }

        @Override
        public String toString() {
            return "Demo{" +
                    "arr=" + Arrays.toString(arr) +
                    '}';
        }
    }
    public static void main(String[] args) {

//
//        p4 t=new p4();
//        Demo demo = t.new Demo();
//        demo.set();
//        System.out.println( demo.toString());

        Map map=new HashMap();
        map.put(null,null);

        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){

            Object next = iterator.next();
            System.out.println(map.get(next));
        }

        Hashtable hashtable=new Hashtable();
        hashtable.put(null,null);

        Enumeration keys = hashtable.keys();
        System.out.println(keys);


    }



}
