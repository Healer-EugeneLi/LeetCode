package TireTree;


import java.util.HashMap;

/**
 * @ClassName: TireTree
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/2
 * @Time: 17:27
 * 前缀树
 */
public class TireTree {

    //前缀树节点类型
    public static class TrieNode {

        public int pass;//表示经过当前节点的字符串的个数
        public int end;//记录以当前节点为终止字符串的数量
        public HashMap<Character, TrieNode> nexts;//记录当前节点的后续字符节点

        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }

    public static class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * 前缀树保存了多少个字符串
         *
         * @return
         */
        public int size() {
            return this.root.pass;
        }

        /**
         * 插入字符串
         *
         * @param word
         */
        public void insert(String word) {

            if (word == null) return;

            char[] chars = word.toCharArray();
            TrieNode node = root;
            node.pass++;//表明又要新增一个字符串了

            for (int i = 0; i < chars.length; i++) {
                if (!node.nexts.containsKey(chars[i])) {
                    //还没有该节点的创建
                    node.nexts.put(chars[i], new TrieNode());
                }
                node = node.nexts.get(chars[i]);//找到了该字符
                node.pass++;//该字符出现的次数+1
            }

            node.end++;//node不断下移 一直指向当前字符所代表的节点 表示以改字符结尾的字符串个数+1
        }

        /**
         * 查询字符串是否在前缀树中
         *
         * @param word
         * @return
         */
        public int search(String word) {

            if (word == null) return 0;
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < chars.length; i++) {

                if (!node.nexts.containsKey(chars[i])) return 0;//查询的过程中断开了
                node = node.nexts.get(chars[i]);
            }
            return node.end;

        }

        /**
         * 删除字符串
         *
         * @param word
         */
        public void delete(String word) {

            if (this.search(word) != 0) {
                //确保字符串在树里

                char[] chars = word.toCharArray();
                TrieNode node = root;
                node.pass--;//减去一条路径
                for (int i = 0; i < chars.length; i++) {

                    if (--node.nexts.get(chars[i]).pass == 0) {
                        //当前节点的下层节点减完之后==0 说明再没有其他经过此字符的字符串了 直接设置为空
                        return;
                    }
                    node = node.nexts.get(chars[i]);
                }
                node.end--;//表示以次字符结束的字符串个数--
            }
        }

        /**
         * 查询以pre为前缀的字符串个数
         *
         * @param pre
         * @return
         */
        public int prefixNumber(String pre) {

            if (pre == null) return 0;
            char[] chars = pre.toCharArray();

            TrieNode node = root;

            for (int i = 0; i < chars.length; i++) {
                if (!node.nexts.containsKey(chars[i])) return 0;
                node = node.nexts.get(chars[i]);
            }
            return node.pass;
        }


    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] strs = new String[]{"ab", "abc", "abd", "abe", "abe"};
        for (String str : strs) {
            trie.insert(str);
        }

        System.out.println("前缀树中有多少个字符串:" + trie.size());
        trie.delete("ab");
        System.out.println("删除掉ab之后前缀树中有多少个字符串:" + trie.size());
        System.out.println("以ab为前缀的字符串个数:" + trie.prefixNumber("ab"));
        trie.delete("abe");
        System.out.println("以ab为前缀的字符串个数:" + trie.prefixNumber("ab"));
        trie.delete("abc");
        System.out.println("以ab为前缀的字符串个数:" + trie.prefixNumber("ab"));

    }


}
