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
    public void Creat100Num() {
        Random rand = new Random();
        int result = rand.nextInt(100) + 1;
    }
}
