package Tree;

/**
 * @ClassName: AOTU
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/28
 * @Time: 21:02
 */
public class AOTU {


    /**
     * 递归过程来到某一个结点
     * i是节点的层数 N一共的层数 down==true 表示凹 down==false 凸
     * @param i
     * @param n
     * @param down
     */
    public static void process(int i,int n,boolean down){

        if (i>n) return;

        process(i+1,n,true);//执行左边凹的部分
        System.out.println(down==true?"凹":"凸");
        process(i+1,n,false);//执行右边凸的部分
    }
    public static void main(String[] args) {

        int N=3;
        process(1,N,true);

    }
}
