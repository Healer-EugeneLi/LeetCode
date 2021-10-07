package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName: p1346
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/1
 * @Time: 22:21
 */
public class p1346 {
    public boolean checkIfExist(int[] arr) {

        HashSet<Integer> set=new HashSet<>();
        int count=0;
        for (int a:arr){
            if (a==0) count++;
            if (count==2) return true;
            set.add(a);
        }


        for (int a:arr){
            if (a==0) continue;
            double t1=a/2.0;
            int t2=a*2;
            if (set.contains(t1)||set.contains(t2)) return true;
        }

        return false;
    }
}
