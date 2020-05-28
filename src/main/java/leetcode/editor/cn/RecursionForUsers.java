package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: Ian Zheng
 * @date: 2020-05-28
 */
public class RecursionForUsers {

  public static void main(String[] args) {
    int counter = 0;
    // 调用递归
    User user = new User("abc");
    count(Arrays.asList(user), counter);
    // 打印 User 的下级人数，即下级和下下级之和
    System.out.println(counter);
  }

  private static void count(List<User> users, int counter) {
    /*
     * 1.一开始判断参数是否有效
     * 2.其次在递归开始后，判断是否满足递归终止条件
     */
    if (users == null || users.size() == 0) {
      // 没有任何下级用户
      return;
    }

    // 查询下一级用户
    String sql = "select * from user where parent_id in (usersIds)";
    List<User> lowerUsers = searchDb(sql);
    // 叠加本次递归查询出的用户的下一级用户数
    counter += lowerUsers.size();

    // 进行下一轮递归
    count(lowerUsers, counter);
  }

  private static List<User> searchDb(String sql) {
    // 查询 ids 的下级用户
    return null;
  }

  static class User {

    private String name;

    public User() {
    }

    public User(String name) {
      this.name = name;
    }
  }

}
