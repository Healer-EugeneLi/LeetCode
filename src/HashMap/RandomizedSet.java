package HashMap;

import java.util.*;

/**
 * @ClassName: RandomizedSet
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/4
 * @Time: 10:39
 */
public class RandomizedSet {

    public List<Integer> list;//代表位置 比如索引为0的位置放了8 就表示8这个元素 然后map对应就是 8->0
    public HashMap<Integer, Integer> map;//key为输入进来的值 value是其在list上的位置

    public RandomizedSet() {

        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * 插入值
     *
     * @param val
     * @return
     */
    public boolean insert(int val) {

        if (map.containsKey(val)) return false;//如果已经有这个值了 那么不能再插入
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /**
     * 移除值
     * 使用移除最后一个数 然后吧最后一个数修改到原本应该删除的位置
     *
     * @param val
     * @return
     */
    public boolean remove(int val) {

        if (!map.containsKey(val)) return false;//如果没有 就不用移除

        //原本应该在的位置
        Integer old = map.get(val);
        Integer last = list.get(list.size() - 1);//最后一个值
        //这个位置现在放list的最后一个值
        list.set(old, last);
        //将最后一个元素移除 并将其填充到应有的位置
        list.remove(list.size() - 1);
        map.put(last, old);

        map.remove(val);//删除掉真正要删除的元素


        return true;
    }

    public int getRandom() {

        //在已有的大小上生成随机数 随机索引
        int rand = (int) (Math.random() * list.size());

        return list.get(rand);
    }


}
