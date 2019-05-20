package TryExceptionFinally;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaolong
 * @date 2019/5/20 17:50
 */
public class tryTest {

    @Test
    public void main() {
        int i = testBasic();
        System.out.println("main test i =" + i);

        List<Object> list = testWrap();
    }

    /**
     * try block, i = 2
     * finally block i = 10
     * main test i = 2
     */
    public static int testBasic() {
        int i = 1;
        try {
            i++;
            System.out.println("try block, i = " + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch block i = " + i);
            return i;
        } finally {
            i = 10;
            System.out.println("finally block i = " + i);
        }
    }

    /**
     * try block
     * finally block
     * main test i = [try, finally]
     */
    public static List<Object> testWrap() {
        List<Object> list = new ArrayList<>();
        try {
            list.add("try");
            System.out.println("try block");
            return list;
        } catch (Exception e) {
            list.add("catch");
            System.out.println("catch block");
            return list;
        } finally {
            list.add("finally");
            System.out.println("finally block ");
        }
    }
}
