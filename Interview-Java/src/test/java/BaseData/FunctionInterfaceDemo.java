package BaseData;

/*
 * @desc 函数式接口
 * @author wjl
 * @date 2018/8/31 0031
 */
public class FunctionInterfaceDemo {
    @FunctionalInterface
    interface Predicate<T> {
        boolean test(T t);
    }

    private static boolean doPredicate(int age, Predicate<Integer> predicate) {
        return predicate.test(age);
    }
    
    public static void main(String args) {
        boolean is = doPredicate(20, x -> x >= 18);
    }
}
