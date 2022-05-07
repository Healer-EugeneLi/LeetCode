package DobulePoint;

/**
 * @ClassName: p415
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/3
 * @Time: 11:09
 */
public class p415 {

    /**
     * 双指针模拟字符串相加
     * 输入：num1 = "11", num2 = "123"
     * 输出："134"
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {

        StringBuilder res=new StringBuilder();
        int p1=num1.length()-1;
        int p2=num2.length()-1;
        int add=0;
        while (p1>=0||p2>=0){

            int n1=p1>=0?num1.charAt(p1)-'0':0;//如果此时有指向字符 那么就取出值 -'0' 得到数字 没有的话就直接为0
            int n2=p2>=0?num2.charAt(p2)-'0':0;

            int temp=n1+n2+add;//加上进位
            add=temp/10;//更新进位信息
            res.append((temp%10));//取余才是最终的结果添加到字符串
            p1--;
            p2--;
        }
        if (add==1)
            res.append(1);
        return res.reverse().toString();//注意最后要翻转过来返回 因为字符串是往后不断添加结果的 前面的才是尾部

    }
}
