namespace Entity
{
    /// <summary>
    /// 单向链表
    /// </summary>
    public class Node
    {
        public int value;
        public Node next;
        public Node(int data)
        {
            value = data;
        }
    }

    /// <summary>
    /// 双向链表
    /// </summary>
    public class DoubleNode
    {
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int data)
        {
            value = data;
        }
    }
}
