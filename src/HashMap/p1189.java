package HashMap;

/**
 * @ClassName: p1189
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/1
 * @Time: 22:06
 */
public class p1189 {


    public int maxNumberOfBalloons(String text) {

        //构建一个数组 记录一下每个单词出现的个数
        int num[] = new int[26];
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            num[chars[i] - 'a']++;//a 即对应到0
        }

        int b = num['b' - 'a'];
        int a = num['a' - 'a'];
        int l = num['l' - 'a'] / 2;//因为一个单词里面需要两个l
        int o = num['o' - 'a'] / 2;
        int n = num['n' - 'a'];

        int res1 = 0, res2 = 0;
        res1 = Math.min(b, a);
        res2 = Math.min(l, o);
        res1 = Math.min(res1, n);
        res1 = Math.min(res1, res2);
        return res1;

    }
}
