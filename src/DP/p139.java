package DP;

import java.util.List;

/**
 * @ClassName: p139
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/30
 * @Time: 8:52
 *
 * 单词拆分
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。字典中的单词可以重复

 */
public class p139 {

    /**
     *  单词拆分
     *  输入: s = "leetcode", wordDict = ["leet", "code"]
     *  输出: true
     *  解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。字典中的单词可以重复
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        //dp[i]表示 前i个字符串是否可以被拆分
        //递推过程 dp[i]如果可以被拆分 那么可以分解成 前k个字符已经可以拆分注意k的范围是在[0,i) 然后[k+1,i]对应的字符存在于字典中
        boolean dp[]=new boolean[s.length()+1];
        dp[0]=true;//dp[0]表示空字符串  边界

        //遍历字符串长度 当i=1的时候 表示s的中长度为1的时候 其是否可以被拆分的情况 dp[1]即前1个字符
        for (int i=1;i<=s.length();i++){

            //k来控制前k个字符要冲dp中获取结果 然后[k,i) 要从s中进行截取
            // 比如 当i=1的时候 k=0 表示dp[0]的结果与判断子串[0,1)是否在字典中
            //当i=3的时候 k只能取0 1 2
            //k=0  dp[0]与 子串[0,3)
            //k=1  dp[1]与子串[1,3) 长度为1的子串是否可以拆分  以及在字典中是否存在索引[1,3)的子串
            //k=2  dp[2]与子串[2,3)
            for (int k=0;k<i;k++){

                dp[i]=dp[k]&&wordDict.contains(s.substring(k,i));
                //如果此时已经知道dp[i]=true 表示前i个字符构成的字符串可以在字典中找到拆分的结果 直接退出 判断下一个即dp[i+1]
                if (dp[i]==true)
                    break;
            }
        }

        //最后返回的结果为字符串长度的dp值
        return dp[s.length()];
    }
}
