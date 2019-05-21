using Entity;

namespace Subject
{
    /// <summary>
    /// 反转链表
    /// </summary>
    public class Reverse
    {
        /// <summary>
        /// 反转单向链表 O(n)
        /// </summary>
        /// <param name="head"></param>
        /// <returns></returns>
        public Node ReverseList(Node head)
        {
            Node pre = null;
            Node next = null;    //pre|next head
            while (head != null)
            {
                next = head.next;//pre   head-->next
                head.next = pre; //pre<--head   next
                pre = head;      //   <--head|pre next
                head = next;     //   <--pre    head|next
            }
            return pre;
        }

        /// <summary>
        /// 反转从from到to的部分单向链表
        /// </summary>
        /// <param name="head"></param>
        /// <param name="from"></param>
        /// <param name="to"></param>
        /// <returns></returns>
        public Node ReverseList(Node head, int from, int to)
        {
            //链表总长度
            int len = 0;
            //要反转部分的前一个节点            fpre-->from-->...-->to-->tPos
            Node fPre = null;
            //要反转部分的后一个节点
            Node tPos = null;

            //确认反转部分的[前一个节点]和[后一个节点]
            Node node1 = head;
            while (node1 != null)
            {
                len++;
                fPre = len == from - 1 ? node1 : fPre;
                tPos = len == to + 1 ? node1 : tPos;
                node1 = node1.next;
            }

            // 不满足反转条件
            if (from > to || from < 1 || to > len)
            {
                return head;
            }

            node1 = fPre == null ? head : fPre.next;
            Node node2 = node1.next;
            node1.next = tPos;
            Node next = null;
            while (node2 != tPos)
            {
                next = node2.next;
                node2.next = node1;
                node1 = node2;
                node2 = next;
            }

            if (fPre != null)
            {
                fPre.next = node1;
                //反转部分不包含头结点，直接返回头结点
                return head;
            }
            else
            {
                //反转部分包含头结点，返回以前反转部分的最后一个节点
                return node1;
            }
        }

        /// <summary>
        /// 反转双向链表
        /// </summary>
        /// <param name="hesd"></param>
        /// <returns></returns>
        public DoubleNode ReverseList(DoubleNode head)
        {
            DoubleNode pre = null;
            DoubleNode next = null;
            while (head != null)
            {
                next = head.next;
                head.next = pre;
                head.last = next;
                pre = head;
                head = next;
            }
            return pre;
        }
    }
}
