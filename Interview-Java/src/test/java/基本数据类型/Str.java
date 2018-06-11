package 基本数据类型;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * @desc 字符串
 * @author wjl
 * @date 2018/5/25 0025
 */
@SpringBootTest
public class Str {
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

    /*
     * @desc 字符串的驻留
     * @author wjl
     * @date 2018/6/11 0011
     */
    @Test
    public void Interning() {
        String str1 = "ABCD1234";
        String str2 = "ABCD1234";

        String str3 = "ABCD";
        String str4 = "1234";

        String str5 = "ABCD" + "1234";
        String str6 = "ABCD" + str4;
        String str7 = str3 + str4;

        System.out.println(str1 == str2);//true
        System.out.println(str1 == "ABCD1234");//true

        System.out.println(str1 == str5);//true
        System.out.println(str1 == str6);//false
        System.out.println(str1 == str7);//false

        System.out.println(str1 == str6.intern());//true
        System.out.println(str1 == str7.intern());//true
    }
}
