package 基本数据类型;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/*
 * @desc 数字
 * @author wjl
 * @date 2018/6/11 0011
 */
@SpringBootTest
public class number {
    /*
     * @desc 价格金额等建议用BigDecimal（参数为String类型的构造方法）
     * @author wjl
     * @date 2018/6/11 0011
     */
    @Test
    public void amount() {
        float f1 = 2.15f;
        float f2 = 1.10f;
        System.out.println("float类型运算结果：\n" + f1 + "-" + f2 + "=" + (f1 - f2) + "\n");
        //2.15-1.1=1.0500001

        BigDecimal bd1 = new BigDecimal("2.15");
        BigDecimal bd2 = new BigDecimal("1.10");
        System.out.println("BigDecimal,参数为String类型运算结果:\n" + bd1 + "-" + bd2 + "=" + bd1.subtract(bd2) + "\n");
        //2.15-1.10=1.05

        BigDecimal bd3 = new BigDecimal(2.15);
        BigDecimal bd4 = new BigDecimal(1.10);
        System.out.println("BigDecimal,参数为double类型时运算结果:\n" + bd3 + "-" + bd4 + "=" + bd3.subtract(bd4) + "\n");
        //2.149999999999999911182158029987476766109466552734375-1.100000000000000088817841970012523233890533447265625=1.049999999999999822364316059974953532218933105468750
    }
}
