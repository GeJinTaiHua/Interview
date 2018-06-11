package 基本数据类型;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * @desc 字符串
 * @author wjl
 * @date 2018/5/25 0025
 */
@SpringBootTest
public class String {
    /*
     * @desc 字符串比较
     * == 比较两个对象的引用是否相等
     * equals比较两个字符串的值是否相等
     * @author wjl
     * @date 2018/5/25 0025
     */
    @Test
    public void Compare() {
        java.lang.String s1 = new java.lang.String("Hello");
        java.lang.String s2 = new java.lang.String("Hello");

        System.out.println(s1 == s2); //false
        System.out.println(s1.equals(s2)); //true
    }
}
