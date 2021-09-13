package chapterOne;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++){
            //当前被排序元素先暂存
            int insertValue = array[i];
            int j = i - 1;
            //从右向左比较元素的同时，进行元素复制（如果过条件成立，往后窜一个格子。）
            for (;(j >= 0) && (insertValue < array[j]);j--){
                array[j + 1] = array[j];
            }
            //比较结束时，将insertValue的值插入适当位置
            array[j + 1] = insertValue;
        }
    }
    public static void main(String[] args){
        int[] array = {12,1,3,46,5,0,-3,12,35,16};
        insertSort(array);
        System.out.printf(Arrays.toString(array));
    }
}
