package UnionFind;

/**
 * @ClassName: UnionFindArr
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/8
 * @Time: 15:33
 *
 * 数组版的 并查集 初始版
 */
public class UnionFindArr {

    /**
     * 数组 表示并查集的所有元素
     */
    private int id[];

    /**
     * 并查集的元素个数
     */

    private int size;


    /**
     * 构建一个新的并查集
     * @param size 初始化并查集大小
     */
    public UnionFindArr(int size){

        this.size=size;
        id=new int[size];
        for (int i=0;i<size;i++)
            id[i]=i;
    }

    /**
     * 查看元素属于哪个集合
     * @param element
     * @return
     */
    public int find(int element){

        return id[element];
    }

    /**
     * 判断两个元素是否属于同一个集合
     * @param a
     * @param b
     * @return
     */
    public boolean isSameSet(int a,int b){

        return find(a)==find(b);
    }

    /**
     * 合并两个元素所在的集合
     * @param a
     * @param b
     */
    public void unionElement(int a,int b){

        int aFather = find(a);
        int bFather = find(b);

        //如果两个不是同一个集合 那么合并
        if (aFather!=bFather){
            for (int i=0;i<this.size;i++){
                //遍历数组 使原先父节点为aFather的都改为 bFather
                if (id[i]==aFather)
                    id[i]=bFather;
            }
        }

    }

}
