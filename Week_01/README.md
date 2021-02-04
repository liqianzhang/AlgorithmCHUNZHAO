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


