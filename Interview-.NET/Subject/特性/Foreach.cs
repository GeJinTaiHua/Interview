using System;
using System.Collections;

namespace Subject
{
    /* * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * *
     * IEnumerable：最基本的接口；有一个抽象方法GetEnumerator，返回IEnumerator。
     * IEnumerator：所有枚举数的基接口。
     * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * */

    /// <summary>
    /// 实现一个类的Foreach
    /// </summary>
    public class Test_Foreach
    {
        public void Run()
        {
            Name[] nameArray = new Name[5];
            nameArray[0] = new Name("firstName0", "lastName0");
            nameArray[1] = new Name("firstName1", "lastName1");
            nameArray[2] = new Name("firstName2", "lastName2");
            nameArray[3] = new Name("firstName3", "lastName3");
            nameArray[4] = new Name("firstName4", "lastName4");

            NameList nameList = new NameList(nameArray);
            foreach (Name item in nameList)
            {
                Name name = item;
            }
        }
    }

    public class Name
    {
        public string firstName;
        public string lastName;
        public Name(string firstName, string lastName)
        {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    /// <summary>
    /// Name类的集合
    /// </summary>
    public class NameList : IEnumerable
    {
        private Name[] _name;
        public NameList(Name[] nameArray)
        {
            _name = new Name[nameArray.Length];
            for (int i = 0; i < nameArray.Length; i++)
            {
                _name[i] = nameArray[i];
            }
        }

        /// <summary>
        /// IEnumerable接口，所以要实现GetEnumerator方法，返回一个实现了IEnumerator的类。  
        /// </summary>
        /// <returns></returns>
        //public NameEnum GetEnumerator()
        //{
        //    return new NameEnum(_name);
        //}
        IEnumerator IEnumerable.GetEnumerator()
        {
            return new NameEnum(_name);
        }
    }

    public class NameEnum : IEnumerator
    {
        public Name[] _name;
        int position = -1;
        public NameEnum(Name[] nameArray)
        {
            _name = nameArray;
        }

        /// <summary>
        /// 下一个元素
        /// </summary>
        /// <returns></returns>
        public bool MoveNext()
        {
            position++;
            return (position < _name.Length);
        }

        /// <summary>
        /// 重置
        /// </summary>
        public void Reset()
        {
            position = -1;
        }

        /// <summary>
        /// 获取集合中的当前元素
        /// </summary>
        object IEnumerator.Current
        {
            get
            {
                return Current;
            }
        }

        public Name Current
        {
            get
            {
                try
                {
                    return _name[position];
                }
                catch (IndexOutOfRangeException)
                {
                    throw new InvalidOperationException();
                }
            }
        }
    }
}
