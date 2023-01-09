# [528. Random Pick with Weight](https://leetcode.com/problems/random-pick-with-weight/)


## 题目

Given an array `w` of positive integers, where `w[i]` describes the weight of index `i`, write a function `pickIndex` which randomly picks an index in proportion to its weight.

You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.

You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).

For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
Example 1:

Input
["Solution","pickIndex"]
[[[1]],[]]
Output
[null,0]

Explanation
Solution solution = new Solution([1]);
solution.pickIndex(); // return 0. The only option is to return 0 since there is only one element in w.
Example 2:

Input
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output
[null,1,1,1,1,0]

Explanation
Solution solution = new Solution([1, 3]);
solution.pickIndex(); // return 1. It is returning the second element (index = 1) that has a probability of 3/4.
solution.pickIndex(); // return 1
solution.pickIndex(); // return 1
solution.pickIndex(); // return 1
solution.pickIndex(); // return 0. It is returning the first element (index = 0) that has a probability of 1/4.

Since this is a randomization problem, multiple answers are allowed.
All of the following outputs can be considered correct:
[null,1,1,1,1,0]
[null,1,1,1,1,1]
[null,1,1,1,0,0]
[null,1,1,1,0,1]
[null,1,0,1,0,0]
......
and so on.


Constraints:

1 <= w.length <= 104
1 <= w[i] <= 105
pickIndex will be called at most 104 times.

## 题目大意

给定一个正整数数组 w ，其中 w[i] 代表位置 i 的权重，请写一个函数 pickIndex ，它可以随机地获取位置 i，选取位置 i 的概率与 w[i] 成正比。

说明:

1. 1 <= w.length <= 10000
2. 1 <= w[i] <= 10^5
3. pickIndex 将被调用不超过 10000 次


输入语法说明：

输入是两个列表：调用成员函数名和调用的参数。Solution 的构造函数有一个参数，即数组 w。pickIndex 没有参数。输入参数是一个列表，即使参数为空，也会输入一个 [] 空列表。



## 解题思路

- 给出一个数组，每个元素值代表该下标的权重值，`pickIndex()` 随机取一个位置 i，这个位置出现的概率和该元素值成正比。
- 由于涉及到了权重的问题，这一题可以先考虑用前缀和处理权重。在 `[0,prefixSum)` 区间内随机选一个整数 `x`，下标 `i` 是满足 `x< prefixSum[i]` 条件的最小下标，求这个下标 `i` 即是最终解。二分搜索查找下标 `i` 。对于某些下标 `i`，所有满足 `prefixSum[i] - w[i] ≤ v < prefixSum[i]` 的整数 `v` 都映射到这个下标。因此，所有的下标都与下标权重成比例。
- 时间复杂度：预处理的时间复杂度是 O(n)，`pickIndex()` 的时间复杂度是 O(log n)。空间复杂度 O(n)。

##### 我们就可以建立权重数组的累加和数组，比如若权重数组为 [1, 3, 2] 的话，那么累加和数组为 [1, 4, 6]，整个的权重和为6，我们 rand() % 6，可以随机出范围 [0, 5] 内的数，随机到 0 则为第一个点，随机到 1，2，3 则为第二个点，随机到 4，5 则为第三个点，所以我们随机出一个数字x后，然后再累加和数组中查找第一个大于随机数x的数字，使用二分查找法可以找到第一个大于随机数x的数字的坐标，
https://www.cnblogs.com/grandyang/p/9784690.html