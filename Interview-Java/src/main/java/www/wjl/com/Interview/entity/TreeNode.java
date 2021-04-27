package www.wjl.com.Interview.entity;

import lombok.Data;

/**
 * 二叉树
 *
 * @date 2021/4/27 10:55
 */
@Data
public class TreeNode<T> {
    private T value;

    private TreeNode<T> left;

    private TreeNode<T> right;
}
