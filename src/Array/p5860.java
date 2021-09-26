package Array;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @ClassName: p5860
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/19
 * @Time: 16:48
 */
public class p5860 {

//    public int[] findOriginalArray(int[] changed) {
//
//        int length=changed.length;
//        if (length%2!=0) return new int[]{};
//
//        Arrays.sort(changed);
//
//        List<Integer> res=new ArrayList<>();
//
//
//
//        for (int i=length-1;i>=0;i--){
//
//            int cur=changed[i];
//            if (cur==-1) continue;
//            double find=(double) cur/2;
//            for (int j=0;j<i;j++){
//                if (find==changed[j]){
//                    //找到 那么设置为-1
//                    changed[i]=-1;
//                    changed[j]=-1;
//                    res.add((int)find);
//                    break;
//                }
//            }
//        }
//
//        for (int i=0;i<changed.length;i++){
//            if (changed[i]!=-1) return new int[]{};
//        }
//
//        int[] arr = new int[res.size()];
//        for (int i=0;i<res.size();i++){
//            arr[i]=res.get(i);
//        }
//
//        return arr;
//
//    }

    public int[] findOriginalArray(int[] changed) {

        int length=changed.length;
        if (length%2!=0) return new int[]{};

        Arrays.sort(changed);

        List<Integer> res=new ArrayList<>();

        Queue<Integer> queue=new LinkedList<>();

        for (int a:changed){

            if (!queue.isEmpty()&&queue.peek()*2==a){
                res.add(queue.poll());
            }else
                queue.add(a);

        }
        int[] arr = new int[res.size()];
        if (!queue.isEmpty()) return new int[]{};
        else{
            for (int i=0;i<res.size();i++){
                 arr[i]=res.get(i);
            }
        }


        return arr;
    }


    public static void main(String[] args) {

        p5860 t=new p5860();
        int a[]={6,3,0,1};
        int[] originalArray = t.findOriginalArray(a);
    }
}


class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n % 2 == 1)
            return new int[]{};
        Arrays.sort(changed);
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[n/2];
        int count = 0;
        for(int i=0;i<n;i++){
            map.put(changed[i],map.getOrDefault(changed[i],0)+1);
        }
        for(int i=0;i<n;i++){
            int doubleNum = changed[i] * 2;
            if(map.get(changed[i]) == -1)
                continue;

            if(map.containsKey(doubleNum) && map.get(doubleNum) != -1){
                res[count++] = changed[i];
                Integer originValue = map.get(changed[i]);
                if(originValue-1 == 0){
                    map.put(changed[i],-1);
                }
                else map.put(changed[i],originValue-1);

                Integer doubleValue = map.get(doubleNum);
                if(doubleValue-1 < 0){
                    return new int[]{};
                }
                else if(doubleValue-1 == 0){
                    map.put(doubleNum,-1);
                }
                else map.put(doubleNum,doubleValue-1);
            }
            else return new int[]{};
        }
        return res;

    }
}
