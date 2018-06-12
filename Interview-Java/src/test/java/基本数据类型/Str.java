package 基本数据类型;

import org.apache.commons.lang3.StringUtils;
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

        // 虽然对于对一个动态创建的字符串（比如string+variable；variable+variable），驻留机制便不会起作用。
        // 但是我们可以手工的启用驻留机制——那就是调用定义的System.String中的静态方法Intern。
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

    /*
     * @desc apache commons lang包中的StringUtils工具
     * @author wjl
     * @date 2018/6/12 0012
     */
    @Test
    public void StringUtil() {
        // 空字符串检查
        String strIsBlank1 = "ACD";
        String strIsBlank2 = " ";
        String strIsBlank3 = null;
        StringUtils.isBlank(strIsBlank1);//false
        StringUtils.isBlank(strIsBlank2);//true
        StringUtils.isBlank(strIsBlank3);//true

        // 清除空白字符
        String strTrimToNull = "  A  Test  ";
        StringUtils.trimToNull(strTrimToNull);//A  Test

        // 计算某个字符的出现次数
        int n = StringUtils.countMatches("*12**2222*", "*");//4

        // 重复一个字符串
        String strRepeat = "ADCD";
        String strRepeatResult = StringUtils.repeat(strRepeat, 3);//ADCDADCDADCD

        // 拆分字符串
        String strSplit = "A*BDD*DA";
        String[] strSp = StringUtils.split(strSplit, "*");//A   BDD   DA

        // 颠倒字符串
        String strrRverse = "ABCDE";
        String strrRverseR = StringUtils.reverse(strrRverse);//EDCBA
    }
}
