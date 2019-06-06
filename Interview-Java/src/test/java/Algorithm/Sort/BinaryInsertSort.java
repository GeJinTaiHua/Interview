package Algorithm.Sort;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 二分插入排序
 * 1 3 2 7 5 4 8
 * 1 2 3 7 5 4 8
 * 1 2 3 7 5 4 8
 * 1 2 3 5 7 4 8
 * 1 2 3 4 8 7 8
 *
 * @author xiaolong
 * @date 2019/6/6 10:51
 */
@SpringBootTest
public class BinaryInsertSort {
    public static void binaryInsertSort_Base(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int low = 0, high = i - 1;
            int mid = -1;

            while (low <= high) {
                mid = low + (high - low) / 2;
                if (arr[mid] > temp) {
                    high = mid - 1;
                } else {
                    // 元素相同时，也插入在后面的位置
                    low = mid + 1;
                }
            }

            for (int j = i - 1; j >= low; j--) {
                arr[j + 1] = arr[j];
            }
            arr[low] = temp;
        }
    }

    @Test
    public void test() {
        int[] arr = {1, 3, 2, 7, 5, 4, 8};
        binaryInsertSort_Base(arr);
    }
}
