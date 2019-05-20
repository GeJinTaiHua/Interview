package ClassLoad.NotInitialization;

/**
 * @date 2019/5/20 17:45
 */
public class SuperClass extends SSClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;

    public SuperClass() {
        System.out.println("init SuperClass");
    }
}
