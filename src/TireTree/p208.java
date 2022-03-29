package TireTree;

import java.util.HashMap;

/**
 * @ClassName: p208
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/22
 * @Time: 22:17
 */
public class p208 {

    class TrieNode{
        public int pass;//经过此字符的字符串数目
        public int end;//以此字符结尾的字符串个数
        public HashMap<Character,TrieNode> nexts;//存放当前字符节点的下一个节点的信息

        public TrieNode() {
            pass=0;
            end=0;
            nexts=new HashMap<>();
        }
    }

    class  Trie{

        public TrieNode root=new TrieNode();//创建一个根节点

        public void insert(String word) {
            if (word=="") return;

            char[] chars = word.toCharArray();

            TrieNode node=root;

            for (int i=0;i<chars.length;i++){

                if (!node.nexts.containsKey(chars[i])){
                    node.nexts.put(chars[i],new TrieNode());
                }
                node=node.nexts.get(chars[i]);
                node.pass++;
            }
            node.end++;

        }

        public boolean search(String word) {

            if (word=="") return false;

            TrieNode node=root;
            char[] chars = word.toCharArray();

            for (int i=0;i<chars.length;i++){

                if (!node.nexts.containsKey(chars[i])) return false;
                node=node.nexts.get(chars[i]);
            }
            if (node.end==0) return false;
            return true;
        }

        public boolean startsWith(String prefix) {

            if (prefix=="") return false;
            TrieNode node=root;
            char[] chars = prefix.toCharArray();
            for (int i=0;i<chars.length;i++){
                if (!node.nexts.containsKey(chars[i]))
                    return false;
                node=node.nexts.get(chars[i]);

            }
            return true;

        }
    }


}
