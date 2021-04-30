package www.wjl.com.Interview.entity;

import lombok.Data;

/**
 * 二叉树
 *
 * @date 2021/4/27 10:55
 */
public class TreeNode<T> {
    public T value;

    public TreeNode<T> left;

    public TreeNode<T> right;
}
