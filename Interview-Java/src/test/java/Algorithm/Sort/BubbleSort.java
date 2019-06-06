package Algorithm.Sort;

/**
 * 冒泡排序
 *
 * @author xiaolong
 * @date 2019/6/6 11:40
 */
public class BubbleSort {
    /**
     * 从小到大排序，寻找其中最小的元素排在头
     */
    public void bubbleSort(int sums[]) {
        int temp = 0;
        for (int i = 0; i < sums.length; i++) {
            for (int j = i + 1; j < sums.length; j++) {
                if (sums[i] > sums[j]) {
                    temp = sums[i];
                    sums[i] = sums[j];
                    sums[j] = temp;
                }
            }
        }
    }

    /**
     * 加入标志性变量exchange，用于标志某一趟排序过程中是否有数据交换。
     */
    public void bubbleSort2(int sums[]) {
        int temp = 0;
        boolean exchange = false;
        int length = sums.length;

        do {
            exchange = false;
            length -= 1;
            for (int i = 0; i < length; i++) {
                if (sums[i] > sums[i + 1]) {
                    temp = sums[i];
                    sums[i] = sums[i + 1];
                    sums[i + 1] = temp;
                    exchange = true;
                }
            }
        } while (exchange);
    }
}
