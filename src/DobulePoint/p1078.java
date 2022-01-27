package DobulePoint;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: p1078
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/12/26
 * @Time: 13:42
 */
public class p1078 {

    public String[] findOcurrences(String text, String first, String second) {


        String[] s = text.split(" ");
        int left=0,right=1;
        List<String> res=new ArrayList<>();

        while (left<s.length-1){

            if (s[left].equals(first)&&s[right].equals(second)&&(right+1<s.length)){
                res.add(s[right+1]);

            }
            left++;
            right++;
        }

        String[] result=new String[res.size()];
        for (int i=0;i<res.size();i++){
            result[i]=res.get(i);
        }

        return result;
        //直接按照这样写也行 return res.toArray(new String[res.size()]);


    }
}
