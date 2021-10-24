package FamousQuestion;

/**
 * @ClassName: KPM
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/9
 * @Time: 15:29
 */
public class KMP {


    /**
     * s串中找m串的 返回能正确匹配上的下标
     * @param s
     * @param m
     * @return
     */
    public static int getIndexOf(String s,String m){
        if (s==null||m==null||m.length()<1||s.length()<m.length())
            return -1;//不可能存在匹配的情况

        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();

        int i1=0;//控制str1的移动指针
        int i2=0;//控制str2的移动指针
        int next[]=getNextArray(str2);//O(M)
        //O(N)

        while (i1<str1.length&&i2<str2.length){

            //如果两个指针遇到的字符 相等 那么继续往下移动
            if (str1[i1]==str2[i2]){
                i1++;
                i2++;
            }else if (i2==0){
                //或者是next[i2]==-1 表示已经没有办法加速了 只能回到开头继续判断了 此时你的i1就换下一个开始判断
                i1++;
            }else {
                //这个时候就是可以加速的情况 next数组里面有最长前缀后缀匹配
                i2=next[i2];//str2中从开始不等的那个字符 取出应该到哪个位置去继续匹配 加速
                //当已经没有办法加速的时候 i2在这里被取出来 其结果是0 表示应该让str2从0位置开始继续找了 到时候i1就得++从下一个位置开始
            }
        }
        //i1越界了或者i2越界了
        //如果i2已经遍历完了 说明可以找到 此时让i1减去i2的值 就得到了str1匹配出str2的第一个开始的位置
        return i2==str2.length?i1-i2:-1;
        

    }

    /**
     * 获取next数组
     * @param str2
     * @return
     */
    private static int[] getNextArray(char[] str2) {

        //如果只有一个字符 那么一个字符的情况下没有最长前后缀匹配
        if (str2.length==1){
            return new int[]{-1};
        }
        //人为规定0 1两个位置
        int next[]=new int[str2.length];
        next[0]=-1;//第0个字符没有最长前后缀 设置为-1
        next[1]=0;//第一个字符 由于不能算自身 那么其最长前后缀匹配的长度是0

        int i=2;//next数组的位置 就是要求的i这个位置的最长前后缀匹配的长度
        //表示对于第i个字符而言 要找i-1这个字符的最长前后缀匹配的长度的下一个位置 其实际值就是i-1最长前后缀匹配长度 比如next[i-1]=7 表明0-6是最长的 那么下一个位置就是7
        //前缀的下一个字符的位置=前缀的长度
        int cn=0;
        while (i<next.length){
            //对于每一个i 即str2字符串里的每个字符 都需要求next数组

            if (str2[i-1]==str2[cn]){
                //如果此时i-1这个字符=i-1最长前后缀匹配的串的下一个字符 那说明此时的i这个位置的最长前后缀匹配长度=i-1的最长+1
                next[i]=cn+1;//因为cn同时是表达i-1这个字符的最长匹配的长度 那么让 其+1
                i++;//计算下一个位置的最长前后缀匹配长度
                ++cn;//确保对于i+1而言 其前一个字符即i 他的最长前后缀匹配的长度 能找到（也是该串的下一个位置）
            }else if (cn>0){
                //当前跳到cn位置的字符 和i-1位置的字符匹配不上 那么往前跳
                cn=next[cn];//cn位置的最长前后缀的串的下一个字符位置 即长度
            }else {
                //此时cn不大于0  说明没办法往前跳了 i这个位置的next数组中只能等于0
                next[i++]=0;
            }
        }
        return next;

    }

    public static void main(String[] args) {

    }
}
