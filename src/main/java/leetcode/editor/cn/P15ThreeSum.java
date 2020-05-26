//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Java：三数之和
 */
public class P15ThreeSum {

  public static void main(String[] args) {
    Solution solution = new P15ThreeSum().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
      return thSum(nums);
    }

    /**
     * <p>思路：
     *
     *    1.先对数组进行排序，之后使用三个指针分别指向定值、搜索空间的左右边界，然后在搜索空间内搜索结果。
     *    2.对于重复结果的处理，是在搜索过程中就处理掉的，而不是计算出结果最后去重。这一点非常巧妙。
     *    3.排序的目的是减少重复计算，从而去掉重复结果。
     *    4.需要注意的是，内外两层循环都需要做去重的工作。
     */
    private List<List<Integer>> thSum(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      int len = nums.length;
      if (nums == null || len < 3) {
        return ans;
      }
      Arrays.sort(nums);
      for (int i = 0; i < len; i++) {
        if (nums[i] > 0) {
          break;
        }
        /*
         * 如果当前定值与上一个定值相同时，则跳过这一轮外循环。
         * 因为这一轮外循环属于重复计算，并且可能产生重复的三元组。
         */
        if (i > 0 && nums[i] == nums[i - 1]) {
          continue;
        }
        /*
         * 定义左右指针。
         */
        int left = i + 1;
        int right = len - 1;
        /*
         * while 内循环的工作：当定值确定时，找出另外两个数值，使得三数之和为 0 。
         */
        while (left < right) {
          int sum = nums[i] + nums[left] + nums[right];
          if (sum == 0) {
            ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
            /*
             * 跳过重复的计算。
             */
            while (left < right && nums[left] == nums[left + 1]) {
              left++;
            }
            while (left < right && nums[right] == nums[right - 1]) {
              right--;
            }
            left++;
            right--;
          } else if (sum < 0) {
            left++;
          } else if (sum > 0) {
            right--;
          }
        }
      }
      return ans;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}