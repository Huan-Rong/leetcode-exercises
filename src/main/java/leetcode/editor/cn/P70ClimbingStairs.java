//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划


package leetcode.editor.cn;

/**
 * Java：爬楼梯
 */
public class P70ClimbingStairs {

  public static void main(String[] args) {
    Solution solution = new P70ClimbingStairs().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  @SuppressWarnings("Duplicates")
  class Solution {

    public int climbStairs(int n) {
      return fibonacci2ndTime(n);
    }


    /******************第2遍20200526************************/
    /**
     * 第四种解法，使用 fibonacci 数列。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1）
     */
    private int fibonacci2ndTime(int n) {
      if (n == 1) {
        return 1;
      }
      if (n == 2) {
        return 2;
      }

      int first = 1;
      int second = 2;
      for (int i = 3; i <= n; i++) {
        int third = first + second;
        first = second;
        second = third;
      }
      return second;
    }
    /**
     * 第三种解法：使用优化的递归。优化后的递归能够减少重复的计算。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private int memoRecursion2ndTime(int n) {
      int[] memo = new int[n + 1];
      return mRecursion2ndTime(n, memo);
    }

    /**
     * 使用优化的递归，每次调用自身时都需要传入缓存对象。
     */
    private int mRecursion2ndTime(int n, int[] memo) {
      if (n == 1) {
        return 1;
      }
      if (n == 2) {
        return 2;
      }
      if (memo[n] > 0) {
        return memo[n];
      }
      memo[n] = mRecursion2ndTime(n - 1, memo) + mRecursion2ndTime(n - 2, memo);
      return memo[n];
    }

    /**
     * 第2种解法：使用未优化的递归。但是与第一种解法的递归方向不同。
     *
     * 从不同的递归方向来体验，递归的本质：将大规模问题拆解为一系列解决思路相同的小规模问题。
     *
     * <p>思路：
     * 这个解法的大规模的思考角度是：[0,n] 拆解为 [1,n] 和[2,n]，进一步地，[1,n] 可以拆解为[2,n]和[3,n]。 也就是说，[i,n] 中的 i 会越来越接近
     * n，也就是规模越来越小了。
     */
    private int recursion2ndTimeDiffDirection(int i, int n) {
      if (i > n) {
        return 0;
      }
      if (i == n) {
        return 1;
      }
      return recursion2ndTimeDiffDirection(i + 1, n) + recursion2ndTimeDiffDirection(i + 2, n);
    }

    /**
     * 第一种解法，使用未优化的递归。
     *
     * 缺点：时间复杂度和空间复杂度都较高，且存在大量重复计算。
     *
     * 时间复杂度：O(2^n) 空间复杂度：O(n)
     */
    private int resursion2ndTime(int n) {
      if (n == 1) {
        return 1;
      }
      if (n == 2) {
        return 2;
      }
      return resursion2ndTime(n - 1) + resursion2ndTime(n - 2);
    }

    /******************第1遍20200525************************/
    /**
     * 第三种方法：使用 fibonacci 数列算法。
     *
     * 思路：第 n 阶的走法为第 n - 1 阶和 第 n - 1 阶的走法之和。
     *
     * 时间复杂度：O(n) 空间复杂度：O(1)
     */
    private int fibonacci1stTime(int n) {
      if (n == 1) {
        return 1;
      }

      if (n == 2) {
        return 2;
      }

      int first = 1;
      int second = 2;
      for (int i = 3; i <= n; i++) {
        int third = first + second;
        first = second;
        second = third;
      }
      return second;
    }

    /**
     * 第二种解法：记忆化递归。
     *
     * 思路：将中间结果缓存起来。通过这种方式来减少递归次数。
     *
     * 时间复杂度：O(n) 空间复杂度：O(1)
     */
    private int memoRecursion1stTime(int n) {
      int[] memo = new int[n + 1];
      return mRecursion(n, memo);
    }

    private int mRecursion(int n, int[] memo) {
      if (n == 1) {
        return 1;
      }
      if (n == 2) {
        return 2;
      }
      // 查询缓存
      if (memo[n] > 0) {
        return memo[n];
      }
      memo[n] = mRecursion(n - 1, memo) + mRecursion(n - 2, memo);
      return memo[n];
    }

    /**
     * 第一种解法：递归。
     *
     * 思想：将大问题拆分为一系列解决思路相同的小问题。
     *
     * 时间复杂度：O(2^n)，指数级时间复杂度 空间复杂度：O(n)
     *
     * 缺点：会存在大量重复计算。
     */
    private int recursion1stTime(int n) {
      if (n == 1) {
        return 1;
      }
      if (n == 2) {
        return 2;
      }
      return recursion1stTime(n - 1) + recursion1stTime(n - 2);
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}