package Algorithm.Sort;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * 直接选择排序
 *
 * @author xiaolong
 * @date 2019/6/6 11:14
 */
@SpringBootTest
public class StraightSelectionSort {
    public static void straightSelectionSort_Basic(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
