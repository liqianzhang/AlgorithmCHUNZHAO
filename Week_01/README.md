学习笔记
掌握正确的学习方法

掌握五毒神掌

培养刻意练习的习惯



1.移动零

0 1 0 3 12

1 0 0 3 12

1 3 0 0 12

1 3 12 0 0

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0;i < nums.length; i++) {
            if (nums[i]!=0) {
                nums[j] = nums[i];
                if (j<i) {
                    nums[i]=0;
                }
                j++;
            }
        }
    }
}
这个思路非常好，自己是无论如何也不会想到的

站在巨人肩膀上是最好的选择，虽然写出来了，但是

并没有彻底掌握，还需要多联系



2.盛最多的水

先知道夹逼法的原理很重要

class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0,j = height.length-1;i<j;) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = minHeight * (j-i+1);
            if (area > max){
                max = area;
            }
        }
        return max;
    }
}
这个题做的时候还是存在不少问题

1.在力扣平台写代码不习惯

2.思考不到位



3.爬楼梯

1.最大的误区：做题只做一遍

2.优化的思想：空间换时间，升维，一维升到二维

懵逼的时候：暴力？基本情况？

找最近重复的子问题,重要的是找到递推公式



本来想用递归，但是超时了，只能用滚动数组思想



class Solution {
    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
代码是简单的，但是真不容易理解

从0级爬到0级有一种方案



p q r

0 0 1  0个台阶有1种方法 ※

0 1 1  1个台阶有1种方法

1 1 2  2个台阶有2种方法

1 2 3  3个台阶有3种方法

2 3 5  4个台阶有5种方法

3 5 8  5个台阶有8种方法



    class Solution {
        public int climbStairs(int n) {
            int p = 0, j = 0, r = 1;
            for (int i = 0; i < n; i++) {
                p = j;
                j = r;
                r = p + j;
            }
            return r;
    }
    }


这个数组滚动的方法果然是快。



4.三数之和

题目转化 a+b=-c

sort 的时间复杂度 nlogn

hashset判重

实现循环双端链表：
在头部插入节点，这个判断方法是之前想不到的  
这边括号中加了个 capacity 是为了防止数组越界,
如果front是0，再减1，就越界了

front = (front - 1 + capacity) % capacity;
而往尾部插入的时候是这样判断的，有什么区别呢
rear = (rear + 1) % capacity;

并且要注意处理的顺序是不都一样的一个先移动指针
另一个后移动指针

        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        
        arr[rear] = value;
        rear = (rear + 1) % capacity;

为什么获取头结点和尾结点的方法不一样呢，或许是front指向
第一个节点，而rear是指向最后一个节点的下一个节点吧

return arr[front];       
return arr[(rear - 1 + capacity) % capacity];

在进行队首队尾判断的时候要注意不要把变量写错了
要理解的基础上分析，这个并没有彻底掌握，通过
五毒神掌进行巩固吧

模式识别：一旦需要根据特征进行归类，就应该利用散列表
起初是不知道map.getOrDefaul 的用法。
List<String> list = map.getOrDefault(key, new ArrayList<String>());

--这么写是不正确的
HashMap map = new HashMap<String,new ArrayList()>();

String key = new String(chars);
和
String key = chars.toString();
完全不一样，基础实在是太差了

在字母异位词分组这个题上，还有很多细节性的问题，
依然要通过五毒神掌来解决，这个问题也确实比前面的
要难一点

/** 这个是自己写的接雨水，很粗糙
    public static int trap(int[] height) {
        int rainNo = 0;
        for (int i = 1; i < height.length-1; i++) {
            for (int j = 0; i - j >=0 && i + j <= height.length-1; j++) {
            if (height[i] < height[i-j] && height[i] < height[i+j]) {
                int high = height[i-j] < height[i+j] ? height[i-j]:height[i+j];
                rainNo += high - height[i];
                }
            }
        }
        return rainNo;
    }
    
    这个方法是存在漏洞的，当数组为int[] rain = new int[]{4,2,0,3,2,5};
    的时候，无法兼顾到最上面一层，这种暴力解法做不到
    从当前元素向左扫描并更新 和从当前元素向右扫描并更新：
    官方题解上给出的方法正是想要达到的目标方法，只是没有想到
    用两个循环，把问题想复杂了，这样的话，这个暴力解法实际上是用到了
    3个循环，如此时间复杂度是很大的
    
    for (int j = i; j >= 0; j--) { 
    for (int j = i; j < size; j++) { 
    这个手法是之前没有用到过的，今天学到了 ,平时是没有这么写过代码
    的，别人的智慧果然是高深，之前的写代码方式简直是太low了，
    通过今天的发现，从这个训练营当中获取更多好的方法，现在只是个
    简单的开始
    
    嵌套循环中，对边界的判断还不尽如人意
    j >= 0  j < size
    
    再一次执行的时候，自己写的那段代码也通过测试了，但是很显然
    是不够健壮的，方法就用错了
*/

