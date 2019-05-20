package ClassLoad.NotInitialization;

/**
 * 对于静态字段，只有直接定义这个字段的类才会被初始化，因此通过其子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发子类的初始化：
 *
 * @date 2019/5/20 17:44
 */
public class NotInitialization {
    /**
     * 输出结果：
     * SSClass
     * SuperClass init!
     * 123
     */
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
