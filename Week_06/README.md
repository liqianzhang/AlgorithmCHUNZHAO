--数组的相对排序,刚开始看题的时候理解起来比较难
彻底掌握
public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int [] ret = new int[arr1.length];
        int[] arr = new int[1001];
        int num = 0;

        for (int i = 0; i < arr1.length; i++) {
            arr[arr1[i]] += 1;
        }
        for (int j = 0; j < arr2.length; j++) {
            while (arr[arr2[j]] > 0) {
                ret[num ++] = arr2[j];
                arr[arr2[j]]--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                ret[num ++ ] = i;
                arr[i]--;
            }
        }
        return ret;
    }

--有效的字母异位词
t 是 s的异位词等价于「两个字符串中字符出现的种类和次数均相等


--字符串中的第一个唯一字符
--这个方法思路很独特，但是速度很慢
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }

--反转字符串 II
这个用的好，之前没用过，类似的引入第三方变量用过，但是这个真是
想不到怎么办，只是比冒泡排序的替换方式多了几个字符
       char tmp = a[i];
        a[i++] = a[j];
        a[j--] = tmp;

 --这个循环递增的方式与往常也是不同的,这个题做起来并不简单
       for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);


--同构字符串 一直想不到解法，看一看题解，真是简单
class Solution {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHeper(s, t) && isIsomorphicHeper(t, s);

    }
    public boolean isIsomorphicHeper(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2){
                    return false;
                }
            }else {
                map.put(c1 ,c2);
            }
        }
        return true;
    }
}

-- LRU 缓存机制
要让 put 和 get 方法的时间复杂度为 O(1)，我们可以总结出 cache
这个数据结构必要的条件：查找快，插入快，删除快，有顺序之分。
因为显然 cache 必须有顺序之分，以区分最近使用的和久未使用的数据；
而且我们要在 cache 中查找键是否已存在；如果容量满了要删除最后一个数据；
每次访问还要把数据插入到队头。
那么，什么数据结构同时符合上述条件呢？哈希表查找快，但是数据无固定顺序；
链表有顺序之分，插入删除快，但是查找慢。所以结合一下，形成一种新的数据结构：哈希链表
LRU 缓存算法的核心数据结构就是哈希链表，双向链表和哈希表的结合体
思想很简单，就是借助哈希表赋予了链表快速查找的特性：可以快速查找某个 key
是否存在缓存（链表）中，同时可以快速删除、添加节点。

必须画图才能弄明白，这个训练营重要的就是养成好的习惯，亲自动手去做
就能发现很多以为简单的东西并没有想的那么简单，只有亲自动手去实践了
才能对知识有更深刻的理解，以前只是为了面试把LRUCache的概念背下来了
通过这次做题，是真正的掌握了，现在想如果早点加入算法训练营就好了
之前认为已经报了两个算法相关的专栏，殊不知，浅尝辄止用处并不大，重要
的还是能动起手了，在高手的帮助下得到正确的指导，这个训练营真是受益了
虽然做的还远远不够

--这个顺序是不能颠倒的，否则会覆盖指针
        public void addToHead(DLinkedNode node){
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

错误示例：

            node.prev = head;
            node.next = head.next;
            head.next = node;
            head.next.prev = node;

--要先删除，在移到头部，这个写反了也不行
public void moveToHead(DLinkedNode node) {
    removeNode(node);
    addToHead(node);
}

这个题问题还挺大的，还是思考的不够多