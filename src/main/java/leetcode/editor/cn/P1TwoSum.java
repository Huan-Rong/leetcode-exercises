//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Java：两数之和
 */
public class P1TwoSum {

  public static void main(String[] args) {
    Solution solution = new P1TwoSum().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int[] twoSum(int[] nums, int target) {
      return useHashMap2(nums, target);
    }

    /**
     * 第一种解法：双层循环暴力破解。
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    private int[] bruteForce(int[] nums, int target) {
      for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
          if (target == nums[i] + nums[j]) {
            return new int[]{i, j};
          }
        }
      }
      return null;
    }

    /**
     * 第二种解法：使用哈希表，以空间换时间。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private int[] useHashMap(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
      for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
      }

      for (int i = 0; i < nums.length; i++) {
        int tmp = target - nums[i];
        Integer tmpIndex = map.get(tmp);

        if (tmpIndex != null && tmpIndex != i) {
          return new int[] {i, tmpIndex};
        }
      }
      return null;
    }

    /**
     * 第三种解法：使用哈希表的性能优化版。不仅比第二种解法更加省空间，而且有可能更快。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private int[] useHashMap2(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int i = 0; i < nums.length; i++) {
        Integer tmpIndex = map.get(target - nums[i]);
        if (tmpIndex != null) {
          return new int[] {i, tmpIndex};
        }
        map.put(nums[i], i);
      }
      return null;
    }

  }
  //leetcode submit region end(Prohibit modification and deletion)

}