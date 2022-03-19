package Tree;

import java.util.List;

/**
 * @ClassName: MaxHappy2
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/28
 * @Time: 21:12
 * <p>
 * 写法更加优雅的 最大快乐值
 * <p>
 * 当员工x来的时候
 * 最大值=x的快乐值+x的下级员工都不来时的最大值
 * 当员工x不来的时候
 * 最大值=0+x的所有下级员工 来与不来中取最大值
 */
public class MaxHappy2 {

    class Employee {

        int happy;
        List<Employee> nexts;//下级员工

    }


    class Info {
        int laiMaxHappy;//如果这个节点来的时候 最大值为多少
        int buMaxHappy;//当这个节点不来的时候 最大值

        public Info(int lai, int bu) {
            laiMaxHappy = lai;
            buMaxHappy = bu;
        }
    }

    //x为根节点的时候
    public Info process(Employee x) {

        //当x没有下级员工的时候
        if (x.nexts.isEmpty()) {
            //x 来的时候本身的快乐值 x不来的时候为0
            new Info(x.happy, 0);
        }

        //当x有下级员工的时候

        int lai = x.happy;//x来 快乐值加上
        int bu = 0;//x不来 快乐值0

        //对x的所有下级员工进行考虑
        for (Employee next : x.nexts) {

            //当x来的时候 最大值+所有下级员工都不能来的时候的最大值
            Info nextInfo = process(next);
            lai += nextInfo.buMaxHappy;//next这个员工不来的时候的最大值

            //当x不来的时候 x的下级员工可以来 也可以不来 取最大值
            bu += Math.max(nextInfo.laiMaxHappy, nextInfo.buMaxHappy);

        }

        return new Info(lai, bu);
    }

    /**
     * 以boss为根节点的这颗树所能得到的最大快乐值
     *
     * @param boss
     * @return
     */
    public int maxHappy(Employee boss) {

        Info info = process(boss);
        //boss来 或者不来 两者之间取最大值
        return Math.max(info.laiMaxHappy, info.buMaxHappy);
    }
}
