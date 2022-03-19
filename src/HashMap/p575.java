package HashMap;

import java.util.HashSet;

/**
 * @ClassName: p575
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/1
 * @Time: 9:24
 */
public class p575 {

    public int distributeCandies(int[] candyType) {

        HashSet set = new HashSet();

        int need = 0;
        for (int candy : candyType) {
            set.add(candy);
        }

        int size = set.size();//总种类的数量
        //最多只能有一半
        int mid = candyType.length / 2;

        return Math.min(mid, size);


    }
}
