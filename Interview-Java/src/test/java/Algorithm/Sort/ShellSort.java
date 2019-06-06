package Algorithm.Sort;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * 希尔排序
 *
 * @author xiaolong
 * @date 2019/6/5 18:36
 */
@SpringBootTest
public class ShellSort {
    /**
     * 基本写法
     *
     * @param arr 待排序的数组
     * @return 排序结果
     */
    public static int[] shellSort_Basic(int[] arr) {
        int d = arr.length;
        while (true) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < arr.length; i = i + d) {
                    int temp = arr[i];
                    int j;
                    for (j = i - d; j >= 0 && arr[j] > temp; j = j - d) {
                        arr[j + d] = arr[j];
                    }
                    arr[j + d] = temp;
                }
            }

            if (d == 1) {
                break;
            }
        }

        return arr;
    }
}
