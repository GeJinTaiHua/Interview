namespace Subject
{
    /******单例模式：保证一个类只有一个实例，并提供一个访问它的全局访问点。******/

    /// <summary>
    /// 饿汉式
    /// 优点：无须考虑多个线程同时访问的问题，可以确保实例的唯一性；
    /// 缺点：资源利用效率不及懒汉。
    /// </summary>
    public class SingletonB
    {
        private static SingletonB singletonB = new SingletonB();

        private SingletonB() { }

        public static SingletonB GetSingletonB()
        {
            return singletonB;
        }
    }

    /// <summary>
    /// 懒汉式+双重加锁
    /// 优点：无须一直占用系统资源，实现了延迟加载；
    /// 缺点：必须处理好多个线程同时访问的问题。
    /// </summary>
    public class SingletonA
    {
        private static SingletonA singletonA;
        private static readonly object _object = new object();

        /// <summary>
        /// 构造方法私有，外键不能通过New类实例化此类
        /// </summary>
        private SingletonA() { }

        public static SingletonA GetSingletonA()
        {
            if (singletonA == null)
            {
                lock (_object)
                {
                    if (singletonA == null)
                    {
                        singletonA = new SingletonA();
                    }
                }
            }
            return singletonA;
        }
    }

    /// <summary>
    /// 泛型获取单例
    /// </summary>
    /// <typeparam name="T"></typeparam>
    public class SingletonProvider<T> where T : new()
    {
        private static T t;
        private static readonly object _object = new object();

        private SingletonProvider() { }

        public static T Instance
        {
            get
            {
                if (t == null)
                {
                    lock (_object)
                    {
                        if (t == null)
                        {
                            t = new T();
                        }
                    }
                }
                return t;
            }
        }
    }
}
