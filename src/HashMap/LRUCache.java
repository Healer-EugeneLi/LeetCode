package HashMap;

import java.util.HashMap;

/**
 * @ClassName: LRUCache
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/1
 * @Time: 10:39
 *
 * 实现LRUCache
 */
//双向链表里的结点
class Node{

    public int key,val;
    public Node next,prev;//作为双向链表 指向前后的指针
    public Node(int k,int v){
        this.key=k;
        this.val=v;
    }
}

//双向链表 存放结点
class DoubleList{

    //头尾虚节点
    public Node head,tail;
    //链表元素数
    public int size;

    public DoubleList(){
        //初始化双向链表数据 建立头部与尾部 并且进行连接
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;//头结点后继指向尾部
        tail.prev=head;//尾部指向头结点
        size=0;
    }

    /**
     * 在链表尾部添加节点x 时间O(1)
     * @param x
     */
    public void addLast(Node x){
        //加入新节点x  设置x节点的前驱 后继 主要x是要放在tail的前一个位置
        x.prev=tail.prev;
        x.next=tail;

        //设置tail的前驱节点的后继为x
        tail.prev.next=x;
        //尾部节点的pre为x
        tail.prev=x;

        size++;
    }

    /**
     * 删除链表中的x节点
     * 注意调用此方法的时候 已经知道x一定是存在的 才来进行删除
     * @param x
     */
    public void remove(Node x){
        //x的前驱的后继 此时修改为指向x的后继
        x.prev.next=x.next;
        //x的后继的前驱指向x的前驱
        x.next.prev=x.prev;
        size--;
    }

    /**
     * 删除链表中的第一个结点 并返回该节点
     * @return
     */
    public Node removeFirst(){

        //此时已经剩下head和tail说明已经没有结点了
        if (head.next==tail)
            return null;
        Node first=head.next;//head的下一个是真正的头结点

        //删掉头结点
        remove(first);
        return first;//返回删除的结点
    }

    /**
     * 返回链表长度
     * @return
     */
    public int size(){
        return size;
    }
}

public class LRUCache {
    //key-->Node(key,val)
    private HashMap<Integer,Node> map;//存放key值 与其存在双向链表的结点的对应关系
    //Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;//存放节点 此结点包含数据
    //最大容量
    private int cap;

    public LRUCache(int capacity){

        this.cap=capacity;
        map=new HashMap<>();
        cache=new DoubleList();
    }
    /**
     * 由于我们要同时维护一个双链表 cache 和一个哈希表 map，很容易漏掉一些操作，比
     * 如说删除某个 key 时，在 cache 中删除了对应的 Node，但是却忘记在 map 中删除 key。
     */

    /**
     * 将某个key提升为最近使用 实际做法就是在原双向链表中的删除该节点
     * 然后重新插入到队尾 表示是最新访问的 所以也就是头部节点 就是最久未使用的
     * @param key
     */
    private void makeRecently(int key){
        Node x=map.get(key);//找到key对应的Node节点

        //先从链表中删除这个节点
        cache.remove(x);
        //重新插入到队尾
        cache.addLast(x);
    }

    /**
     * 添加为最近使用的元素
     * @param key
     * @param val
     */
    public void addRecently(int key,int val){
        //
        Node node=new Node(key,val);

        //加入到链表尾部
        cache.addLast(node);
        //同时还得在map中添加映射
        map.put(key,node);
    }

    /**
     * 删除某一个key 在map中删除 在链表中也删除
     * @param key
     */
    public void deleteKey(int key){

        //获取key对应的结点
       Node node=map.get(key);
       //在链表中删除
       cache.remove(node);
       //map中删除
        map.remove(key);
    }

    /**
     * 删除最近最久未使用
     * 删除链表头部结点
     * 同时删除map中的映射
     */
    public void removeLastRecently(){

        //删除链表头部的第一个元素就是最久未使用的
        Node node = cache.removeFirst();
        //在map中删除它的key
        int deleteKey = node.key;
        map.remove(deleteKey);
    }

    /**
     * 获取某个结点的值
     * @param key
     * @return
     */
    public int get(int key){

        if (!map.containsKey(key))
            return -1;//不存在就返回-1

        //存在就将该数据提升为最近使用的
        makeRecently(key);
        return map.get(key).val;
    }

    /**
     * 添加结点
     * 若key存在 修改key对应的val 将key提升为最近使用
     * 若key不存在 需要新插入key
     *          若容量已满 淘汰最久未使用key 插入key和val为最近使用的数据
     *          若未满 插入key和val为最近使用的数据
     * @param key
     * @param val
     */
    public void put(int key,int val){
        //如果原先中存在key 先删除
        if (map.containsKey(key)){
            //删除旧的数据
            deleteKey(key);
            //新插入的数据为最近最久未使用
            addRecently(key,val);
            return;
        }
        // 如果容量满了 删除最近未使用元素
        if (cap== cache.size()){
            removeLastRecently();
        }

        //添加为最近使用的元素
        addRecently(key,val);
    }
}
