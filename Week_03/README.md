--多数元素 很多种方法，其中去排序后的数组中间值很简便
--柠檬水找零  分组讨论是关键
--买卖股票的最佳时机   这道题普通解法是很复杂的，也想不到解决方案
个人感觉遇到爬坡的区间才可以买入卖出，这个区间的大小由头尾的高度差决定

    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(0, prices[i] - prices[i-1]);
        }
        return ans;
    }
这个方法倒是很简单，但是使用的方法是比较巧妙的。在不看题解提前
想不到一个这么简便的方法

--分发饼干，感觉这个有点难
又是一个代码简单，实现起来并不容易的题
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0; count < g.length && i< s.length; i++) {
            if (g[count] <= s[i]) { //"<=" 这个判断是没有想到的
                count++;   //自己写的时候居然s[i]居然写成了j[i]
            }
        }
        return count;
    }
    
--模拟行走机器人，想用暴力法做，但是感觉太复杂，放弃，看题解    
        public int robotSim(int[] commands, int[][] obstacles) {
            int[] location = new int[]{0,0};
            for (int i = 0; i < commands.length; i+=2) {
                
            }
            return 1;
        }
--对题解的这段代码看不懂，    Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据。    
Set<String> obs = Arrays.stream(obstacles).map(a -> a[0] + " " + a[1]).collect(Collectors.toSet());
Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象。
Stream API可以极大提高Java程序员的生产力，让程序员写出高效率、干净、简洁的代码。

这种风格将要处理的元素集合看作一种流， 流在管道中传输， 并且可以在管道的
节点上进行处理， 比如筛选， 排序，聚合等。
元素流在管道中经过中间操作（intermediate operation）的处理，
最后由最终操作(terminal operation)得到前面处理的结果。
+--------------------+       +------+   +------+   +---+   +-------+
| stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
+--------------------+       +------+   +------+   +---+   +-------+
Stream（流）是一个来自数据源的元素队列并支持聚合操作
元素是特定类型的对象，形成一个队列。 Java中的Stream并不会存储元素，而是按需计算。
数据源 流的来源。 可以是集合，数组，I/O channel， 产生器generator 等。
聚合操作 类似SQL语句一样的操作， 比如filter, map, reduce, find, match, sorted等。
和以前的Collection操作不同， Stream操作还有两个基础的特征：

Pipelining: 中间操作都会返回流对象本身。 这样多个操作可以串联成一个管道， 如同流式风格（fluent style）。 这样做可以对操作进行优化， 比如延迟执行(laziness)和短路( short-circuiting)。
内部迭代： 以前对集合遍历都是通过Iterator或者For-Each的方式, 显式的在集合外部进行迭代， 这叫做外部迭代。 Stream提供了内部迭代的方式， 通过访问者模式(Visitor)实现。

这个题解为什么这么难懂，
定义方向和方向的判断是很关键的，看了半天才理解了
int[][] ds = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//1.定义4个方向
if (c == -1) d = (d + 1) % 4;
else if (c == -2) d = (d + 3) % 4;
--这个不理解为什么要这么写
res = Math.max(res, x * x + y * y);
步骤：
1.定义4个方向
2.把障碍物存入set
3.初始化坐标值
4.遍历命令
  4.1判断右向
  4.2判断左向
  4.3计算坐标和结果
  这句代码也写的很巧妙
  else while (c-- > 0 && !obs.contains((x + ds[d][0]) + " " + (y + ds[d][1]))) {
  
  public int robotSim(int[] commands, int[][] obstacles) {
          int[][] directs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
          Set<String> collect = Arrays.stream(obstacles).map(a -> a[0] + " " + a[1]).collect(Collectors.toSet());
          int x = 0, y = 0, d = 0, res = 0;
          for (int cmd : commands) {
              if (cmd == -1) {
                  d = (d + 1) % 4;
              }else if (cmd == -2){
                  d = (d + 3) % 4;
              }else{
                  while (cmd --> 0 && !collect.contains((x + directs[d][0]) + " " + (y + directs[d][1]))) {
                      x += directs[d][0];
                      y += directs[d][1];
                      res = Math.max(res ,x * x + y * y);
                  }
              }
  
          }
           return res;
      }
   这个实现真实不简单，基本是看着写完的，感觉还有一半不懂
   
   
   Pow(x,n)代码依然比较简单的，但是理解起来有点绕，
   这说明还未完全掌握递归，如果从开始做新题，会有无所适从的感觉
       public double myPow(double x, int n) {
           return n >= 0 ? quickCal(x, n) : 1.0 / quickCal(x, -n);
       }
   
       private double quickCal(double x, int n) {
           if (n ==0 ) {
               return 1.0;
           }
           double y = quickCal(x, n /2);
           return n % 2 == 0? y * y : y * y * x;
       }   
  
