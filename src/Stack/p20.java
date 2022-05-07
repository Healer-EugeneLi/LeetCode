package Stack;

import java.util.Stack;

/**
 * @ClassName: p20
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/2
 * @Time: 11:01
 */
public class p20 {


    /**
     * 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        if (s.length()==1) return false;

        Stack stack=new Stack();

        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            //遇到左边的括号字符 则选择压入
            if (c=='('||c=='{'||c=='[')
                stack.add(c);
            else {
                //遇到右边的字符
                //此时如果栈为空 那肯定是不符合要求的 因为这样找不到左边的括号来跟它匹配
                if (stack.isEmpty()) return false;

                char top=(Character) stack.peek();
                if ((top=='('&&c==')')||(top=='{'&&c=='}')||(top=='['&&c==']')){
                    stack.pop();//符合要求找到一个匹配的 弹出栈顶
                }else
                    return false;
            }
        }
        //最后如果栈中是空  那就是符合要求的 因为都匹配到了
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        String str="()";
        p20 t=new p20();
        boolean res = t.isValid(str);
        System.out.println(res);
    }
}
