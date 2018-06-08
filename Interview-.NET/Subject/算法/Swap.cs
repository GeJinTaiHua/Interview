namespace Subject
{
    /// <summary>
    /// 交换 a b 的值
    /// </summary>
    public class Swap
    {
        public void Swap1(ref int a, ref int b)
        {
            int temp = a;
            a = b;
            b = temp;
        }

        public void Swap2(ref int a, ref int b)
        {
            a = a + b;
            b = a - b;
            a = a - b;
        }

        public void Swap3(ref int a, ref int b)
        {
            a ^= b;
            b ^= a;
            a ^= b;
        }

        public void Swap4(ref int a, ref int b)
        {
            b = a + 0 * (a = b);
        }
    }
}
