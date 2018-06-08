using System.Collections;

namespace Subject
{
    /* * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * *
     * HashTable（哈希表）表示键/值对的集合。
     * 1、不支持泛型。
     * 2、元素属于Object类型，所以在存储或检索值类型时通常发生装箱和拆箱的操作，非常耗时。
     * 3、允许单线程写入, 多线程读取, 对Hashtable进一步调用Synchronized()方法可以获得完全线程安全的类型。
     * 4、解决冲突方法是闭散列法中的双重散列法：h1(key) = key.GetHashCode()  
     *                                          h2(key) = 1 + (((h1(key) >> 5) + 1) % (hashsize - 1))
     *                                          哈希地址 = h(key, i) % hashsize
     * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * */

    public class Test_Hashtable
    {
        public Hashtable hashtable = new Hashtable();

        public void HashtableOperation()
        {
            hashtable.Add("001", "A-001");
            hashtable.Add("003", "C-003");
            hashtable.Add("002", "B-002");

            if (hashtable.Contains("C-003"))
            {
                hashtable.Remove("C-003");
            }

            // 获取键的集合   
            ICollection key = hashtable.Keys;

            hashtable.Clear();
        }

        #region Hashtable的实现简化源码

        ////固定的素数
        //internal const Int32 HashPrime = 101;
        ////默认容量
        //private const Int32 InitialSize = 3;

        ///// <summary>
        ///// 数据桶，用于存储哈希表中的元素
        ///// </summary>
        //private struct bucket
        //{
        //    public Object key;
        //    public Object val;
        //    public int hash_col;
        //}

        //private bucket[] buckets;
        ////元素总数
        //private int count;
        ////发生冲突的次数
        //private int occupancy;

        ////装载容量值，相当于一个阈值，达到了这个数值，将对哈希表进行扩容
        //private int loadsize;
        ////哈希表中的元素占有数据桶空间的一个比率，这个比例直接决定了哈希表在什么时候进行扩容
        //private float loadFactor;

        //private volatile int version;
        //private volatile bool isWriterInProgress;

        //private ICollection keys;
        //private ICollection values;

        ////默认构造方法
        //public @HashtableT() : this(0, 1.0f) { }

        ///// <summary>
        ///// 构造函数
        ///// </summary>
        ///// <param name="capacity"></param>
        ///// <param name="loadFactor"></param>
        //public @HashtableT(int capacity, float loadFactor)
        //{
        //    if (capacity < 0)
        //    {
        //        throw new ArgumentOutOfRangeException("容量不能小于0");
        //    }

        //    if (!(loadFactor >= 0.1f && loadFactor <= 1.0f))
        //    {
        //        throw new ArgumentOutOfRangeException("填充因子必须在0.1～1之间");
        //    }

        //    Contract.EndContractBlock();

        //    //0.72f为最优加载因子
        //    this.loadFactor = 0.72f * loadFactor;
        //    //原始容量
        //    double rawsize = capacity / this.loadFactor;
        //    if (rawsize > Int32.MaxValue)
        //    {
        //        throw new ArgumentOutOfRangeException("原始容量超界");
        //    }

        //    //容量大于等于默认容量值
        //    int hashsize = (rawsize > InitialSize) ? HashHelpers.GetPrime((int)rawsize) : InitialSize;

        //    buckets = new bucket[hashsize];

        //    //装载容量，结果为小于或等于容量的值
        //    loadsize = (int)(this.loadFactor * hashsize);
        //    isWriterInProgress = false;
        //    Contract.Assert(loadsize < hashsize, "Invalid hashtable loadsize!");
        //}

        //private uint InitHash(Object key, int hashsize, out uint seed, out uint incr)
        //{
        //    //取正数值,第一和哈希函数h_1(k)
        //    uint hashcode = (uint)GetHash(key) & 0x7FFFFFFF;
        //    seed = (uint)hashcode;
        //    //第二个哈希函数h_2(k)的增量
        //    incr = (uint)(1 + ((seed * HashPrime) % ((uint)hashsize - 1)));
        //    return hashcode;
        //}

        ///// <summary>
        ///// 添加元素
        ///// </summary>
        ///// <param name="key"></param>
        ///// <param name="value"></param>
        //public virtual void Add(Object key, Object value)
        //{
        //    Insert(key, value, true);
        //}

        //private void Insert(Object key, Object nvalue, bool add)
        //{
        //    if (key == null)
        //    {
        //        throw new ArgumentOutOfRangeException("key不能为null");
        //    }
        //    Contract.EndContractBlock();
        //    if (count >= loadsize)
        //    {
        //        //当元素的总数大于等于装载量时，自动扩容
        //        expand();
        //    }
        //    else if (occupancy > loadsize && count > 100)
        //    {
        //        //在元素总数大于100之后，判断冲突计数大于装载量时，将HashTable重新哈希
        //        rehash();
        //    }

        //    uint seed;
        //    uint incr;

        //    uint hashcode = InitHash(key, buckets.Length, out seed, out incr);
        //    int ntry = 0;//寻址次数，不得大于等于哈希表容量
        //    int emptySlotNumber = -1; //用于记录第一个寻址到的可用插槽

        //    int bucketNumber = (int)(seed % (uint)buckets.Length);
        //    do
        //    {
        //        //有冲突的空插槽
        //        if (emptySlotNumber == -1 && (buckets[bucketNumber].key == buckets) && (buckets[bucketNumber].hash_coll < 0))
        //            emptySlotNumber = bucketNumber;

        //        //正常的空插槽
        //        if ((buckets[bucketNumber].key == null) ||
        //            (buckets[bucketNumber].key == buckets && ((buckets[bucketNumber].hash_coll & unchecked(0x80000000)) == 0)))
        //        {

        //            //将元素放入寻址到的第一个可用插槽
        //            if (emptySlotNumber != -1)
        //                bucketNumber = emptySlotNumber;

        //            Thread.BeginCriticalRegion();

        //            isWriterInProgress = true;
        //            buckets[bucketNumber].val = nvalue;
        //            buckets[bucketNumber].key = key;
        //            buckets[bucketNumber].hash_coll |= (int)hashcode;
        //            count++;
        //            UpdateVersion();
        //            isWriterInProgress = false;

        //            Thread.EndCriticalRegion();

        //            if (ntry > HashHelpers.HashCollisionThreshold && HashHelpers.IsWellKnownEqualityComparer(_keycomparer))
        //            {
        //                if (_keycomparer == null || !(_keycomparer is System.Collections.Generic.RandomizedObjectEqualityComparer))
        //                {
        //                    _keycomparer = HashHelpers.GetRandomizedEqualityComparer(_keycomparer);
        //                    rehash(buckets.Length, true);
        //                }
        //            }

        //            return;
        //        }

        //        //替换更新（此处值变更，Update操作），若添加重复的键，则抛出异常
        //        if (((buckets[bucketNumber].hash_coll & 0x7FFFFFFF) == hashcode) &&
        //            KeyEquals(buckets[bucketNumber].key, key))
        //        {
        //            if (add)
        //            {
        //                throw new ArgumentException(Environment.GetResourceString("Argument_AddingDuplicate__", buckets[bucketNumber].key, key));
        //            }

        //            Thread.BeginCriticalRegion();

        //            isWriterInProgress = true;
        //            buckets[bucketNumber].val = nvalue;
        //            UpdateVersion();
        //            isWriterInProgress = false;

        //            Thread.EndCriticalRegion();

        //            if (ntry > HashHelpers.HashCollisionThreshold && HashHelpers.IsWellKnownEqualityComparer(_keycomparer))
        //            {
        //                if (_keycomparer == null || !(_keycomparer is System.Collections.Generic.RandomizedObjectEqualityComparer))
        //                {
        //                    _keycomparer = HashHelpers.GetRandomizedEqualityComparer(_keycomparer);
        //                    rehash(buckets.Length, true);
        //                }
        //            }

        //            return;
        //        }


        //        //存在冲突 将哈希值设置为负数
        //        if (emptySlotNumber == -1)
        //        {
        //            if (buckets[bucketNumber].hash_coll >= 0)
        //            {
        //                buckets[bucketNumber].hash_coll |= unchecked((int)0x80000000);
        //                occupancy++;
        //            }
        //        }

        //        bucketNumber = (int)(((long)bucketNumber + incr) % (uint)buckets.Length);
        //        //寻址次数肯定是不能超过最大索引下标的，此处循环用于冲突的二次寻址   
        //    } while (++ntry < buckets.Length);

        //    //插槽已满，将元素插入第一个寻址到的可用插槽
        //    if (emptySlotNumber != -1)
        //    {
        //        Thread.BeginCriticalRegion();

        //        isWriterInProgress = true;
        //        buckets[emptySlotNumber].val = nvalue;
        //        buckets[emptySlotNumber].key = key;
        //        buckets[emptySlotNumber].hash_coll |= (int)hashcode;
        //        count++;
        //        UpdateVersion();
        //        isWriterInProgress = false;

        //        Thread.EndCriticalRegion();

        //        if (buckets.Length > HashHelpers.HashCollisionThreshold && HashHelpers.IsWellKnownEqualityComparer(_keycomparer))
        //        {
        //            if (_keycomparer == null || !(_keycomparer is System.Collections.Generic.RandomizedObjectEqualityComparer))
        //            {
        //                _keycomparer = HashHelpers.GetRandomizedEqualityComparer(_keycomparer);
        //                rehash(buckets.Length, true);
        //            }
        //        }


        //        return;
        //    }

        //    Contract.Assert(false, "hash table insert failed!  Load factor too high, or our double hashing function is incorrect.");
        //    throw new InvalidOperationException(Environment.GetResourceString("InvalidOperation_HashInsertFailed"));
        //}

        //private void expand() //扩容  
        //{   //使新的容量为旧容量的近似两倍  
        //    int rawsize = 0;// HashHelpers.GetPrime(buckets.Length * 2);
        //    rehash(rawsize);
        //}

        //private void rehash(int newsize) //按新容量扩容  
        //{
        //    bucket[] newBuckets = new bucket[newsize];
        //    for (int nb = 0; nb < buckets.Length; nb++)
        //    {
        //        bucket oldb = buckets[nb];
        //        if ((oldb.key != null) && (oldb.key != buckets))
        //        {
        //            putEntry(newBuckets, oldb.key, oldb.val,
        //                oldb.hash_coll & 0x7FFFFFFF);
        //        }
        //    }
        //    buckets = newBuckets;
        //    loadsize = (int)(loadFactor * newsize);
        //    return;
        //}

        ////在新数组内添加旧数组的一个元素  
        //private void putEntry(bucket[] newBuckets, Object key,
        //    Object nvalue, int hashcode)
        //{
        //    uint seed = (uint)hashcode; //h1  
        //    uint incr = (uint)(1 + (((seed >> 5) + 1) %
        //        ((uint)newBuckets.Length - 1))); //h2  
        //    int bn = (int)(seed % (uint)newBuckets.Length);//哈希地址  
        //    do
        //    {   //当前位置为有冲突空位或无冲突空位时都可添加新元素  
        //        if ((newBuckets[bn].key == null) ||
        //            (newBuckets[bn].key == buckets))
        //        {   //赋值  
        //            newBuckets[bn].val = nvalue;
        //            newBuckets[bn].key = key;
        //            newBuckets[bn].hash_coll |= hashcode;
        //            return;
        //        }
        //        //当前位置已存在其他元素时  
        //        if (newBuckets[bn].hash_coll >= 0)
        //        {   //置hash_coll的高位为1  
        //            newBuckets[bn].hash_coll |=
        //                unchecked((int)0x80000000);
        //        }
        //        //二度哈希h1(key)+h2(key)  
        //        bn = (int)(((long)bn + incr) % (uint)newBuckets.Length);
        //    } while (true);
        //}

        ///// <summary>
        ///// 获取值 / 设置值
        ///// </summary>
        ///// <param name="key"></param>
        ///// <returns></returns>
        //public virtual Object this[Object key]
        //{
        //    get
        //    {
        //        if (key == null)
        //        {
        //            throw new ArgumentNullException("key", Environment.GetResourceString("ArgumentNull_Key"));
        //        }
        //        Contract.EndContractBlock();

        //        uint seed;
        //        uint incr;

        //        //生成一个数据桶的结构副本，防止其他线程同一时间对同一个结构进行调整。
        //        bucket[] lbuckets = buckets;
        //        uint hashcode = InitHash(key, lbuckets.Length, out seed, out incr);
        //        int ntry = 0;

        //        bucket b;
        //        int bucketNumber = (int)(seed % (uint)lbuckets.Length);
        //        do
        //        {
        //            int currentversion;

        //            int spinCount = 0;
        //            do
        //            {
        //                currentversion = version;
        //                b = lbuckets[bucketNumber];

        //                //这里使用线程休眠是为了防止资源争夺而导致CPU过度消耗
        //                if ((++spinCount) % 8 == 0)
        //                {
        //                    Thread.Sleep(1);
        //                }
        //                //若有其他线程在做调整，等待完成再获取最新的值
        //            } while (isWriterInProgress || (currentversion != version));

        //            if (b.key == null)
        //            {
        //                return null;
        //            }
        //            if (((b.hash_coll & 0x7FFFFFFF) == hashcode) &&
        //                KeyEquals(b.key, key))
        //                return b.val;
        //            bucketNumber = (int)(((long)bucketNumber + incr) % (uint)lbuckets.Length);
        //        } while (b.hash_coll < 0 && ++ntry < lbuckets.Length);
        //        return null;
        //    }

        //    set
        //    {
        //        //更新现在的键值
        //        Insert(key, value, false);
        //    }
        //}

        //protected virtual bool KeyEquals(Object item, Object key)
        //{
        //    Contract.Assert(key != null, "key can't be null here!");
        //    if (Object.ReferenceEquals(buckets, item))
        //    {
        //        return false;
        //    }

        //    if (Object.ReferenceEquals(item, key))
        //        return true;

        //    if (_keycomparer != null)
        //        return _keycomparer.Equals(item, key);
        //    return item == null ? false : item.Equals(key);
        //}

        ///// <summary>
        ///// 移除元素
        ///// </summary>
        ///// <param name="key"></param>
        //public virtual void Remove(Object key)
        //{
        //    if (key == null)
        //    {
        //        throw new ArgumentNullException("key", Environment.GetResourceString("ArgumentNull_Key"));
        //    }
        //    Contract.EndContractBlock();
        //    Contract.Assert(!isWriterInProgress, "Race condition detected in usages of Hashtable - multiple threads appear to be writing to a Hashtable instance simultaneously!  Don't do that - use Hashtable.Synchronized.");

        //    uint seed;
        //    uint incr;

        //    uint hashcode = InitHash(key, buckets.Length, out seed, out incr);
        //    int ntry = 0;

        //    bucket b;
        //    int bn = (int)(seed % (uint)buckets.Length);
        //    //第一次循环若找不到值，那么表示有冲突链 或 键值不存在
        //    do
        //    {
        //        b = buckets[bn];
        //        if (((b.hash_coll & 0x7FFFFFFF) == hashcode) && KeyEquals(b.key, key))
        //        {

        //            Thread.BeginCriticalRegion();

        //            isWriterInProgress = true;

        //            //正常插槽哈希码为0 / 冲突插槽哈希码为负数
        //            buckets[bn].hash_coll &= unchecked((int)0x80000000);
        //            if (buckets[bn].hash_coll != 0)
        //            {
        //                //冲突插槽的key指向buckets
        //                buckets[bn].key = buckets;
        //            }
        //            else
        //            {
        //                //正常插槽的key赋空引用
        //                buckets[bn].key = null;
        //            }
        //            buckets[bn].val = null;
        //            count--;
        //            UpdateVersion();
        //            isWriterInProgress = false;

        //            Thread.EndCriticalRegion();

        //            return;
        //        }
        //        bn = (int)(((long)bn + incr) % (uint)buckets.Length);
        //        //循环冲突链                               
        //    } while (b.hash_coll < 0 && ++ntry < buckets.Length);
        //}

        #endregion
    }
}
