package ClassLoad;

/**
 * 实例初始化不一定要在类初始化结束之后才开始初始化
 *
 * @author xiaolong
 * @date 2019/5/20 17:27
 */
public class StaticTest {
    /**
     * 输出结果：
     * 2
     * 3
     * a=110,b=0
     * 1
     * 4
     */
    public static void main(String[] args) {
        staticFunction();
    }

    static StaticTest st = new StaticTest();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    static int b = 112;
}
