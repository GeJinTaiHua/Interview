package ClassLoad.NotInitialization;

/**
 * @date 2019/5/20 17:46
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
    }

    static int a;

    public SubClass() {
        System.out.println("init SubClass");
    }
}
