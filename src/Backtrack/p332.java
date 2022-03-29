package Backtrack;

import java.util.*;

/**
 * @ClassName: p332
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/26
 * @Time: 16:17
 */
public class p332 {


    public List<String> res=new ArrayList<>();
    //<出发机场，<到达机场，航班次数>>
    public Map<String, Map<String,Integer>> map=new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {


        for (List<String> ticket:tickets){

            Map<String,Integer> temp;
            //获取当前航班的出发机场 到达机场 因为每一个ticket的列表中中只有两个元素
            String start = ticket.get(0);
            String end=ticket.get(1);
            if (map.containsKey(start)){
                //此时总的哈希表中 有 当前这个start出发的机场
                temp=map.get(start);
                //map.get(start)先获取对应key为start的value 也就是得到出发机场以及对应的航班次数的map
                temp.put(end,map.get(start).getOrDefault(end,0)+1);
            }else {
                //此时总的哈希表中 没有  当前这个start出发的机场
                temp=new TreeMap<>();//为了进行排序
                temp.put(end,1);
            }

            map.put(start,temp);
        }

        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }

    public boolean backTracking(int ticketNum){

        if (res.size()==ticketNum+1){
            return true;
        }

        //先获取此时要开始出发的机场
        String start = res.get(res.size() - 1);
        if (map.containsKey(start)){
            //防止出现null
            Set<Map.Entry<String, Integer>> entries = map.get(start).entrySet();//获取其对应的到达机场 以及航班次数
            for (Map.Entry<String,Integer> entry:entries){

                int count=entry.getValue();
                if (count>0){
                    //说明此时这个机场还可以到达
                    res.add(entry.getKey());
                    entry.setValue(count-1);//设置其可以到达航班次数-1
                    if (backTracking(ticketNum)) return true;
                    res.remove(res.size()-1);
                    entry.setValue(count);//设置为原先的值
                }

            }

        }

        return false;
    }
}
