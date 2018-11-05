package Algorithm;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

/*
 * @desc 随机数
 * @author wjl
 * @date 2018/9/13 0013
 */
@SpringBootTest
public class RandomNum {
    
    /*
     * @desc 产生1-100内的随机数
     * @author wjl
     * @date 2018/9/13 0013
     */
    @Test
    public void get100Num() {
        Random rand = new Random();
        int result = rand.nextInt(100) + 1;
    }

    /*
     * @desc  MIN 和 MAX 范围内的随机数
     * @author wjl
     * @date 2018/9/13 0013
     */
    public int getRandNum(int min, int max) {
        int randNum = (int) (Math.random() * ((max - min) + 1)) + min;
        return randNum;
    }

    /*
     * @desc 生成 length长度 的随机数字和字母
     * @author wjl
     * @date 2018/9/13 0013
     */
    public String getStringRandom(int length) {
        String result = "";
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            // 字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";

            if ("char".equals(charOrNum)) {
                // 大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                result += (char) (random.nextInt(26) + temp);
            } else if ("num".equals(charOrNum)) {
                result += String.valueOf(random.nextInt(10));
            }
        }

        return result;
    }

}
