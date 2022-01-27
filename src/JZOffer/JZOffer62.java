package JZOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: JZOffer62
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/12/11
 * @Time: 21:43
 */
public class JZOffer62 {

    public int lastRemaining(int n, int m) {

        List<Integer> num=new ArrayList<>();

        for (int i=0;i<n;i++)
            num.add(i);
        //删除n-1个数字 最后剩一个数字
        int delIndex=0;
        while (n>1){
            delIndex=(delIndex+m-1)%num.size();//此时要删除的数字的索引
            num.remove(delIndex);
            n--;

        }
        return num.get(0);

    }
}
