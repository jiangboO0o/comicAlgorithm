package chapterOne;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    /**
     * 此函数为归并排序的拆分过程
     * 将要排序的数组拆分成两个小集合，一次一次拆分，相当于构建二叉树。
     * 代码是首先将数组拆分为两个数组，再对两个数组进行归并操作。
     * 归并排序的拆分过程本质相当于二叉树的后续遍历；
     * @param array
     * @param start
     * @param end
     */
    public static void mergeSort(int[] array, int start, int end){
        if (start < end){
            //折半成连个小集合，分别进行递归
            //此处还利用了整型数字最小间隔为1的特点，保证了最后一次拆分会拆成只有一个元素的数组。
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array,mid + 1, end);
            //把两个有序小集合，归并成一个大集合
            merge(array,start,mid,end);
        }
    }

    /**
     * 此函数为归并排序的归并规程
     * 相当于，传入数组的一个节选（数组，开始点，结束点），因为中间点mid的传入，也相当于是传入了两个分好的小数组。
     * 对这个节选数组进行归并操作，就是将两个小数组归并到一个临时数组，然后再从临时数组复制回大数组
     * @param array
     * @param start
     * @param mid
     * @param end
     */
    private static void merge(int[] array, int start, int mid, int end) {
        //开辟额外临时集合，设置指针
        int[] tempArray = new int[end - start + 1];
        int p1 = start;
        int p2 = mid + 1;
        int p = 0;
        //比较两个小集合的元素，依次放入临时集合
        while ((p1 <= mid) && (p2 <= end)){
            if (array[p1] <= array[p2]){
                //放入临时集合
                tempArray[p++] = array[p1++];
            }else {
                //放入临时集合
                tempArray[p++] = array[p2++];
            }
        }
        //左侧小集合还有剩余的话，依次放入临时集合尾部，如果没有剩余循环相当于没有执行
        while (p1 <= mid){
            tempArray[p++] = array[p1++];
        }
        //右侧小集合还有剩余的话，依次放入临时集合尾部，如果没有剩余循环相当于没有执行
        while (p2 <= end){
            tempArray[p++] = array[p2++];
        }
        //把临时集合的元素复制回原数组
        for (int i = 0; i < tempArray.length; i++){
            array[i + start] = tempArray[i];
        }
    }
    public static void main(String[] args){
        int[] array = {5,8,6,3,9,2,1,7};
        mergeSort(array,0,array.length - 1);
        System.out.printf(Arrays.toString(array));
    }
}
