//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针


package leetcode.editor.cn;

/**
 * Java：盛最多水的容器
 */
public class P11ContainerWithMostWater {

  public static void main(String[] args) {

    //leetcode submit region begin(Prohibit modification and deletion)
    @SuppressWarnings("Duplicates")
    class Solution {

      public int maxArea(int[] height) {
        return leftRightIndex2ndTime(height);
      }

      /******************第2遍20200522************************/
      /**
       * 第二种解法：使用左右指针逐渐缩减搜索空间，最后找到最值。
       *
       * <p>时间复杂度：O(N)
       * <p>空间复杂度：O(1)
       *
       */
      private int leftRightIndex2ndTime(int[] height) {
        int max = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while (leftIndex != rightIndex) {
          max = Math.max(max, (rightIndex - leftIndex) *
              Math.min(height[leftIndex], height[rightIndex]));
          if (height[leftIndex] < height[rightIndex]) {
            leftIndex++;
          } else {
            rightIndex--;
          }
        }
        return max;
      }

      /**
       *
       * <p>时间复杂度：O(N^2)
       * <p>空间复杂度：O(1)</p>
       *
       * @param height
       * @return
       */
      private int nestLoop2ndTime(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
          for (int j = i + 1; j < height.length; j++) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
          }
        }
        return max;
      }

      /******************第1遍20200521************************/

      /**
       * 第二种方法：使用左右指针法。
       *
       * 注意：
       * <p>题目明确声明 {@code height.length >= 2}，因此不考虑 {@code height.length < 2} 的情况。
       *
       *
       * 关键词：
       * <p>搜索空间具象化、缩减搜索空间、求搜索空间中的最值
       */
      private int leftRightIndex(int[] height) {
        int max = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while (leftIndex != rightIndex) {
          if (height[leftIndex] < height[rightIndex]) {
            max = Math.max(max, (rightIndex - leftIndex) * height[leftIndex]);
            leftIndex++;
          } else {
            max = Math.max(max, (rightIndex - leftIndex) * height[rightIndex]);
            rightIndex--;
          }
        }
        return max;
      }

      /**
       * 使用两层嵌套循环。其实本题就是求出最大面积。
       *
       * <p>时间复杂度：O(n^2)
       * <p>空间复杂度：O(1)
       */
      private int nestLoop(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
          for (int j = i + 1; j < height.length; j++) {
            // 善用 JDK 提供的 API
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
          }
        }
        return max;
      }

    }
    //leetcode submit region end(Prohibit modification and deletion)

  }
}