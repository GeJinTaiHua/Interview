package DataStructure;


import www.wjl.com.Interview.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/*
 * @desc 二叉树的遍历
 * @author wjl
 * @date 2018/8/29 0029
 */
public class BinaryTree {
    /*
     * @desc 前序遍历，递归实现
     * @author wjl
     * @date 2018/8/29 0029
     */
    public void PreOrder(TreeNode treeNode) {
        if (null != treeNode) {
            System.out.println(treeNode.value);
            PreOrder(treeNode.left);
            PreOrder(treeNode.right);
        }
    }

    /*
     * @desc 前序遍历，非递归实现
     * 1，先入栈根节点，输出根节点val值，再先后入栈其右节点、左结点；
     * 2，出栈左节点，输出其val值，再入栈该左节点的右节点、左节点；直到遍历完该左节点所在子树。
     * 3，再出栈右节点，输出其val值，再入栈该右节点的右节点、左节点；直到遍历完该右节点所在子树。
     * @author wjl
     * @date 2018/8/29 0029
     */
    public void PreOrder1(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        if (null != treeNode) {
            stack.push(treeNode);
        }

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.println(node.value);
            // 右结点先入栈，左结点后入栈
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }
    }

    /*
     * @desc 中序遍历，递归实现
     * @author wjl
     * @date 2018/8/29 0029
     */
    public void InOrder(TreeNode treeNode) {
        if (null != treeNode) {
            InOrder(treeNode.left);
            System.out.println(treeNode.value);
            InOrder(treeNode.right);
        }
    }

    /*
     * @desc 中序遍历，非递归实现
     * 1，首先从根节点出发一路向左，入栈所有的左节点；
     * 2，出栈一个节点，输出该节点val值，查询该节点是否存在右节点，
     * 若存在则从该右节点出发一路向左入栈该右节点所在子树所有的左节点；
     * 3，若不存在右节点，则出栈下一个节点，输出节点val值，同步骤2操作；
     * 4，直到节点为null，且栈为空。
     * @author wjl
     * @date 2018/8/29 0029
     */
    public void InOrder1(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.empty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.empty()) {
                TreeNode node = stack.pop();
                System.out.print(node.value);
                treeNode = node.right;
            }
        }
    }

    /*
     * @desc 后序遍历，递归实现
     * @author wjl
     * @date 2018/8/29 0029
     */
    public void PostOrder(TreeNode treeNode) {
        if (null != treeNode) {
            PostOrder(treeNode.left);
            PostOrder(treeNode.right);
            System.out.println(treeNode.value);
        }
    }

    /*
     * @desc 层序遍历（广度优先遍历）
     * @author wjl
     * @date 2018/8/29 0029
     */
    public void PostOrder1(TreeNode treeNode) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (treeNode != null) queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.value);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }
}
