package HashMap;

import com.sun.xml.internal.ws.api.ha.HaInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: p677
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/20
 * @Time: 22:32
 */
public class p677 {

    class MapSum {

        Map<String, Integer> map;

        public MapSum() {

            map = new HashMap<String, Integer>();
        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int res = 0;
            for (String key : map.keySet()) {
                if (key.startsWith(prefix))
                    res += map.get(key);
            }
            return res;
        }
    }
}
