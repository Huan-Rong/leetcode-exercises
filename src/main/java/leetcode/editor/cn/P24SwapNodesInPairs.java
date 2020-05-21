//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表


package leetcode.editor.cn;

/**
 * Java：两两交换链表中的节点
 */
public class P24SwapNodesInPairs {

  public static void main(String[] args) {
    Solution solution = new P24SwapNodesInPairs().new Solution();
    // ListNode head = new P24SwapNodesInPairs().new ListNode(1);
    // head.next = new P24SwapNodesInPairs().new ListNode(2);
    // head.next.next = new P24SwapNodesInPairs().new ListNode(3);
    // head.next.next.next = new P24SwapNodesInPairs().new ListNode(4);
    // solution.bruteForce(head);
  }

  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
   * x) { val = x; } }
   */
  class Solution {

    public ListNode swapPairs(ListNode head) {
      return useRecursion(head);
    }

    /**
     * 第三种解法：使用递归。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)，递归过程使用的堆栈空间。递归这种解法的空间复杂度差于 {@code while} 迭代法。
     *           这里重点是感受递归的使用。
     *
     * <p>理解递归的重点：
     *
     *    1.递归有助于将大规模问题分解为解法思路相同的小问题。
     *    2.实现递归，重要的是理解递归过程，递归终止条件。
     * </p>
     */
    private ListNode useRecursion(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode formerNode = head;
      ListNode latterNode = head.next;

      // 递归
      formerNode.next = useRecursion(latterNode.next);
      latterNode.next = formerNode;

      return latterNode;
    }

    /**
     * 第二种方法：使用 while 循环解决。
     *
     * 这是第一种方法的实现优化，将无头单链表改造成有头单链表，以解决单独处理头结点的问题，降低编码难度。
     *
     * <p>处理过程中需要注意，链表不能中断。</p>
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private ListNode useWhile2(ListNode head) {
      // 改造无头单链表为带头单链表
      ListNode dummy = new ListNode();
      dummy.next = head;

      ListNode prevNode = dummy;
      while (prevNode.next != null && prevNode.next.next != null) {
        // 定义交换的两个结点
        ListNode formerNode = prevNode.next;
        ListNode latterNode = prevNode.next.next;

        // 交换结点
        formerNode.next = latterNode.next;
        latterNode.next = formerNode;
        // 保证链表不会中断
        prevNode.next = latterNode;
        // 重设前驱结点
        prevNode = formerNode;
      }
      return dummy.next;
    }

    /**
     * 第一种方法：使用 while 循环解决。
     *
     * 时间复杂度：O(n)，n 是链表中的节点数量
     * 空间复杂度：O(1）
     *
     * <p>编码实现的方式不够优雅，在这里需要单独处理头结点。</p>
     * <p>另外需要注意边界的处理，如{@code []}, {@code [1}</p>
     */
    private ListNode useWhile(ListNode head) {
      // 头结点需要特殊处理
      ListNode prev = null;
      if (head != null && head.next != null) {
        ListNode former = head;
        ListNode latter = head.next;

        // exchange
        former.next = latter.next;
        latter.next = former;
        head = latter;
        prev = former;
      } else {
        return head;
      }

      while (prev.next != null && prev.next.next != null) {
        ListNode former = prev.next;
        ListNode latter = prev.next.next;

        former.next = latter.next;
        latter.next = former;
        prev.next = latter;

        prev = former;
      }
      return head;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)

  class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}