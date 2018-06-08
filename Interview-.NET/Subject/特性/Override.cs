namespace Subject
{
    /* * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * *
     * 1、不管是重写还是覆盖都不会影响父类自身的功能。
     * 2、当用子类创建父类的时候，如 C1 c12 = new C2()，重写会改变父类的功能，即调用子类的功能；而覆盖不会，仍然调用父类功能。
     * 3、virtual、abstract或override可以被重写（override），实方法不可以。
     * 4、不能用new、static、virtual修饰符修改override方法。
     * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * */

    /// <summary>
    /// 重写（override）和覆盖（new）
    /// </summary>
    public class Test_Override
    {
        public void Run()
        {
            C1 c1 = new C1();
            string c1_name = c1.GetNmae();//C1.virtual
            C2 c2 = new C2();
            string c2_name = c2.GetNmae();//C2.override
            C3 c3 = new C3();
            string c3_name = c3.GetNmae();//C1.virtual

            C1 c12 = new C2();
            string c12_name = c12.GetNmae();//C2.override
            C1 c13 = new C3();
            string c13_name = c13.GetNmae();//C1.virtual

            C1 c42 = new C42();
            string c42_name = c42.GetNmae();//C2.override

            C5 c5 = new C5();
            string c5_name = c5.GetNmae();//C0
        }
    }

    public class C1
    {
        public virtual string GetNmae()
        {
            return "C1.virtual";
        }
    }

    public class C2 : C1
    {
        public override string GetNmae()
        {
            return "C2.override";
        }
    }

    public class C3 : C1
    {
        public new string GetName()
        {
            return "C3.new";
        }
    }

    public class C42 : C2
    {
        public string GetName()
        {
            return "C42.new";
        }
    }

    /// <summary>
    /// ///////////////////////////////////////////////////////////////////////////////
    /// </summary>
    public class C0
    {
        public string GetNmae()
        {
            return "C0";
        }
    }

    public class C5 : C0
    {
        public new string GetName()
        {
            return "C5.new";
        }
    }
}
