package Algorithm;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

/**
 * 在字符串中找出连续最长的数字串
 *
 * @author xiaolong
 * @date 2019/6/14 15:12
 */
@SpringBootTest
public class FindMaxNum {
    @Test
    public void test() {
        String str = "A123A2A98A521A75A1A99A65478A2222A23A111A78A5A33A22A1A3432423A123211A123";
        findMaxNumByStr(str);
    }

    private String findMaxNumByStr(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }

        String result = "";

        char[] chars = str.toCharArray();
        int maxsize = 0;
        int count = 0;

        StringBuilder sb = new StringBuilder();
        for (char item : chars) {
            if (item >= '0' && item <= '9') {
                sb.append(item);
                count++;
            } else {
                if (count > 0) {
                    if (count > maxsize) {
                        result = sb.toString();
                        maxsize = count;
                        count = 0;
                    } else {
                        sb = new StringBuilder();
                        count = 0;
                    }
                }
            }
        }

        return result;
    }
}
