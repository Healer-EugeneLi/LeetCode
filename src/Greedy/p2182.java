package Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName: p2182
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/27
 * @Time: 15:27
 */
public class p2182 {

    public String repeatLimitedString(String s, int repeatLimit) {



        //先统计各个字符存在的个数

        int[] chars=new int[26];
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            chars[c-'a']++;
        }

        String res="";
        for (int i=25;i>=0;i--){

            int pre=i-1;
            for (;;){
                //最大的次数要求之内
                for (int j=0;j<repeatLimit&&chars[i]>0;j++){
                    res+=(char)(i+'a');
                    chars[i]--;

                }
                if (chars[i]==0){
                    //当前这个字符用完
                    break;
                }

                //此时当前字符还有剩 从后往前找 知道存在一个更小的字符 先用一次小的字典码的字符
                while (pre>=0&&chars[pre]==0){
                    pre--;
                }
                if (pre<0) break;

                res+=(char)(pre+'a');
                chars[pre]--;

            }

        }

        return res;

    }

    public static void main(String[] args) {

        String s="aababab";
        int rep=2;

        p2182 t=new p2182();
        String res = t.repeatLimitedString(s, rep);
        System.out.println(res);

    }
}
