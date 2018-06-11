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
public class Number {
    /*
     * @desc 价格金额等建议用BigDecimal（参数为String类型的构造方法）
     * @author wjl
     * @date 2018/6/11 0011
     */
    @Test
    public void Amount() {
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

    /*
     * @desc 四舍五入（推荐ROUND_HALF_UP）
     * BigDecimal ONE-- 值为1，使用刻度为0。
     * BigDecimal TEN--值为10，使用刻度为0。
     * BigDecimal ZERO--值为0，使用刻度为0。
     * ROUND_CEILING-- 舍入模式舍向正无穷。正数效果同ROUND_UP举例如：1.239得到的是1.24；负数效果举例如：-1.239得到的是-1.23
     * ROUND_DOWN-- 舍入模式，向零舍入（即舍弃后边所有，不向前进1）。
     * ROUND_FLOOR-- 舍入模式接近负无穷大。正数效果同ROUND_DOWN举例如：1.239得到的是1.23；负数效果举例如：-1.239得到的是-1.23
     * ROUND_HALF_DOWN-- 遵循四舍五入规则，大于5向前一位进1。
     * ROUND_HALF_EVEN-- 舍入模式舍对“近邻”如果与两个相邻数字的距离相等，在这种情况下，舍入向着更加相邻（正负数都是向着0相邻舍入）。
     * ROUND_HALF_UP-- 遵循四舍五入规则，大于等于5向前一位进1。
     * ROUND_UNNECESSARY-- 舍入模式断言请求的操作具有精确的结果，因此不需要舍入。用于获取运算结果。
     * ROUND_UP--舍入模式，舍入去零，零不舍入。
     * @author wjl
     * @date 2018/6/11 0011
     */
    @Test
    public void Rounding() {
        BigDecimal bd = new BigDecimal("1.125");

        // 直接删除多余的小数位
        System.out.println("ROUND_DOWN:" + bd.setScale(2, BigDecimal.ROUND_DOWN));//1.12
        // 进位
        System.out.println("ROUND_UP:" + bd.setScale(2, BigDecimal.ROUND_UP));//1.13
        // 四舍五入，逢5进位
        System.out.println("ROUND_HALF_UP:" + bd.setScale(2, BigDecimal.ROUND_HALF_UP));//1.13
        // 四舍五入，逢5舍弃
        System.out.println("ROUND_HALF_DOWN:" + bd.setScale(2, BigDecimal.ROUND_HALF_DOWN));//1.12
    }
}
