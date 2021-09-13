package chapterOne;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void shellSort(int[] array){
        //希尔排序的增量
        int d = array.length;
        //此层循环是用于分组，第一次分两组，依次按间距除2的方式，四组，8组，16组，直到组间距为1，结束循环
        while (d > 1){
            //使用希尔增量的方式，即每次折半
            d = d / 2;
            //相当于循环的组号，x=0是第一组，1是第二组
            for (int x = 0; x < d; x++){
                //开始插入排序
                //这层循环是，每组的插入排序，注意：插入排序从每组第二个元素开始排，第一个不用排。
                for (int i = x + d; i < array.length; i = i + d){
                    int temp = array[i];
                    int j;
                    //插入排序核心代码
                    //从右向左比较元素的同时，进行元素复制（如果过条件成立，往后窜一个格子。）
                    for (j = i - d; (j >= 0)&&(array[j] > temp); j = j - d){
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] array = {5,3,9,12,6,1,7,2,4,11,8,10};
        shellSort(array);
        System.out.printf(Arrays.toString(array));
    }
}
