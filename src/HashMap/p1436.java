package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: p1436
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/1
 * @Time: 19:14
 */
public class p1436 {

    public String destCity(List<List<String>> paths) {

        //key表示出发城市 value表示目的地城市
        HashMap<String, String> map = new HashMap<>();

        List<String> dest = new ArrayList<>();//存放终点 使用该值来作为key如果没有得到的值 则是终点

        for (List<String> list : paths) {
            map.put(list.get(0), list.get(1));
            dest.add(list.get(1));
        }

        for (String s : dest) {
            if (map.getOrDefault(s, "-1").equals("-1"))
                return s;
        }

        return "";
    }

    public static void main(String[] args) {

        List<List<String>> paths = new ArrayList<>();
        List<String> a = new ArrayList<>();
        a.add("A");
        a.add("Z");
        paths.add(a);

        p1436 t = new p1436();
        String s = t.destCity(paths);
        System.out.println(s);
    }
}
