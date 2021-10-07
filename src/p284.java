import java.util.Iterator;

/**
 * @ClassName: p284
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/6
 * @Time: 20:31
 */
public class p284 {

    class PeekingIterator implements Iterator<Integer> {

        Iterator<Integer> iter;
        Integer next;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            iter=iterator;
            if (iter.hasNext()) next=iter.next();//事先调用一次 next() 并使用该变量 next
            // next保留下一个元素

        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {

            Integer ans=next;
            next=iter.hasNext()?iter.next():null;
            return ans;
        }

        @Override
        public boolean hasNext() {
            return next!=null;
        }
    }
}
