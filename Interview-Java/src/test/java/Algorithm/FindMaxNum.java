package Algorithm;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        String str = "A123CCCC2A98A521A75A1A99A65478A2222A23A111A78A5A33A22A1A3432423A123211A123";
        findMaxNumByStr2(str);
    }

    private String findMaxNumByStr(String str) {
        String result = "";

        if (StringUtils.isEmpty(str)) {
            return null;
        }

        int maxsize = 0;// 当前已知字符串的最大长度
        int count = 0;// 循环里字符串长度
        StringBuilder sb = new StringBuilder();

        char[] chars = str.toCharArray();
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

    private String findMaxNumByStr2(String str) {
        List<String> resultList = new ArrayList<>();

        if (StringUtils.isEmpty(str)) {
            return null;
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();

        char[] chars = str.toCharArray();
        for (char item : chars) {
            if (item >= '0' && item <= '9') {
                sb.append(item);
                count++;
            } else {
                if (count > 0) {
                    resultList.add(sb.toString());
                    sb = new StringBuilder();
                    count = 0;
                }
            }
        }

        resultList = resultList.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .collect(Collectors.toList());

        if (resultList.size() > 0) {
            return resultList.get(0);
        } else {
            return null;
        }
    }
}
