import com.sun.crypto.provider.PBEWithMD5AndTripleDESCipher;

import java.util.HashMap;

/**
 * @ClassName: MB
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/6
 * @Time: 10:27
 */
public class MB {


    public static class TrieNode{

        public int pass;//表示经过当前节点的字符串的个数
        public int end;//记录当前节点为终止字符串的数量
        public HashMap<Character,TrieNode> nexts;//

        public TrieNode(){

            pass=0;
            end=0;
            nexts=new HashMap<>();
        }

    }

    public static class Trie{

        private TrieNode root;//根节点是没有存放字符的
        public Trie(){
            root= new TrieNode();
        }


        /**
         * 保存了多少个字符串
         * @return
         */
        public int size(){
            return this.root.pass;
        }


        /**
         * 插入字符串
         * @param word
         */
        public void insert(String word){

            if (word==null) return;

            char[] chars = word.toCharArray();
            TrieNode node=root;
            node.pass++;//表明又要新增一个字符串了

            for (int i=0;i<chars.length;i++){

                if(!node.nexts.containsKey(chars[i])){
                    //表明还没有该字符
                    node.nexts.put(chars[i],new TrieNode());
                }
                node=node.nexts.get(chars[i]);
                node.pass++;
            }
            node.end++;//最后这个node来到结尾了

        }


        /**
         * 查询字符串是否在前缀树中
         * @param word
         * @return
         */
        public int search(String word){

            if (word==null) return 0;
            char[] chars = word.toCharArray();
            TrieNode node=root;

            for (int i=0;i<chars.length;i++){
                if (!node.nexts.containsKey(chars[i])) return 0;//查询的过程中断开了
                node=node.nexts.get(chars[i]);
            }
            return node.end;
        }


        /**
         * 删除字符串
         * @param word
         */
        public void delete(String word){

            if (this.search(word)!=0){
                //确保在字符串里面

                char[] chars = word.toCharArray();
                TrieNode node=root;
                node.pass--;//减去一条路径

                for (int i=0;i<chars.length;i++){

                    if (--node.nexts.get(chars[i]).pass==0){
                        //当前节点剪完就没有了 说明只有这一个字符串
                        return;
                    }
                    node=node.nexts.get(chars[i]);//不断下移
                }
                node.end--;
            }
        }

        /**
         * 查询以pre为前缀的字符串个数
         * @param pre
         * @return
         */
        public int preFixNumber(String pre){

            if (pre==null) return 0;

            char[] chars = pre.toCharArray();

            TrieNode node=root;

            for (int i=0;i<chars.length;i++){

                if (!node.nexts.containsKey(chars[i])) return 0;
                node=node.nexts.get(chars[i]);
            }
            return node.pass;
        }



    }


}
