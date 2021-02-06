第二周总结

对于这个N叉树的前中后序遍历，很不熟悉，容易弄混了
前序遍历和后序遍历的区别在于根据点添加的时机
虽然递归实现的方法很简单，但是不容易想到
第一遍理解起来也并没有那么简单

对二叉树遍历，没有判断root为空的情况，导致执行一直不通过
虽然在IDEA上执行通过了，但是IDEA中的测试用例是单一的，
不足以证明程序是正确的


N叉树层序遍历，用遍历二叉树的方式，写了两个小时没有写出来
放弃，看题解吧 ，这个方法和题解的方法比较起来还是比较
笨重的

输出：[[1],[3,2,4],[5,6],[5,6],[3,2,4],[3,2,4]]
预期结果：[[1],[3,2,4],[5,6]]
 List<List<Integer>> list = null;
    public List<List<Integer>> levelOrder(Node root) {
        list = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        if (root != null) {
          level.add(root.val);
          list.add(level);
        }
        order(root);
        return list;
    }
    public void order(Node root){
        List<Integer> level = new ArrayList<>();
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (Node child : root.children) {
                level.add(child.val);
                list.add(level);
                order(child);
            }
        }
    }
    
    通常我们不能使用递归进行广度优先搜索。
    这是因为广度优先搜索基于队列，而递归运行时使用堆栈，
    适合深度优先搜索
    
    题解的这个方式，看着实现是很简洁的，同样是使用了递归，
    差别在于，往结果集添加的方式：result.get(level).add(root.val);
    因为result是一个嵌套list，所以要用这种方法，之前也是没用过
    今天真是受益匪浅了 
    
        List<List<Integer>> result = null;
        public List<List<Integer>> levelOrder(Node root) {
            result = new ArrayList<>();
            if (root != null) {
                order(root, 0);
            }
            return result;
        }
        public void order(Node root, int level){
            if (result.size() <= level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            if (root.children != null) {
                for (Node child : root.children) {
                    order(child, level + 1);
                }
            }
        }
        --丑数，使用自行暴力解法超出了内存限制
        class Solution {
                public int nthUglyNumber(int n) {
                List list = new ArrayList();
                for (int i = 2; i < Integer.MAX_VALUE; i++) {
                    if (i % 2 ==0 || i % 3 == 0 || i % 5 == 0) {
                        list.add(i);
                        if (list.size() == n - 1) {
                            break;
                        }
                    }
                }
                return (int) list.get(list.size() - 1);
            }
        }
        
 根据题解的思路，最重要的是掌握丑数的递推性质  
 设已知长度为 nn 的丑数序列 x_1, x_2, \cdots , x_nx 
 1
 ​	
  ,x 
 2
 ​	
  ,⋯,x 
 n
 ​	
   ，求第 n+1n+1 个丑数 x_{n+1}x 
 n+1
 ​	
   。根根据递推性质，丑数 x_{n+1}x 
 n+1
 ​	
   只可能是以下三种情况其中之一（索引 a, b, ca,b,c 为未知数）：
 
 x_{n+1} = \begin{cases} x_{a} \times 2 & ,a \in [1, n] \\ x_{b} \times 3 & ,b \in [1, n] \\ x_{c} \times 5 & ,c \in [1, n] \end{cases}
 x 
 n+1
 ​	
  = 
 ⎩
 ⎪
 ⎪
 ⎨
 ⎪
 ⎪
 ⎧
 ​	
   
 x 
 a
 ​	
  ×2
 x 
 b
 ​	
  ×3
 x 
 c
 ​	
  ×5
 ​	
   
 ,a∈[1,n]
 ,b∈[1,n]
 ,c∈[1,n]
 ​	
  
 
 由于 x_{n+1}x 
 n+1
 ​	
   是 最接近 x_nx 
 n
 ​	
   的丑数，因此索引 a, b, ca,b,c 需满足以下条件：
 
 \begin{cases} x_{a} \times 2 > x_n \geq x_{a-1} \times 2 & ，即 x_a 为首个乘以 2 后大于 x_n 的丑数 \\ x_{b} \times 3 > x_n \geq x_{b-1} \times 3 & ，即 x_b 为首个乘以 3 后大于 x_n 的丑数 \\ x_{c} \times 5 > x_n \geq x_{c-1} \times 5 & ，即 x_c 为首个乘以 5 后大于 x_n 的丑数 \\ \end{cases}
 ⎩
 ⎪
 ⎪
 ⎨
 ⎪
 ⎪
 ⎧
 ​	
   
 x 
 a
 ​	
  ×2>x 
 n
 ​	
  ≥x 
 a−1
 ​	
  ×2
 x 
 b
 ​	
  ×3>x 
 n
 ​	
  ≥x 
 b−1
 ​	
  ×3
 x 
 c
 ​	
  ×5>x 
 n
 ​	
  ≥x 
 c−1
 ​	
  ×5
 ​	
   
 ，即x 
 a
 ​	
  为首个乘以2后大于x 
 n
 ​	
  的丑数
 ，即x 
 b
 ​	
  为首个乘以3后大于x 
 n
 ​	
  的丑数
 ，即x 
 c
 ​	
  为首个乘以5后大于x 
 n
 ​	
  的丑数
 ​	
  
 
 若索引 a,b,ca,b,c 满足以上条件，则可使用递推公式计算下个丑数 x_{n+1}x 
 n+1
 ​	
   ，其为三种情况中的最小值，即：
 
 x_{n+1} = \min(x_{a} \times 2, x_{b} \times 3, x_{c} \times 5)
 x 
 n+1
 ​	
  =min(x 
 a
 ​	
  ×2,x 
 b
 ​	
  ×3,x 
 c
 ​	
  ×5)
 
 因此，可设置指针 a,b,ca,b,c 指向首个丑数（即 11 ），循环根据递推公式得到下个丑数，并每轮将对应指针执行 +1+1 即可。
 
  状态定义： 设动态规划列表 dpdp ，dp[i]dp[i] 代表第 i + 1i+1 个丑数。
  转移方程：
  当索引 a, b, ca,b,c 满足以下条件时， dp[i]dp[i] 为三种情况的最小值；
  每轮计算 dp[i]dp[i] 后，需要更新索引 a, b, ca,b,c 的值，使其始终满足方程条件。实现方法：分别独立判断 dp[i]dp[i] 和 dp[a] \times 2dp[a]×2 , dp[b] \times 3dp[b]×3 , dp[c] \times 5dp[c]×5 的大小关系，若相等则将对应索引 aa , bb , cc 加 11 。
  \begin{cases} dp[a] \times 2 > dp[i-1] \geq dp[a-1] \times 2 \\ dp[b] \times 3 > dp[i-1] \geq dp[b-1] \times 3 \\ dp[c] \times 5 > dp[i-1] \geq dp[c-1] \times 5 \\ \end{cases}
    
  dp[a]×2>dp[i−1]≥dp[a−1]×2
  dp[b]×3>dp[i−1]≥dp[b−1]×3
  dp[c]×5>dp[i−1]≥dp[c−1]×5
  ​	
   
  
  dp[i] = \min(dp[a] \times 2, dp[b] \times 3, dp[c] \times 5)
  dp[i]=min(dp[a]×2,dp[b]×3,dp[c]×5)
  
  初始状态： dp[0] = 1dp[0]=1 ，即第一个丑数为 1 ；
  返回值： dp[n-1]dp[n−1] ，即返回第 n 个丑数。
  
  代码看似简单，但是在写的过程中出现了几个问题
              int n2 = dp[0] * 2;
              int n3 = dp[0] * 3;
              int n5 = dp[0] * 5;
  未写变量，而且写到循环外了  
              int n2 = dp[a] * 2;
              int n3 = dp[b] * 3;
              int n5 = dp[c] * 5;  
不能把变量忽略，以现阶段的基础看，这个方法的水准真是太高了

--前K个高频元素（这个实现有点复杂）   
模式识别：通常关于树的问题可以用递归来解决
              
        
    