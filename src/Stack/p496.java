package Stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @ClassName: p496
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/26
 * @Time: 22:45
 */
public class p496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        //维护一个从栈低到栈顶递减的栈
        //当遍历到的元素大于栈顶的元素的时候 此时栈顶的下一个比他大的元素就是遍历到的元素 记录下来
        //并且弹出栈顶 同时压入遍历到的元素
        for (int i = 0; i < nums2.length; i++) {

            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                //栈不为空  此时遍历到的元素大于栈顶元素 出栈 并且进行记录
                map.put(stack.pop(), nums2[i]);
            }
            stack.add(nums2[i]);
        }
        int res[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {

            if (!map.containsKey(nums1[i]))
                res[i] = -1;
            else
                res[i] = map.get(nums1[i]);
        }

        return res;

    }

    public static void main(String[] args) {

        int nums1[] = {2, 4};
        int nums2[] = {1, 2, 3, 4};

        p496 t = new p496();
        int[] res = t.nextGreaterElement(nums1, nums2);
        for (int a : res)
            System.out.println(a);
    }
}
