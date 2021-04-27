package DataStructure;

import www.wjl.com.Interview.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的遍历
 *
 * @date 2021/4/27 10:55
 */
public class BinaryTree {
    /**
     * 前序遍历，递归实现
     * 根->左->右
     */
    public void PreOrderRecursion(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.getValue());
            PreOrderRecursion(treeNode.getLeft());
            PreOrderRecursion(treeNode.getRight());
        }
    }

    /**
     * 中序遍历，递归实现
     * 左->根->右
     */
    public void InOrderRecursion(TreeNode treeNode) {
        if (treeNode != null) {
            InOrderRecursion(treeNode.getLeft());
            System.out.println(treeNode.getValue());
            InOrderRecursion(treeNode.getRight());
        }
    }

    /**
     * 后序遍历，递归实现
     * 左->右->根
     */
    public void PostOrderRecursion(TreeNode treeNode) {
        if (treeNode != null) {
            PostOrderRecursion(treeNode.getLeft());
            PostOrderRecursion(treeNode.getRight());
            System.out.println(treeNode.getValue());
        }
    }

    /**
     * 前序遍历，非递归实现
     * 1，先入栈根节点，输出根节点val值，再先后入栈其右节点、左结点；
     * 2，出栈左节点，输出其val值，再入栈该左节点的右节点、左节点；直到遍历完该左节点所在子树。
     * 3，再出栈右节点，输出其val值，再入栈该右节点的右节点、左节点；直到遍历完该右节点所在子树。
     */
    public void PreOrderNoRecursion(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.println(node.getValue());

            // 右结点先入栈，左结点后入栈
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }

    /**
     * 中序遍历，非递归实现
     * 1，首先从根节点出发一路向左，入栈所有的左节点；
     * 2，出栈一个节点，输出该节点val值，查询该节点是否存在右节点，
     * 若存在则从该右节点出发一路向左入栈该右节点所在子树所有的左节点；
     * 3，若不存在右节点，则出栈下一个节点，输出节点val值，同步骤2操作；
     * 4，直到节点为null，且栈为空。
     */
    public void InOrderNoRecursion(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.empty()) {
            // 走完左孩子
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.getLeft();
            }

            // 没有左孩子，输出
            if (!stack.empty()) {
                TreeNode node = stack.pop();
                System.out.print(node.getValue());
                // 最后一个节点的右孩子
                treeNode = node.getRight();
            }
        }
    }

    /**
     * 后序遍历，非递归实现
     */
    public void PostOrderNoRecursion(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode tag = null;// 两树顶
        while (treeNode != null || !stack.isEmpty()) {
            // 走完左孩子
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.getLeft();
            }

            treeNode = stack.peek();
            if (treeNode.getRight() == null || treeNode.getRight() == tag) {
                // 右子树为空，或者已经遍历过，回到最近顶点
                System.out.println(treeNode.getValue());
                tag = stack.pop();
            } else {
                // 遍历该节点的右子树
                tag = treeNode;
                treeNode = treeNode.getRight();
            }
        }
    }

    /**
     * 层序遍历（广度优先遍历）
     */
    public void levelOrder(TreeNode treeNode) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (treeNode != null) {
            queue.offer(treeNode);
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.getValue());

            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }

            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }
    }
}