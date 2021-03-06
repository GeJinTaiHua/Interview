package Algorithm.Sort;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 插入排序
 * [12] 15 9 20 6 31 24
 * [12 15] 9 20 6 31 24
 * [9 12 15] 20 6 31 24
 * [9 12 15 20] 6 31 24
 * [6 9 12 15 20] 31 24
 * [6 9 12 15 20 31] 24
 * [6 9 12 15 20 24 31]
 *
 * @author xiaolong
 * @date 2019/6/5 18:30
 */
@SpringBootTest
public class InsertionSort {
    @Test
    public void test() {
        int[] test = new int[]{12, 15, 9, 20, 6, 31, 24};
        insertSort_Basic(test);
    }

    /**
     * 基本写法
     *
     * @param arr 待排序的数组
     * @return 排序结果
     */
    public static int[] insertSort_Basic(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }

        return arr;
    }

    /**
     * 哨兵
     *
     * @param arr 待排序的数组
     * @return 排序结果
     */
    public static int[] insertSort_Sentry(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int indx = 0;
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    indx = j - 1;
                } else {
                    break;
                }
                arr[indx] = temp;
            }
        }

        return arr;
    }
}
