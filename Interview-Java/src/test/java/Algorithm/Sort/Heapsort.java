package Algorithm.Sort;

/**
 * 堆排序
 *
 * @author xiaolong
 * @date 2019/6/6 11:32
 */
public class Heapsort {
    /**
     * 堆排序的主要入口方法，共两步。
     */
    public static void sort(int[] arr) {
        /*
         * 第一步：将数组堆化 beginIndex = 第一个非叶子节点。 从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
		 * 叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
		 */
        int len = arr.length - 1;
        int beginIndex = (len - 1) >> 1;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(arr, i, len);
        }

		/*
         * 第二步：对堆化数据排序 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
		 * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。 直至未排序的堆长度为 0。
		 */
        for (int i = len; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, -0, i - 1);
        }
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     *
     * @param index 需要堆化处理的数据的索引
     * @param len   未排序的堆（数组）的长度
     */
    private static void maxHeapify(int[] arr, int index, int len) {
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1; // 右子节点索引
        int cMax = li; // 子节点值最大索引，默认左子节点。

        // 左子节点索引超出计算范围，直接返回。
        if (li > len) {
            return;
        }

        // 先判断左右子节点，哪个较大。
        if (ri <= len && arr[ri] > arr[li]) {
            cMax = ri;
        }

        if (arr[cMax] > arr[index]) {
            swap(arr, cMax, index); // 如果父节点被子节点调换，
            maxHeapify(arr, cMax, len); // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
