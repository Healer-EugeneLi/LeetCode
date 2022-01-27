package HashMap;

import java.util.HashMap;

/**
 * @ClassName: p423
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/25
 * @Time: 20:40
 *
 */
public class p423 {
    /**

     one
     two
     three
     four
     five
     six
     seven
     eight
     nine
     ten

     */
    public String originalDigits(String s) {
      //0 2 4 6 8先计算
        //z w u x g
        String[] ss=new String[]{"zero","one","two","three","four","five","six","seven","eight","nine","ten"};
        HashMap<Character,Integer> map=new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i=0;i<s.length();i++){
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);
        }

        int num[]=new int[10];

        num[0]=map.getOrDefault('z',0);
        num[2]=map.getOrDefault('w',0);
        num[4]=map.getOrDefault('u',0);
        num[6]=map.getOrDefault('x',0);
        num[8]=map.getOrDefault('g',0);

        //h 只在3 和8出现 知道8 就知道3了
        num[3]=map.getOrDefault('h',0)-num[8];

        //f 只在4和5出现 知道4 就能知道5 了
        num[5]=map.getOrDefault('f',0)-num[4];

        //s只在6和7出现 知道6 求7
        num[7]=map.getOrDefault('s',0)-num[6];

        //o 出现在0 1 2 4
        num[1]=map.getOrDefault('o',0)-num[0]-num[2]-num[4];

        //计算9 i出现在5 6 8
        num[9]=map.getOrDefault('i',0)-num[5]-num[6]-num[8];

        String res="";
        for (int i=0;i<10;i++){

            while (num[i]-->0){
                res+=String.valueOf(i);
            }
        }
        return res;

    }
}
