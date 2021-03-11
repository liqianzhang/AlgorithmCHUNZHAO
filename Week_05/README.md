
Trie树的基本性质：
1.节点本身不存完整单词
2.从根节点到某一结点，路径上经过的字符连接起来，为该节点对应的字符串
3.每个节点的所有子节点路径代表的字符都不相同

数独方块索引 = （行/3）* 3 + 列 / 3


--爬楼梯
讨论边界条件。我们是从第 0 级开始爬的，所以从第 0 级爬到第 0 级
我们可以看作只有一种方案，即 f(0) = 1f(0)=1；从第 0 级到第 11 级
也只有一种方案，即爬一级，f(1) = 1f(1)=1。 用「滚动数组思想」
最基本的斐波拉契问题

--位1的个数
任何数字跟掩码 11 进行逻辑与运算，都可以让我们获得这个数字的最低位
 if(n & mask != 0){

--2的幂
该问题将通过位运算在  O(1) 的时间复杂度解决
如何获取二进制中最右边的 1：x & (-x)。
如何将二进制中最右边的 1 设置为 0：x & (x - 1)。

2 的幂在二进制中是有一个 1 后跟一些 0：不是 2 的幂的二进制中有一个以上的 1。
除了 0，我们应该单独处理。
恒有 n & (n - 1) == 0，这是因为：
nn 二进制最高位为 11，其余所有位为 00；
n - 1n−1 二进制最高位为 00，其余所有位为 11；
一定满足 n > 0。
--这段代码真是高
     public boolean isPowerOfTwo(int n) {
         return n > 0 && (n & n -1 ) == 0;
     }
体会到数学分析是程序设计的基础

-- 颠倒二进制位
ret | (((n>>(31-i)) & 1) << i)  取出 n 的从右往左数的第 x 位的数
这一部分的操作，从上面的分析中我们已知 ((n>>(31-i)) & 1)
就是取 n 的第 31 - i 位，即从右往左按顺序取出。
然后再执行 <<i，即表示：将取到的 n 的第 31 - i 位上的数向左
位置 i 位，且 i 是从最高位往下最低位走的。
ret | (((n>>(31-i)) & 1) << i) 中的 ret | 这一部分做的操作，
从上面的分析中可以知道 (((n>>(31-i)) & 1) << i) 的操作就是将
 n 的第 31 - i 位颠倒，然后再 ret |，其实就是设置 ret 的第 n 位二进制数。

--这代码写的太好了，就是位运算理解还很不理解
     public static int reverseBits(int n) {
         int ret = 0;
         for (int i = 31; i >= 0 ; i--) {
             ret = ret | (((n >> (31 - i)) & 1) << i);
         }
         return ret;
     }

--实现 Trie (前缀树)
平衡树和哈希表，使我们能够在字符串数据集中搜索单词。
为什么我们还需要 Trie 树呢？尽管哈希表可以在 O(1)O(1) 时间内寻找键值，
却无法高效的完成以下操作：
找到具有同一前缀的全部键值。
按词典序枚举字符串的数据集。

Trie 树优于哈希表的另一个理由是，随着哈希表大小增加，会出现大量的冲突，
时间复杂度可能增加到 O(n)O(n)，其中 nn 是插入的键的数量。与哈希表相比，
Trie 树在存储多个具有相同前缀的键时可以使用较少的空间。
此时 Trie 树只需要 O(m)O(m) 的时间复杂度，其中 mm 为键长。
而在平衡树中查找键值需要 O(m \log n)O(mlogn) 时间复杂度。

class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)){
                node = node.get(curLetter);
            }else {
                return null;
            }
        }
        return node;
    }
        class TrieNode{
        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode(){
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch){
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node){
            links[ch - 'a'] = node;
        }

        public void setEnd(){
            isEnd = true;
        }

        public boolean isEnd(){
            return isEnd;
        }
    }
}

--很简单，背下来就行了

--省份数量  并查集的典型应用是有关连通分量的问题
并查集解决单个问题（添加，合并，查找）的时间复杂度都是O(1)
并查集跟树有些类似，只不过她跟树是相反的。在树这个数据结构里面，
每个节点会记录它的子节点。在并查集里，每个节点会记录它的父节点。
当把一个新节点添加到并查集中，它的父节点应该为空

这里有一个优化的点：如果我们树很深，比如说退化成链表，那么每次查询的效率都会非常低。所以我们要做一下路径压缩。也就是把树的深度固定为二。

这么做可行的原因是，并查集只是记录了节点之间的连通关系，
而节点相互连通只需要有一个相同的祖先就可以了。

    public int find(int x) {
        int root = x;

        while(father.get(root) != null){
            root = father.get(root);
        }

        while(x != root){
            int original_father = father.get(x);
            father.put(x,root);
            x = original_father;//这是个第三方变量，不断的进行遍历处理x
        }

        return root;
    }







