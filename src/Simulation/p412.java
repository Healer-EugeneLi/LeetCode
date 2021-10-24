package Simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: p412
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/13
 * @Time: 10:57
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 */
public class p412 {

    public String func(int n){

        if (n%3==0&&n%5==0)
            return "FizzBuzz";
        else if (n%3==0)
            return "Fizz";
        else if (n%5==0)
            return "Buzz";
        return String.valueOf(n);
    }

    public List<String> fizzBuzz(int n) {

        List<String> res=new ArrayList<>();
        for (int i=1;i<=n;i++){

            res.add(func(i));
        }
        return res;

    }
}
