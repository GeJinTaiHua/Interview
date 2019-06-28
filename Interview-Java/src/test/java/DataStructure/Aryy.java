package DataStructure;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 数组
 *
 * @author xiaolong
 * @date 2019/6/28 9:03
 */
@SpringBootTest
public class Aryy {
    /**
     * 定义数组
     */
    @Test
    public void init() {
        /**一维数组**/
        //int[2] a;
        int[] a;
        int[] a1 = {1, 2, 3, 4, 5, 6};

        //int b[2];
        int b[];
        int b1[] = {1, 2, 3};

        String r[] = new String[]{"1", "2"};
        //String r1[] = new String[2]{"1"};
        String r1[] = new String[]{};

        /**多维数组**/
        //int[2][2] i;
        int[][] i;
        int[][] i1 = {{1}, {2, 3}};

        //int j[2][2];
        int j[][];
        int j1[][] = {{1, 1, 1}, {2}, {3, 3}};

        //String s[][] = new String[][];
        String s[][] = new String[2][];
        String s1[][] = new String[2][2];
        String s2[][] = new String[2][2];

    }
}
