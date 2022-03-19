package HashMap;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName: p217
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/26
 * @Time: 15:57
 */
public class p217 {

    public boolean containsDuplicate(int[] nums) {

        HashSet set = new HashSet();

        for (int num : nums) {
            if (set.contains(num)) return true;
            else
                set.add(num);
        }

        return false;

    }
}
