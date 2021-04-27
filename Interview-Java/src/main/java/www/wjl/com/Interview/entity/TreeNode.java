package www.wjl.com.Interview.entity;

import lombok.Data;

/**
 * 二叉树
 *
 * @date 2021/4/27 10:55
 */
@Data
public class TreeNode<T> {
    public T value;

    // 左子树
    public TreeNode<T> left;
    // 右子树
    public TreeNode<T> right;
}
