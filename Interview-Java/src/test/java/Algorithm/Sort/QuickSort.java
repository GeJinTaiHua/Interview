package Algorithm.Sort;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * 快速排序
 *
 * @author xiaolong
 * @date 2019/6/6 11:48
 */
@SpringBootTest
public class QuickSort {
    /**
     * 基准取头法
     */
    public void quickSort1(int array[], int top, int tail) {
        if (top >= tail) {
            return;
        }

        int left = top, right = tail;
        int temp = array[left];// 数组的第一作为中轴
        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            array[left] = array[right];// 比中轴小的记录移动到低端
            while (left < right && array[left] < temp) {
                left++;
            }
            array[right] = array[left];
        }

        if (left == right) {
            array[left] = temp;
        }

        if (left != top) {
            quickSort1(array, 0, left - 1);
        }

        if (right != tail) {
            quickSort1(array, right + 1, array.length - 1);
        }
    }

    /**
     * 基准取尾法
     */
    public void quickSort2(int nums[], int top, int tail) {
        if (top >= tail) {
            return;
        }

        int mid = nums[tail];
        int left = top, right = tail - 1;
        while (left < right) {
            while (nums[left] < mid && left < right) {
                left++;
            }
            while (nums[right] >= mid && left < right) {
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        if (nums[left] >= nums[tail]) {
            int temp = nums[left];
            nums[left] = nums[tail];
            nums[tail] = temp;
        } else {
            left++;
        }

        quickSort2(nums, top, left - 1);
        quickSort2(nums, left + 1, tail);
    }

    /**
     * 基准取中法
     */
    public void quickSort3(int nums[], int top, int tail) {
        if (top >= tail) {
            return;
        }

        int left = top, right = tail, mid = nums[(top + tail) / 2];
        while (left <= right) {
            while (nums[left] < mid) {
                ++left;
            }
            while (nums[right] > mid) {
                --right;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                ++left;
                --right;
            } else if (left == right) {
                ++left;
            }
        }

        quickSort3(nums, top, right);
        quickSort3(nums, left, tail);
    }

    /**
     * 优化
     */
    public static void quickSort4(int[] nums, int top, int tail) {
        if (top >= tail) {
            return;
        }

        int lt = top, gt = tail, i = top + 1;
        int pivot = nums[top];
        while (i <= gt) {
            if (nums[i] > pivot) {
                exchange(nums, i, gt--);
            } else if (nums[i] < pivot) {
                exchange(nums, i++, lt++);
            } else {
                i++;
            }
        }

        quickSort4(nums, top, lt - 1);
        quickSort4(nums, gt + 1, tail);
    }

    private static void exchange(int[] sum, int i, int j) {
        int temp = sum[i];
        sum[i] = sum[j];
        sum[j] = temp;
    }
}
