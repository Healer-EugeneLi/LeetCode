package TireTree;

import java.util.HashMap;

/**
 * @ClassName: p1602
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/6
 * @Time: 10:47
 */
public class p1602 {

//    //前缀树节点类型
//   class TrieNode{
//
//        public int pass;//表示经过当前节点的字符串的个数
//        public int end;//记录以当前节点为终止字符串的数量
//        public HashMap<Character, TrieNode> nexts;//记录当前节点的后续字符节点
//
//        public TrieNode(){
//            pass=0;
//            end=0;
//            nexts=new HashMap<>();
//        }
//    }
//
//    public class Trie{
//
//        private TrieNode root;
//
//        public Trie(){
//            root=new TrieNode();
//        }
//
//        /**
//         * 插入字符串
//         * @param word
//         */
//        public void insert(String word){
//
//            if (word==null) return;
//            char[] chars = word.toCharArray();
//            TrieNode node=root;
//            for (int i=0;i<chars.length;i++){
//
//                if (!node.nexts.containsKey(chars[i]))
//                    node.nexts.put(chars[i],new TrieNode());
//                node=node.nexts.get(chars[i]);
//                node.pass++;
//            }
//            node.end++;
//        }
//
//
//        /**
//         * 查询字符串 返回个数
//         * @param word
//         * @return
//         */
//        public int search(String word){
//
//            if (word==null) return 0;
//            char[] chars = word.toCharArray();
//            TrieNode node=root;
//
//            for (int i=0;i<chars.length;i++){
//                if (!node.nexts.containsKey(chars[i])) return 0;
//                node=node.nexts.get(chars[i]);
//            }
//            return node.end;
//        }
//    }
//
//
//
//
//    class WordsFrequency {
//
//       Trie trie=new Trie();
//        public WordsFrequency(String[] book) {
//
//            for (String b:book){
//                trie.insert(b);
//            }
//        }
//
//        public int get(String word) {
//
//            return trie.search(word);
//        }
//    }

    class WordsFrequency {


        public HashMap<String,Integer> map=new HashMap<>();
        public WordsFrequency(String[] book) {

            for (String b:book){

                Integer orDefault = map.getOrDefault(b, 0);
                map.put(b,orDefault+=1);
            }
        }

        public int get(String word) {

            if (map.containsKey(word))
                return map.get(word);
            return 0;

        }
    }
}
