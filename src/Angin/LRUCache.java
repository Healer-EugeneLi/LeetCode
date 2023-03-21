package Angin;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @ClassName: LRUCache
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/12
 * @Time: 21:23
 */



//定义双向链表里面的结点
class Node{

    int key,val;//key和对应的值
    Node next,prev;//指向前后的指针

    public Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}

//定义双向链表
class DoubleList{

    Node head,tail;//头部 尾部结点
    int size=0;//总容量

    public DoubleList(){
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        this.size=0;
    }

    /**
     * 在双向链表中删除x
     * @param x
     */
    public void remove(Node x) {
        //删除哪个结点 进来就先处理哪个结点的两边连接的信息
        x.prev.next=x.next;
        x.next.prev=x.prev;
        size--;
    }

    /**
     * 添加x到链表的尾部
     * @param x
     */
    public void addLast(Node x) {

        //添加哪个结点 进来就先操作它的两边的连接  所以先处理x的加入
        x.prev=tail.prev;
        x.next=tail;

        //再处理x的两边的结点的具体 连接 让它们都指向x
        tail.prev.next=x;
        tail.prev=x;

        size++;
    }


    /**
     * 移除链表的头部 因为后面要用到结点的信息 所以需要返回该节点
     * @return
     */
    public Node removeFirst() {

        //其实此时链表已经为空
        if (head.next==tail)
            return null;

        //获取真正的头结点 head的下一个
        Node needDelete=head.next;
        //删除该节点
        remove(needDelete);
        //返回
        return needDelete;
    }
    /**
     * 获取链表长度
     * @return
     */
    public int getSize(){
        return this.size;
    }


}

public class LRUCache {

    public Map<Integer,Node> map;//key值对应其在双向链表中的结点Node

    public DoubleList doubleList;//存放结点

    public int capacity;//容量

    //构造函数
    public LRUCache(int capacity){
        map=new HashMap<>();
        doubleList=new DoubleList();
        this.capacity=capacity;
    }




    /**
     * 将key对应的结点设置为最近使用
     * 注意这个key肯定是存在的
     * @param key
     * @return
     */
    private void makeRecently(int key) {

        //1.先删除key在双向链表中对应的node
        Node x = map.get(key);
        doubleList.remove(x);

        //2.添加node到链表尾部
        doubleList.addLast(x);
    }


    /**
     * 在双向链表中删除key对应的结点
     * 在map中删除key对应的键值对
     * @param key
     */
    private void deleteKey(int key) {

        Node node = map.get(key);
        //1.在双向链表中删除
        doubleList.remove(node);

        //2.在map中删除
        map.remove(key);
    }


    /**
     * 添加key value所构成的结点在链表的尾部
     * 同时也要加在map中
     * @param key
     * @param value
     */
    private void addRecently(int key, int value) {

        Node node=new Node(key,value);
        //1.在map中加入
        map.put(key,node);
        //2.在链表中插入 插入到尾部
        doubleList.addLast(node);
    }


    /**
     * 移除最近最久未使用
     */
    private void removeLastRecently() {

        //1.移除链表的头部结点 同时返回该节点
        Node node=doubleList.removeFirst();

        //2.返回该节点是为了在map中删除对应的key构成的键值对
        map.remove(node.key);
    }


    /**
     * 获取key对应的值
     * @param key
     * @return
     */
    public int get(int key) {

        //1.如果key不存在 返回-1
        if (!map.containsKey(key)){
            return -1;
        }

        //2.如果key存在 将其在双向链表中对应的结点 设置成最近使用
       makeRecently(key);


        //3.返回key对应的值
        return map.get(key).val;

    }

    /**
     * 插入key 和value
     * @param key
     * @param value
     */
    public void put(int key, int value) {

        //1.如果key存在
        if (map.containsKey(key)){

            //1.1删掉旧数据
            deleteKey(key);

            //1.2添加新节点到尾部
            addRecently(key,value);

            return;
        }

        //2.key不存在 判断容量是否满了
        if (doubleList.getSize()==this.capacity){
            removeLastRecently();
        }

        //3.不存在 且现在有空间了
        addRecently(key,value);
    }



}
