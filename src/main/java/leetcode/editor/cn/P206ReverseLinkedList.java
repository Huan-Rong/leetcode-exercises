//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表


package leetcode.editor.cn;

/**
 * Java：反转链表
 */
public class P206ReverseLinkedList {

  public static void main(String[] args) {
    Solution solution = new P206ReverseLinkedList().new Solution();
  }

  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
   * x) { val = x; } }
   */
  class Solution {

    public ListNode reverseList(ListNode head) {
      // return iterate1stTime(head);
      // return recursion1stTime(head, null);
      // return recursionVersion2_1stTime(head);
      // return iterate2ndTime(head);
      // return iterate3rdTime(head);
      // return recursion3rdTime(head);
      return recursionVersion2_3rdTime(head);
    }

    /******************第3遍20200528************************/
    /**
     * 第三种解法：不同的递归实现。
     *
     * <p>思路：类似于迭代的解法。
     *         指针 prev 和 curr 同样将整条链表分割为两个部分，第一部分已经完成反转，第二部分还未完成反转。
     *         这种递归实现会造成链表在递归过程中是断裂的，</p>
     */
    private ListNode recursionVersion2_3rdTime(ListNode head) {
      return recursionVersion2_3rdTime(head, null);
    }

    private ListNode recursionVersion2_3rdTime(ListNode curr, ListNode prev) {
      /**
       * 1.一开始判断链表是否为空链表，如果是非空链表则可以往下执行并开始递归。
       * 2.另外判断是否满足递归的终止条件，满足则终止递归。
       */
      if (curr == null) {
        return prev;
      }
      ListNode next = curr.next;
      curr.next = prev; // 链表开始断裂，但是在递归过程中，断裂处是移动的，直至递归完成。
      prev = curr;
      return recursionVersion2_3rdTime(next, prev);
    }

    /**
     * 第二种解法：递归
     *
     * <p>这遍练习的感受：不能忽视递归开始和结束的时间与条件</p>
     *
     * 时间复杂度：O(n) 空间复杂度：O(n)
     */
    private ListNode recursion3rdTime(ListNode head) {
      /**
       * 1.在迭代一开始时进行判断：如果是空链表或者链表只有一个结点，那么直接返回 head，不需要进行递归。
       *   也就是说，这两个条件都会用上。
       * 2.判断是否到了最后一个结点，如果到了最后一个结点，那么就结束递归。
       *   也就是说，这里只会用到第二个条件。
       */
      if (head == null || head.next == null) {
        return head;
      }
      ListNode newHead = recursion3rdTime(head.next);
      /**
       * 从倒数第二个结点开始执行下面一行代码。
       * 另外，由于是从最后一个结点开始进行反转操作，因此不会出现链表断裂的情况。
       */
      head.next.next = head;
      /**
       * 当前结点不能再指向原来的结点，会造成局部链表环。
       * 假设使用 A 表示当前节点，B 表示 A 原来指向的结点，那么在完成链表反转之后不能出现这种情况：B->A->B。
       */
      head.next = null;
      return newHead;
    }

    /**
     * 第一种解法：迭代
     *
     * <p>思路：指针 prev 和 curr 将整条链表进行了分割，一部分表示已经完成反转，一部分表示还没反转。
     * 从开始反转到反转结束之前，链表是断裂的。
     * </p>
     *
     * <p>时间复杂度：O(n)
     * <p>空间复杂度：O(1)
     */
    private ListNode iterate3rdTime(ListNode head) {
      ListNode prev = null;
      ListNode curr = head;

      while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
      return prev;
    }

    /******************第2遍20200527************************/
    /**
     * 思考：递归和迭代有什么不同？
     *
     * 1.递归会消耗更多的内存空间；
     * 2.从实现的角度来说，递归的实现是基于函数调用的，因此，每一次计算都是通过传入参数的方式来确定计算的上下文。
     *   在本题中，每一次计算的上下文就是当前结点。
     * 3.从实现的角度来说，迭代的上下文是通过改变循环变量来获取的。
     */
    /**
     * 第三种解法：递归的不同实现
     *
     * 思路：与第二种解法相比，这种解法只有在归的过程有处理，递的过程没处理。
     */
    private ListNode recursionVersion2_2ndTime(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }
      ListNode newHead = recursionVersion2_2ndTime(head.next);

      head.next.next = head;
      head.next = null;

      return newHead;
    }

    /**
     * 第二种解法：递归
     *
     * 思路：这个递归比较特别的地方是，在递的过程中就做了处理，归的过程只不过将最后一次递的结果一层层返回而已。 而一般的递归，在归的过程是会进行数据的处理的。因此这里可以粗糙地认为，只有递的过程，没有归的过程。
     */
    private ListNode recursion2ndTime(ListNode head, ListNode prev) {
      if (head == null) {
        return prev;
      }
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      return recursion2ndTime(next, prev);
    }

    /**
     * 第一种解法：迭代
     *
     * <p>思路：prev 结点表示已经完成反转的链表的头结点。
     *
     *
     * 时间复杂度：O(n) 空间复杂度：O(1)
     */
    private ListNode iterate2ndTime(ListNode head) {
      ListNode prev = null;
      ListNode curr = head;
      while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
      return prev;
    }

    /******************第1遍20200526************************/
    /**
     * 第一种解法：迭代反转链表
     *
     * 时间复杂度：O(n) 空间复杂度：O(1)
     */
    private ListNode iterate1stTime(ListNode head) {
      ListNode prev = null;
      ListNode curr = head;
      while (curr != null) {
        ListNode nextTmp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTmp;
      }
      return prev;
    }

    /**
     * 第二种解法：使用递归
     *
     * 思路：prev 表示已经反转部分的链表的头结点，head 表示剩余未反转部分的链表的头结点。 这个递归过程就是将 prev 从 null 逐渐变成一个完整链表的过程。
     *
     * 时间复杂度：O(n) 空间复杂度：O(n)
     */
    private ListNode recursion1stTime(ListNode head, ListNode prev) {
      if (head == null) {
        return prev;
      }
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      return recursion1stTime(next, prev);
    }

    /**
     * 第三种解法：另外一种递归实现。
     *
     * 思路：这种实现相对而言比较难理解。但只要明白，我们既需要返回新链表的头结点，也需要反转整个链表，就很容易理解这种实现。
     */
    private ListNode recursionVersion2_1stTime(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }
      ListNode newHead = recursionVersion2_1stTime(head.next);
      head.next.next = head;
      head.next = null;
      return newHead;
    }
  }
  //leetcode submit region end(Prohibit modification and deletion)
}