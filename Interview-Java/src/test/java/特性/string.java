package 特性;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * @desc 关于String
 * @author wjl
 * @date 2018/5/25 0025
 */
@SpringBootTest
public class string {
    @Test
    public void test() {
        // 1.比较2个字符串
        //== 比较两个对象的引用是否相等
        //equals比较两个字符串的值是否相等
        String s1 = new String("Hello");
        String s2 = new String("Hello");

        System.out.println(s1 == s2); //false
        System.out.println(s1.equals(s2)); //true

        // 2.char[]安全保密性比Strign高
        //String是不可变得，直到垃圾收集器回收。字符数组可以更改，意味着用完就可以将其更改。
    }
}
