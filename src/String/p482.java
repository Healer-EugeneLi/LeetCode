package String;

/**
 * @ClassName: p482
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/4
 * @Time: 9:30
 * 输入：S = "5F3Z-2e-9-w", K = 4
 * 输出："5F3Z-2E9W"
 * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 * <p>
 * 。
 */
public class p482 {
    public String licenseKeyFormatting(String s, int k) {


        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        char[] chars = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {

            if (chars[i] == '-') continue;
            if (cnt == k) {
                sb.append('-');
                cnt = 0;
            }
            sb.append(chars[i]);
            cnt++;

        }
        return sb.reverse().toString().toUpperCase();

    }
}
