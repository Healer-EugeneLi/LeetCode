package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MaxHappy
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/28
 * @Time: 20:47
 * 最大快乐值
 */
public class MaxHappy {

    class Employee {

        public int happy;//快乐值

        List<Employee> subs;//这名员工有哪些直接下级
    }

    class Info {

        public int happy;
        Employee employee;//employee为根节点的时候 正个树的最大价值为happy

        public Info(int h, Employee employee) {
            happy = h;
            employee = employee;
        }
    }

    //以x为根节点的树的返回信息
    public Info process(Employee x) {

        if (x == null)
            return new Info(0, null);

        //子树信息
        List<Info> subInfo = new ArrayList<>();
        for (Employee sub : x.subs) {
            subInfo.add(process(sub));
        }


        //如果给x发请帖了
        int max1 = x.happy;//x的happy值就要加上

        //如果不给x发请帖
        int max2 = 0;


        for (Info info : subInfo) {

            max2 += process(info.employee).happy;

            List<Employee> subsub = info.employee.subs;//子树的子树
            for (Employee e : subsub) {
                max1 += process(e).happy;//发了x的话此时就要加x的子树的子树
            }
        }


        int max = Math.max(max1, max2);
        return new Info(max, x);
    }
}
