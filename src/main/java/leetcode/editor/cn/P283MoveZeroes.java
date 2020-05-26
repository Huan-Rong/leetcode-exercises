//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;

/**
 * Java：移动零
 */
public class P283MoveZeroes {

  public static void main(String[] args) {
    Solution solution = new P283MoveZeroes().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  @SuppressWarnings("Duplicates")
  class Solution {

    public void moveZeroes(int[] nums) {
      quickerLoop3rdTime(nums);
    }

    /******************第3遍20200526************************/
    /**
     * 第二种解法：一遍遍历法。
     * 
     * 这种解法其实是在优化第一种解法，因为两遍遍历是可以合为一遍遍历的。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private void quickerLoop3rdTime(int[] nums) {
      for (int i = 0, j = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
          if (i>j) {
            nums[j] = nums[i];
            nums[i] = 0;
          }
          j++;
        }
      }
    }
    /**
     * 第一种解法：两遍遍历法。
     *
     * <p>第一次遍历，求出非零元素的个数，且进行非零元素的复制。
     * 第二次遍历，将索引值在 [j, nums.length - 1] 范围的元素置为 0 。
     *
     * <p>第一次遍历使用了双指针，j 指针指向下一个会被赋值的元素。
     *
     * <p>时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * <p>测试用例：
     *
     * {@code [],[1],[0],[0,0,0],[1,2,0,2,43,0],[0,1,2,0]}
     */
    private void loop3rdTime(int[] nums) {
      int j = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
          if (i > j) {
            nums[j] = nums[i];
          }
          j++;
        }
      }
      for (int i = j; i < nums.length; i++) {
        nums[i] = 0;
      }
    }

    /******************第2遍20200525************************/
    /**
     * 第二种解法：一遍遍历法。
     *
     * 思想：借鉴快速排序思想，以 0 作为中间点。
     *
     * 时间复杂度：O(n) 空间复杂度：O(1)
     */
    private void quickerLoop2ndTime(int[] nums) {
      for (int i = 0, j = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
          // 避免相同的非零数组元素进行交换。
          if (i > j) {
            nums[j] = nums[i];
            nums[i] = 0;
          }
          j++;
        }
      }
    }

    /**
     * 第一种解法：两遍遍历。
     *
     * <p>第一遍计算出非零元素的总数，并进行赋值操作。
     * 第二遍将索引值为 [j, nums.length - 1] 的元素置为 0。
     *
     * 时间复杂度：O(n) 空间复杂度：O(1)
     */
    private void loop2ndTime(int[] nums) {
      int j = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
          nums[j++] = nums[i];
        }
      }

      for (int i = j; i < nums.length; i++) {
        nums[i] = 0;
      }
    }

    /******************第1遍20200525************************/
    /**
     * 第二种解法：一遍遍历法。
     *
     * 思路：借助快速排序思想，将 0 作为中间点。
     *
     * 时间复杂度：O(n) 空间复杂度：O(1)
     */
    private void quickerLoop1stTime(int[] nums) {
      for (int i = 0, j = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
          // 避免数组元素相同，且不为零时进行交换操作。
          if (i > j) {
            nums[j] = nums[i];
            nums[i] = 0;
          }
          j++;
        }
      }
    }

    /**
     * 第一种解法：两次遍历法。
     *
     * <p>第一遍：计算非零元素的个数，且在遍历过程中进行非零元素的复制。
     * 第二遍：将剩余的元素全部置为 0。
     *
     * 时间复杂度：O(N)，如果数组元素全为 0，那么会执行 2N 次，时间复杂度还是 O(N)。 空间复杂度：O(1)
     */
    private void loop1stTime(int[] nums) {
      int j = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
          nums[j++] = nums[i];
        }
      }

      for (int i = j; i < nums.length; i++) {
        nums[i] = 0;
      }
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}