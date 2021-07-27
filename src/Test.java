import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Test
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/6/9
 * @Time: 22:16
 */
public class Test {

    public static void main(String[] args) {

        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);

        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }
}
